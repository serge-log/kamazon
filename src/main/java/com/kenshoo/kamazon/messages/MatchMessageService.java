package com.kenshoo.kamazon.messages;

import com.google.gson.Gson;
import com.kenshoo.kamazon.HashUtils;
import com.kenshoo.kamazon.order.Order;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by stasg on 1/13/20
 */

@Service
public class MatchMessageService {

    private Logger logger = LoggerFactory.getLogger(MatchMessageService.class);
    public static String URL = "MBLk1ofwp/7MADHJevPDNCEwk84N9zSl4bbbee7nq8JuDRs9LC8Qf5h9EW3TYf5KJ45nF/vg6POw0EqXZ1w+ksxGUxCDdc4BTzroOZvtleo=";

    @Resource
    private HashUtils hashUtils;

    public void sendMessage(List<Order> orders, Order adminOrder) throws Exception {
        Message message = new Message();
        String orderText = orders.stream().map(order -> String.format("order username: <@%s> product: %s", order.userName, order.url)).collect(Collectors.joining("\n"));
        String mainText = String.format("Congratulation!!! :amazon: \n We have a match :package: :package: :package:   \n admin of order is: <@%s>\n your shipping cart will contain the following orders: \n%s", adminOrder.getUserName(), orderText);
        message.setText(mainText);

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(hashUtils.decrypt(URL));

        // Request parameters and other properties.
        httppost.setEntity(new StringEntity(new Gson().toJson(message)));

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        if (HttpStatus.OK.value() != response.getStatusLine().getStatusCode()) {
            logger.error("Error while sending message to slack: code: "
                    + response.getStatusLine().getStatusCode() + " reason: " + response.getStatusLine().getReasonPhrase());

        }

    }

}
