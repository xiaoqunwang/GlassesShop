package com.nuoda.glassesshop.service.impl;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
import com.nuoda.glassesshop.service.IOrderService;
import com.nuoda.glassesshop.dao.OrderDao;
import com.nuoda.glassesshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderServiec implements IOrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    @DataSourceTypeAnno(DataSourceEnum.slaver)
    public Order createOrder(Order neworder) {

            orderDao.newOrder(neworder);
            return neworder;

    }

    @Override
    @DataSourceTypeAnno(DataSourceEnum.slaver)
    public List<Order> getOrderByUser(String userid) {
        List<Order> orders=orderDao.getOrderByUserId(userid);
        return orders;
    }

    @Override
    @DataSourceTypeAnno(DataSourceEnum.slaver)
    public Order getOrderById(long orderid) {
        Order order=orderDao.getOrderById(orderid);
        return order;
    }

    @Override
    @DataSourceTypeAnno(DataSourceEnum.slaver)
    public Order updateOrder(Order order) {
        orderDao.updateOrder(order);
        Order order1=orderDao.getOrderById(order.getId());
        return order1;
    }


}
