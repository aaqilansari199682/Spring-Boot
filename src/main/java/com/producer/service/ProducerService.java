package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.swing.*;

@Service
public class ProducerService {
    @Autowired
    KafkaTemplate<String, Object> template;

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, Object>> send = template.send("kafka-topic-5", message);
        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("ERROR!  fail to send message"+ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("SUCCESS!  message send successfully"+result);
            }
        });

//       send.isDone((result,ex)->
//        {
//            if(ex==null)
//            {
//                System.out.println("produce message ["+message+"with offset"+result.getRecordMetadata().offset()+"]");
//            }
//            else
//            {
//                System.out.println("Unnable to send message ["+message+"]due to"+ex.);
//            }
//        });
    }
}
