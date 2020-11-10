package com.aspire.training.serviceamsgconsumer.adapter.messages.inbound;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReceivedMessage {
    private String msg;
    private String userName;
    private String id;
}
