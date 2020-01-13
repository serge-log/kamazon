package com.kenshoo.kamazon.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void contextLoads() {
        Order orderWithPrice = getOrderWithPrice(20);
        Order orderWithPrice1 = getOrderWithPrice(2);
        Order orderWithPrice2 = getOrderWithPrice(4);
        Order orderWithPrice3 = getOrderWithPrice(17);
        Order orderWithPrice9 = getOrderWithPrice(1);
        Order orderWithPrice4 = getOrderWithPrice(21);
        Order orderWithPrice5 = getOrderWithPrice(5);
        Order orderWithPrice6 = getOrderWithPrice(40);
        Order orderWithPrice7 = getOrderWithPrice(2);
        Order orderWithPrice8 = getOrderWithPrice(47);
        List<Order> orderList = Arrays.asList(orderWithPrice, orderWithPrice1, orderWithPrice2, orderWithPrice3, orderWithPrice9, orderWithPrice4, orderWithPrice5, orderWithPrice6, orderWithPrice7, orderWithPrice8);
        List<Order> orders = OrderListUtil.sum_up(orderList, 49, 75);
    }

    private static Order getOrderWithPrice(int price) {
        Order order = new Order();
        order.setPrice(price);
        return order;
    }

}