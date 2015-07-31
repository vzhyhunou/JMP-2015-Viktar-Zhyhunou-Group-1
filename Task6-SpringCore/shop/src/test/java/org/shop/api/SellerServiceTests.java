package org.shop.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shop.common.Sellers;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml"})
public class SellerServiceTests {

    @Autowired
    SellerService sellerService;

    @Test
    public void testGetSellers(){
        List<Seller> sellers = new ArrayList<Seller>();
        Seller seller = new Seller();
        seller.setId(1l);
        sellers.add(seller);

        sellerService.importSellers(sellers);

        Assert.assertTrue(sellerService.getSellers().size() > 0);
    }

    @Test
    public void testGetSellerById(){
        List<Seller> sellers = new ArrayList<Seller>();
        Seller seller = new Seller();
        seller.setId(2l);
        sellers.add(seller);

        sellerService.importSellers(sellers);

        Assert.assertNotNull(sellerService.getSellerById(2l));
    }

    @Test
    public void testImportSellers(){
        Seller seller = new Seller();
        seller.setId(3l);
        seller.setName(Sellers.SAMSUNG);

        sellerService.importSellers(Arrays.asList(seller));

        seller = sellerService.getSellerById(3l);
        seller.setName(Sellers.AMAZON);

        sellerService.importSellers(Arrays.asList(seller));

        seller = sellerService.getSellerById(3l);

        Assert.assertEquals(Sellers.AMAZON, seller.getName());
    }
}
