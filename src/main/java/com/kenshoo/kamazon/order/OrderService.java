package com.kenshoo.kamazon.order;

import com.kenshoo.kamazon.messages.MatchMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    private static final BigDecimal MIN_RATE = BigDecimal.valueOf(48);
    private static final BigDecimal MAX_RATE = BigDecimal.valueOf(75);

    @Resource
    private MatchMessageService matchMessageService;

    @Resource
    private OrderDao orderDao;

    public Optional<Order> saveOrderAndFindMatch(Order order) throws Exception {
        order.setStatus(OrderStatus.WAITING);
        int isSuccessful = orderDao.saveOrder(order);
        if (isSuccessful > 0) {
            List<Order> waitingOrders = orderDao.getAllWaitingOrders();
            List<Order> resultMatch = OrderListUtil.sum_up(waitingOrders, MIN_RATE.intValue(), MAX_RATE.intValue());
            if (resultMatch != null && resultMatch.size() > 0) {
                String groupId = UUID.randomUUID().toString();
                Order adminOrder = setAdmin(resultMatch);
                orderDao.updateAdminById(adminOrder.getId()); //TODO: check if failed
                int result = orderDao.updateStatusAndGroupIdByOrderIds(resultMatch.stream().map(Order::getId).collect(toList()), OrderStatus.MATCHED, groupId);
                if (result > 0) {
                    matchMessageService.sendMessage(resultMatch,adminOrder);
                    return Optional.of(order);
                } else {
                    logger.error("Could not update status for orders: " + resultMatch);
                    return Optional.empty();
                }
            }
            return Optional.empty();
        } else {
            logger.error("Could not save order: " + order);
            return Optional.empty();
        }
    }

    private Order setAdmin(List<Order> resultMatch) {
        Order adminOrder = resultMatch.get(0);
        for (Order order : resultMatch) {
            if (order.getPrice() > adminOrder.getPrice())
                adminOrder = order;
        }
        adminOrder.setAdmin(Boolean.TRUE);
        return adminOrder;
    }

}
