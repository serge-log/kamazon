package com.kenshoo.kamazon;

import com.kenshoo.kamazon.messages.MatchMessageService;
import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public String updateEvent(HttpServletRequest request) throws IOException {
        String msg = request.getReader().lines().collect(Collectors.toList()).toString();
        logger.info(msg);
        return "DAS IS VORKING " + msg;
    }

}
