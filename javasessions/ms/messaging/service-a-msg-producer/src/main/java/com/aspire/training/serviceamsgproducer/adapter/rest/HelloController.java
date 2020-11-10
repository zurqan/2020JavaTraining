package com.aspire.training.serviceamsgproducer.adapter.rest;

import com.aspire.training.serviceamsgproducer.adapter.messages.outbound.HelloProducer;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hello")
@EnableBinding(HelloProducer.class)
public class HelloController {
    private final HelloProducer helloProducer;

    public HelloController(HelloProducer helloProducer) {
        this.helloProducer = helloProducer;
    }

    @PostMapping("/{name}")
    public void sendingHello(@PathVariable("name") String name) {
//        Message<String> message = MessageBuilder
//                .withPayload("Hello " + name)
//                .build();

        HelloMessage msg = HelloMessage
                .builder()
                .id(UUID.randomUUID().toString())
                .userName(name)
                .msg(String.format("Hello %s !", name))
                .build();

        helloProducer
                .output()
                .send(MessageBuilder.withPayload(msg).build());

    }


}
