package com.kenshoo.kamazon.order;

public class OrderDto {
    public String url;
    public int price;
    public String userName;

    public OrderDto(String url, int price, String userName, String slackId) {
        this.url = url;
        this.price = price;
        this.userName = userName;
        this.slackId = slackId;
    }

    public String slackId;

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

