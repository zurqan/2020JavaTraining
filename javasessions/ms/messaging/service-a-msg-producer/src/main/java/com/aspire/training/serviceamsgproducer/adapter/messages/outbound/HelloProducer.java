package com.aspire.training.serviceamsgproducer.adapter.messages.outbound;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HelloProducer {

    String OUTPUT_CHANNEL="hello-channel";

    @Output(OUTPUT_CHANNEL)
    MessageChannel output();
}
