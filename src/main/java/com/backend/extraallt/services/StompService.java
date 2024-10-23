package com.backend.extraallt.services;

import org.springframework.stereotype.Service;
import com.backend.extraallt.models.Order;
import java.util.*;

@Service
public class StompService {
    public Map<String, Order> placeOrder(String username, Order order) {
        Map<String, Order> placedOrder = new HashMap<>();
        placedOrder.put(username, order);
        return placedOrder;
    }
}
