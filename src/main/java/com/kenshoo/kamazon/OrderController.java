package com.kenshoo.kamazon;

import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderDto;
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
    @RequestMapping(path = "/order", method = RequestMethod.GET)
    public String updateEvent() {
        return "DAS IS VORKING";
    }

    @ResponseBody
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public String updateEvent(HttpServletRequest request,
                              @RequestBody OrderDto orderDto){
        return "DAS IS VORKING " + orderDto.toString();
    }
}
