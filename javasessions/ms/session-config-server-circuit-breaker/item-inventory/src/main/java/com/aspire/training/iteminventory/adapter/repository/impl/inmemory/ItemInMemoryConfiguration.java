package com.aspire.training.iteminventory.adapter.repository.impl.inmemory;

import com.aspire.training.iteminventory.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "db.in-memory",name = "enabled",matchIfMissing = true)
public class ItemInMemoryConfiguration {

    @Bean
    public ItemRepository itemRepository(){
        return new ItemInMemoryRepositoryImpl();
    }
}
