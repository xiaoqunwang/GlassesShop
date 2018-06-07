package com.nuoda.glassesshop.service.impl;

import com.nuoda.glassesshop.service.IOrderService;
import com.nuoda.glassesshop.dao.OrderDao;
import com.nuoda.glassesshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiec implements IOrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public Order createOrder(Order neworder) {
        try {
            orderDao.newOrder(neworder);
            return neworder;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
