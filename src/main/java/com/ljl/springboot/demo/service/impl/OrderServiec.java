package com.ljl.springboot.demo.service.impl;

import com.ljl.springboot.demo.dao.OrderDao;
import com.ljl.springboot.demo.model.Order;
import com.ljl.springboot.demo.service.IOrderService;
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
