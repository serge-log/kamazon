package com.kenshoo.kamazon.order;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.jooq.impl.DSL.table;

@Service
public class OrderDao {

    @Resource
    private DefaultDSLContext defaultDSLContext;

    public List<Order> getAllOrders() {
        return defaultDSLContext.select().from(table("orders")).fetchInto(Order.class);
    }
}
