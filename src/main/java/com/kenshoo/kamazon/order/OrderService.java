package com.kenshoo.kamazon.order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

}
