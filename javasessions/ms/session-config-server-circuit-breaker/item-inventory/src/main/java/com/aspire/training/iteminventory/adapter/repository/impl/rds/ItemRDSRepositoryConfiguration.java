package com.aspire.training.iteminventory.adapter.repository.impl.rds;

import com.aspire.training.iteminventory.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "com.aspire.training.db.rds" ,name="enabled",matchIfMissing = false)
public class ItemRDSRepositoryConfiguration {

    @Bean
    public ItemRepository itemRepository(ItemRepositoryRDS itemRepositoryRDS){

        return new ItemRepositoryRDSImpl(itemRepositoryRDS);
    }
}
