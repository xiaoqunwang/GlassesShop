package com.nuoda.glassesshop.service.impl;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
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
    @DataSourceTypeAnno(DataSourceEnum.slaver)
    public Order createOrder(Order neworder) {

            orderDao.newOrder(neworder);
            return neworder;

    }
}
