package com.myretail.products;

import com.myretail.controller.ProductController;
import com.myretail.model.PriceBean;
import com.myretail.model.ProductBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsApplicationTests {

	@Autowired
	private ProductController productController;

	@Test
	public void whenFindById() {
		ResponseEntity<ProductBean> productBeanResponseEntity = productController.getProductById("123");
		Assert.assertEquals(productBeanResponseEntity.getStatusCode().is2xxSuccessful(),true);
	}

	@Test
	public void whenUpdateProduct() {
		PriceBean priceBean = new PriceBean(50,"USD");
		ProductBean product = new ProductBean("1","testProduct",priceBean);
		ResponseEntity<ProductBean> productBeanResponseEntity = productController.updateProductById("123",product);
		Assert.assertEquals(productBeanResponseEntity.getStatusCode().is2xxSuccessful(),true);
	}
}
