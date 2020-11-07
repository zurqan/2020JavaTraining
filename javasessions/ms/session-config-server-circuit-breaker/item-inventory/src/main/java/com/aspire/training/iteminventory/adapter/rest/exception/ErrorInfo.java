package com.aspire.training.iteminventory.adapter.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

    private int errorCode;

    private int restStatus;

    private Map<Lang,String> msgs;
}
