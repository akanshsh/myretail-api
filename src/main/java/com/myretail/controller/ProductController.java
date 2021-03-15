package com.myretail.controller;

import com.myretail.model.PriceBean;
import com.myretail.model.ProductBean;
import com.myretail.model.db.Price;
import com.myretail.model.db.Product;
import com.myretail.repository.PriceRepository;
import com.myretail.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/all")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceRepository priceRepository;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductBean> getProductById(@PathVariable("id") String id) {
        try {
            Optional<Product> productData = productRepository.findBy_id(new ObjectId(id));
            Optional<Price> priceData = priceRepository.findByProductId(new ObjectId(id));
            if (productData.isPresent() && priceData.isPresent()) {
                Product product = productData.get();
                Price price = priceData.get();

                return new ResponseEntity<>(new ProductBean(product.get_id(), product.getName(),
                        new PriceBean(price.getPrice(), price.getCurrencyCode())), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductBean> updateProductById(@PathVariable("id") String id, @Validated @RequestBody ProductBean productBean) {
        try {
            Optional<Product> productData = productRepository.findBy_id(new ObjectId(id));
            Optional<Price> priceData = priceRepository.findByProductId(new ObjectId(id));
            if (productData.isPresent() && priceData.isPresent()) {
                Product product = productData.get();
                Price price = priceData.get();

                product.setName(productBean.getName());
                PriceBean priceBean = productBean.getCurrentPrice();
                price.setPrice(priceBean.getPrice());
                price.setCurrencyCode(priceBean.getCurrencyCode());

                productRepository.save(product);
                priceRepository.save(price);

                return new ResponseEntity<>(new ProductBean(product.get_id(), product.getName(),
                        new PriceBean(price.getPrice(), price.getCurrencyCode())), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
