package com.kenshoo.kamazon.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class OrderListUtilTest {

    @Test
    public void contextLoads() {
        List<Order> orderList = Arrays.asList(getOrderWithPrice(13),
                getOrderWithPrice(50),
                getOrderWithPrice(4),
                getOrderWithPrice(5));
        List<Order> orders = OrderListUtil.sum_up(orderList, 49, 75);
    }

    private static Order getOrderWithPrice(int price) {
        Order order = new Order();
        order.setPrice(price);
        return order;
    }

}