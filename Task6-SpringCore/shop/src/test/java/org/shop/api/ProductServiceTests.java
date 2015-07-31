package org.shop.api;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shop.common.Products;
import org.shop.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml"})
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void testGetProductById(){
        Product product = new Product();
        product.setName(Products.KINDLE_TOUCH);

        Long productId = productService.createProduct(product);

        Product savedProduct = productService.getProductById(productId);

        Assert.assertNotNull(savedProduct);
        Assert.assertEquals(Products.KINDLE_TOUCH, savedProduct.getName());
    }

    @Test
    public void testGetProducts(){
        productService.createProduct(new Product());

        Assert.assertTrue(productService.getProducts().size() > 0);
    }

    @Test
    public void testGetProductsByName(){
        Product product = new Product();
        product.setName(Products.SAMSUNG_GALAXY_ACE);

        Long productId = productService.createProduct(product);

        Assert.assertEquals(productId, productService.getProductsByName(Products.SAMSUNG_GALAXY_ACE).get(0).getId());
    }

    @Test
    public void testCreateProduct(){
        Assert.assertTrue(productService.createProduct(new Product()) > 0);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        product.setName(Products.KINDLE_TOUCH);

        Long productId = productService.createProduct(product);
        Product savedProduct = productService.getProductById(productId);

        savedProduct.setName(Products.KINDLE_FIRE);

        productService.updateProduct(savedProduct);
        savedProduct = productService.getProductById(productId);

        Assert.assertEquals(Products.KINDLE_FIRE, savedProduct.getName());
    }

    @Test
    public void testDeleteProduct(){
        Long productId = productService.createProduct(new Product());

        productService.deleteProduct(productId);

        Assert.assertEquals(null, productService.getProductById(productId));
    }
}
