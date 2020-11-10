package com.aspire.training.iteminventory.adapter.repository.impl.mongo;

import com.aspire.training.iteminventory.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "com.aspire.training.db.mongo",name = "enabled")
public class ItemMongoRepositoryConfiguration {


    @Bean
    public ItemRepository itemRepository(ItemNoSQLRepository itemNoSQLRepository){

        return new ItemMongoRepositoryImpl(itemNoSQLRepository);

    }
}
