package com.aspire.training.iteminventory.adapter.rest.exception;


import com.aspire.training.iteminventory.exceptions.AbstractTrainingException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Component
@ConfigurationProperties(prefix = "com.aspire.training")
public class AllErrorMessages {

    private Map<String,ErrorInfo> errorMsgs  = new HashMap<>();

    public Optional<ErrorInfo> byClass(AbstractTrainingException e){
        return Optional.ofNullable(errorMsgs
                .get(e.getClass().getSimpleName()));
    }
}
