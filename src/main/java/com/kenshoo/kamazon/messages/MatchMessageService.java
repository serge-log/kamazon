package com.kenshoo.kamazon.messages;

import com.google.gson.Gson;
import com.kenshoo.kamazon.order.Order;
import com.kenshoo.kamazon.order.OrderService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by stasg on 1/13/20
 */

@Service
public class MatchMessageService {

    private Logger logger = LoggerFactory.getLogger(MatchMessageService.class);
    public static String URL = "https://hooks.slack.com/services/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";

    public void sendMessage(List<Order> orders) throws IOException {
        Message message = new Message();
        String orderText = orders.stream().map(order -> String.format("<@%s> %s %s", order.userName, order.url, order.price)).collect(Collectors.joining("\n"));
        String mainText = String.format("Congratulation!!! :amazon: \n We have a match :package: :package: :package:   \n %s", orderText);
        message.setText(mainText);

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(URL);

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
