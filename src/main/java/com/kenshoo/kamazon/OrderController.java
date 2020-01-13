package com.kenshoo.kamazon;

import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public String updateEvent(HttpServletRequest request,
                           @RequestBody String url,
                           @RequestBody int price,
                           @RequestBody String userName,
                           @RequestBody String slackId) {
        return "DAS IS VORKING ${request.toString()} ${url} ${price} ${userName} ${slackId}";
    }
}
