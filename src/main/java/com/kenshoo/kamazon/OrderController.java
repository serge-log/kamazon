package com.kenshoo.kamazon;

import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class OrderController {

    public static final int PRICE_INDEX = 0;
    public static final int URL_INDEX = 1;
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public String updateEvent(HttpServletRequest request) {
        try {
            String userName = request.getParameter("user_name");
            logger.info("request userName: " + userName);
            String text = request.getParameter("text");
            logger.info("request text: " + text);
            String[] orderParams = text.split(" ");
            Order order = new Order();
            order.setUserName(userName);
            order.setPrice(Double.parseDouble(orderParams[PRICE_INDEX]));
            order.setUrl(orderParams[URL_INDEX]);
            logger.info("Attempting saving of order: " + order);
            orderService.saveOrderAndFindMatch(order);
        } catch (Exception e) {
            logger.error("Error while saving new order", e);
            return "Service is currently unavailable, please contact management team";
        }
        return "ACCEPTED";
    }

}
