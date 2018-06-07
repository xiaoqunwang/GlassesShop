package com.springboot.glassesshop.provider.controller;

import com.springboot.glassesshop.common.utils.ApiResponse;
import com.springboot.glassesshop.model.Order;
import com.springboot.glassesshop.service.impl.OrderServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderServiec orderServiec;

    @RequestMapping(value = "/neworder",method = RequestMethod.POST)
    public Object newOrder(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "totalPrice") double totalPrice,
            @RequestParam(value = "orderStatus") int orderStatus,
            @RequestParam(value = "payStatus") int payStatus,
            @RequestParam(value = "receiveName") String receiveName,
            @RequestParam(value = "receivePhone") String receivePhone,
            @RequestParam(value = "receiveAddress") String receiveAddress,
            @RequestParam(value = "detail") String detail
    ){
        try {
            Order order=new Order();
            order.setUserId(userId);
            order.setTotalPrice(totalPrice);
            order.setOrderStatus(orderStatus);
            order.setPayStatus(payStatus);
            order.setReceiveName(receiveName);
            order.setReceivePhone(receivePhone);
            order.setReceiveAddress(receiveAddress);
            order.setDetail(detail);
            return ApiResponse.buildSuccess(orderServiec.createOrder(order),"订单生成成功");

        }catch (Exception e){
            return ApiResponse.buildFailure("订单生成失败");
        }

    }

}
