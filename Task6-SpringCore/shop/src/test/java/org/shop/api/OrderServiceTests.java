package org.shop.api;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shop.data.Item;
import org.shop.data.Order;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.shop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml"})
public class OrderServiceTests {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;
    
    @Test
    public void testCreateOrderUserItemArray() {
        User user = new User();
        Item item = new Item();

        Assert.assertTrue(orderService.createOrder(user, item) > 0);
    }

    @Test
    public void testCreateOrderUserProposalArray() {
        User user = new User();
        Proposal proposal = new Proposal();
        proposal.setProduct(new Product());
        proposal.setPrice(100500.0);

        Assert.assertTrue(orderService.createOrder(user, proposal) > 0);
    }

    @Test
    public void testGetOrderById() {
        User user = new User();
        user.setUsername("Ivan Ivanov");
        Item item = new Item();

        Long orderId = orderService.createOrder(user, item);

        Order savedOrder = orderService.getOrderById(orderId);

        Assert.assertNotNull(savedOrder);
        Assert.assertEquals("Ivan Ivanov", savedOrder.getUser().getUsername());
    }

    @Test
    public void testUpdateOrder() {
        User user = new User();
        Item item = new Item();

        Long orderId = orderService.createOrder(user, item);
        Order savedOrder = orderService.getOrderById(orderId);

        Calendar c = Calendar.getInstance();
        c.setTime(savedOrder.getCreatedDate());
        c.add(Calendar.DATE, 1);
        savedOrder.setCreatedDate(c.getTime());

        orderService.updateOrder(savedOrder);
        savedOrder = orderService.getOrderById(orderId);

        Assert.assertEquals(c.getTime(), savedOrder.getCreatedDate());
    }

    @Test
    public void testGetOrdersByUser() {
        User user = new User();
        userService.registerUser(user);
        Item item = new Item();

        orderService.createOrder(user, item);

        Assert.assertTrue(orderService.getOrdersByUser(user).size() > 0);
    }

    @Test
    public void testGetOrdersByUserId() {
        User user = new User();
        Long userId = userService.registerUser(user);
        Item item = new Item();

        orderService.createOrder(user, item);

        Assert.assertTrue(orderService.getOrdersByUserId(userId).size() > 0);
    }
}
