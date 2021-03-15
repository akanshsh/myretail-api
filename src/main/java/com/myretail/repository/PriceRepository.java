package com.myretail.repository;

import com.myretail.model.db.Price;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PriceRepository extends MongoRepository<Price, String> {
    Optional<Price> findByProductId(ObjectId id);
}
