package com.kenshoo.kamazon.order;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderDao {

    @Resource
    private DefaultDSLContext defaultDSLContext;


}
