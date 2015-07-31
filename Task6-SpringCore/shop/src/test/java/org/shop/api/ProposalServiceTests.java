package org.shop.api;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shop.common.Products;
import org.shop.data.Product;
import org.shop.data.Seller;
import org.shop.data.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml"})
public class ProposalServiceTests {

    @Autowired
    ProposalService proposalService;

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    Long sellerId = 1l;
    Long productId;
    Long proposalId;

    @Before
    public void setUp(){
        Seller seller = new Seller();
        seller.setId(sellerId);
        sellerService.importSellers(Arrays.asList(seller));

        Product product = new Product();
        product.setName(Products.KINDLE_TOUCH);
        productId = productService.createProduct(product);
        proposalId = proposalService.createProposal(sellerId, productId, 100500.0);
    }

    @Test
    public void testCreateProposal(){
        Assert.assertTrue(proposalId > 0);
    }

    @Test
    public void testDeactivateProposal(){
        Long proposalId = proposalService.getProposalsBySellerId(sellerId).get(0).getId();
        proposalService.deactivateProposal(proposalId);

        Assert.assertEquals(State.NOT_ACTIVE_PROPOSAL, proposalService.getProposalsBySellerId(sellerId).get(0).getState());
    }

    @Test
    public void testActivateProposal(){
        Long proposalId = proposalService.getProposalsBySellerId(sellerId).get(0).getId();
        proposalService.activateProposal(proposalId);

        Assert.assertEquals(State.ACTIVE_PROPOSAL, proposalService.getProposalsBySellerId(sellerId).get(0).getState());
    }

    @Test
    public void testGetProposalsByProduct(){
        Assert.assertNotNull(proposalService.getProposalsByProduct(productService.getProductsByName(Products.KINDLE_TOUCH).get(0)));
    }

    @Test
    public void testGetProposalsByProductId(){
        Long productId = productService.getProductsByName(Products.KINDLE_TOUCH).get(0).getId();
        Assert.assertNotNull(proposalService.getProposalsByProductId(productId));
    }

    @Test
    public void testGetProposalsBySeller(){
        Assert.assertNotNull(proposalService.getProposalsBySeller(sellerService.getSellerById(sellerId)));
    }

    @Test
    public void testGetProposalsBySellerId(){
        Assert.assertNotNull(proposalService.getProposalsBySellerId(sellerId));
    }
}
