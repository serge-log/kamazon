package com.kenshoo.kamazon.messages;

import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stasg on 1/13/20
 */
@RunWith(MockitoJUnitRunner.class)
public class MatchMessageServiceTest {

    @InjectMocks
    MatchMessageService matchMessageService;

    @Before
    public void m2() {
        System.out.println("Using @Before annotations ,executed before each test cases ");
    }

    @Test
    public void test() throws Exception {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "yoel.ganapol", 5, "http://www.test.com", "fdff", "gggfr", true, OrderStatus.WAITING));
        orders.add(new Order(1, "stas.gorodetsky", 50, "http://www.test.com", "fdff", "gggfr", true, OrderStatus.WAITING));
        orders.add(new Order(1, "serge.logunov", 52, "http://www.test.com", "fdff", "gggfr", true, OrderStatus.WAITING));
        orders.add(new Order(1, "dana.cohen", 53, "http://www.test.com", "fdff", "gggfr", true, OrderStatus.WAITING));
        Order adminOrder = new Order();
        adminOrder.setUserName("admin");
        matchMessageService.sendMessage(orders, adminOrder);
    }
}