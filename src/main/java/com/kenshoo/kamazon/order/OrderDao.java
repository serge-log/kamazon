package com.kenshoo.kamazon.order;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Service
public class OrderDao {

    public static final String TABLE_NAME = Orders.TABLE_NAME;

    @Resource
    private DefaultDSLContext dslContext;

    public List<Order> getAllWaitingOrders() {
        return dslContext.select()
                .from(table(TABLE_NAME))
                .where(field("status").eq(OrderStatus.WAITING.name()))
                .fetchInto(Order.class);
    }

    public int saveOrder(Order order) {
        return dslContext.insertInto(table(TABLE_NAME))
                .set(field("user_name"), order.getUserName())
                .set(field("price"), order.getPrice())
                .set(field("url"), order.getUrl())
                .set(field("slack_id"), order.getSlackId())
                .set(field("group_id"), order.getGroupId())
                .set(field("is_admin"), order.getAdmin())
                .set(field("status"), order.getStatus().name())
                .execute();
    }

    public int updateStatusAndGroupIdByOrderIds(List<Integer> orderIds, OrderStatus orderStatus, String groupId) {
        return dslContext.update(table(TABLE_NAME))
                .set(field("status"), orderStatus.name())
                .set(field("group_id"), groupId)
                .where(field("id").in(orderIds))
                .execute();
    }
}
