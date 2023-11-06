package com.producer.controller;

import com.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    ProducerService producerService;
    @GetMapping("/publish/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message)
    {
        try {
            producerService.sendMessage(message);
            return ResponseEntity.ok("message successfully send !!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
