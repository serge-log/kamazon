package com.kenshoo.kamazon.order;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

public class Order {
    @Column(name = "id")
    public int id;
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
    public Boolean admin;

    public Order() {
    }

    public Order(int id, String userName, int price, String url, String slackId, String groupId, boolean admin) {
        this.id = id;
        this.userName = userName;
        this.price = price;
        this.url = url;
        this.slackId = slackId;
        this.groupId = groupId;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonIgnore
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

