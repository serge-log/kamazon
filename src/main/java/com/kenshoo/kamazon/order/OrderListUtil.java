package com.kenshoo.kamazon.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderListUtil {

    private static List<Order> resultList;

    public static List<Order> sum_up(List<Order> numbers, int target, int maxTarget) {
        resultList = new ArrayList<>();
        sum_up_recursive(numbers, target, maxTarget, new ArrayList<>());
        return resultList;
    }

    private static void sum_up_recursive(List<Order> numbers, int target, int maxTarget, List<Order> partial) {
        int s = 0;
        for (Order x : partial) {
            s += x.getPrice();
        }
        if (s >= target && s <= maxTarget) {
            System.out.println("sum(" + Arrays.toString(partial.stream().map(Order::getPrice).toArray()) + ")= between " + target + " and = " + maxTarget);
            resultList = partial;
        }
        if (s > maxTarget) {
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Order> remaining = new ArrayList<>();
            Order n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Order> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, maxTarget, partial_rec);
        }
    }

}
