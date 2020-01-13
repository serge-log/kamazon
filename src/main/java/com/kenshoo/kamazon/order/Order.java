package com.kenshoo.kamazon.order;

import javax.persistence.Column;

public class Order {
    @Column(name = "id")
    public Integer id;
    @Column(name = "user_name")
    public String userName;
    @Column(name = "price")
    public int price;
    @Column(name = "url")
    public String url;
    @Column(name = "slack_id")
    public String slackId;
    @Column(name = "group_id")
    public String groupId;
    @Column(name = "is_admin")
    public boolean isAdmin;
    @Column(name = "status")
    public String status;

    public Order() {
    }

    public Order(Integer id, String userName, int price, String url, String slackId, String groupId, boolean isAdmin, OrderStatus status) {
        this.id = id;
        this.userName = userName;
        this.price = price;
        this.url = url;
        this.slackId = slackId;
        this.groupId = groupId;
        this.isAdmin = isAdmin;
        this.status = status.name();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        this.status = status.name();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "url='" + url + '\'' +
                ", price=" + price +
                ", userName='" + userName + '\'' +
                ", slackId='" + slackId + '\'' +
                '}';
    }

}

