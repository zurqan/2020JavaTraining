package com.aspire.training.es.iteminventory.adapter.repository.impl.inmemory;

import com.aspire.training.es.iteminventory.adapter.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "com.aspire.db.in-memory",name = "enabled",matchIfMissing = true)
public class ItemInMemoryRepoConfiguration {

    @Bean
    public ItemRepository itemRepository(){
        return new InMemoryRepositoryImpl();
    }
}
