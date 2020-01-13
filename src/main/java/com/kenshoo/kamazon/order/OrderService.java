package com.kenshoo.kamazon.order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;
}
