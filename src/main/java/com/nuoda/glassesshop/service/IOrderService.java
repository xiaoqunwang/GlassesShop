package com.nuoda.glassesshop.service;

import com.nuoda.glassesshop.model.Order;

import java.util.List;

public interface IOrderService {
     Order createOrder(Order neworder);

     List<Order> getOrderByUser(String userid);

     Order getOrderById( long orderid);

    Order updateOrder(Order order);


}
