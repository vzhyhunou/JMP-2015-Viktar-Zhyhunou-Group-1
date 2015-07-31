package org.shop.api;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shop.data.Item;
import org.shop.data.Order;
import org.shop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml"})
public class ItemServiceTests {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @Test
    public void testCreateItem(){
        Item item = new Item();
        item.setOrder(new Order());

        Assert.assertTrue(itemService.createItem(item) > 0);
    }

    @Test
    public void testDeleteItem(){
        User user = new User();
        Item item = new Item();

        Long orderId = orderService.createOrder(user, item);
        Assert.assertEquals(1, itemService.getItemsByOrderId(orderId).size());

        itemService.deleteItem(item.getId());
        Assert.assertEquals(0, itemService.getItemsByOrderId(orderId).size());
    }

    @Test
    public void testGetItemsByOrderId(){
        User user = new User();
        Item item = new Item();

        Long orderId = orderService.createOrder(user, item);

        Assert.assertEquals(item.getId(), itemService.getItemsByOrderId(orderId).get(0).getId());
    }
}
