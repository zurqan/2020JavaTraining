package com.aspire.training.iteminventory.configuration;

import com.aspire.training.iteminventory.repository.ItemRepository;
import com.aspire.training.iteminventory.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public ItemService itemService(ItemRepository itemRepository){
        return new ItemService(itemRepository);
    }
}
