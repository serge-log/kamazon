package com.kenshoo.kamazon.order;

import java.util.*;
import java.util.function.BinaryOperator;

public class OrderListUtil {

    public static List<Order> sum_up(List<Order> numbers, int minTarget, int maxTarget) {
        return sum_up_recursive(numbers, minTarget, maxTarget, new ArrayList<>());
    }

    private static List<Order> sum_up_recursive(List<Order> numbers, int target, int maxTarget, List<Order> partial) {
        int s = 0;
        for (Order x : partial) {
            s += x.getPrice();
        }
        if (s >= target && s <= maxTarget) {
            System.out.println("sum(" + Arrays.toString(partial.stream().map(Order::getPrice).toArray()) + ")= between " + target + " and = " + maxTarget);
            return partial;
        }
        if (s > maxTarget) {
            return null;
        }
        List<List<Order>> listList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Order> remaining = new ArrayList<>();
            Order n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Order> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            listList.add(sum_up_recursive(remaining, target, maxTarget, partial_rec));
        }
        return listList.stream().filter(Objects::nonNull).reduce(getReduceFunction()).orElse(null);
    }

    private static BinaryOperator<List<Order>> getReduceFunction() {
        return (l1, l2) -> {
            if (l1.size() >= l2.size()) {
                return l1;
            } else {
                return l2;
            }
        };
    }
}
