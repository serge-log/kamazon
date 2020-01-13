package com.kenshoo.kamazon;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderRequest {

    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("text")
    private String text;

    public OrderRequest() {
    }

    public OrderRequest(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
