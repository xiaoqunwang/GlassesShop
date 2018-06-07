package com.springboot.glassesshop.service.impl;

import com.springboot.glassesshop.dao.OrderDao;
import com.springboot.glassesshop.model.Order;
import com.springboot.glassesshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiec implements IOrderService{
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
