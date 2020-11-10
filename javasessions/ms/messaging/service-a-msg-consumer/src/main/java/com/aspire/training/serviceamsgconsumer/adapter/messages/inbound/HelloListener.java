package com.aspire.training.serviceamsgconsumer.adapter.messages.inbound;

import lombok.Builder;
import lombok.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(HelloConsumer.class)
public class HelloListener {

    @StreamListener(HelloConsumer.INPUT_CHANNEL)
    public void receivingHelloMessage(ReceivedMessage msg){
        System.out.println("msg = " + msg);
    }



}
