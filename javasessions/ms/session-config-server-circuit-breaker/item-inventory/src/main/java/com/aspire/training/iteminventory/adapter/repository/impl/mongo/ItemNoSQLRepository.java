package com.aspire.training.iteminventory.adapter.repository.impl.mongo;

import com.aspire.training.iteminventory.adapter.repository.impl.mongo.collections.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemNoSQLRepository extends MongoRepository<ItemDocument,String> {
    List<ItemDocument> findByShortDescContaining(String desc);
}
