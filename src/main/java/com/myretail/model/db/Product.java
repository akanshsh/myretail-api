package com.myretail.model.db;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private ObjectId _id;

    private String name;

    public Product(ObjectId _id, String name) {
        super();
        this._id = _id;
        this.name = name;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [_id=" + _id + ", name=" + name + "]";
    }
}
