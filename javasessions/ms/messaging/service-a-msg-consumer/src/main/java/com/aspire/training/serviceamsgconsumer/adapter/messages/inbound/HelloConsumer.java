package com.aspire.training.serviceamsgconsumer.adapter.messages.inbound;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HelloConsumer {

    String INPUT_CHANNEL="hello-input-channel";

    @Input(INPUT_CHANNEL)
    SubscribableChannel input();
}
