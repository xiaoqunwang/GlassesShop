package com.nuoda.glassesshop.provider.controller;

import com.nuoda.glassesshop.common.utils.ApiResponse;
import com.nuoda.glassesshop.model.Order;
import com.nuoda.glassesshop.service.impl.OrderServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderServiec orderServiec;

    @RequestMapping(value = "/neworder",method = RequestMethod.POST)
    public Object newOrder(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "totalPrice") double totalPrice,
            @RequestParam(value = "quantities") int quantities,
            @RequestParam(value = "receiveName") String receiveName,
            @RequestParam(value = "receivePhone") String receivePhone,
            @RequestParam(value = "receiveAddress") String receiveAddress,
            @RequestParam(value = "detail") String detail,
            @RequestParam(value = "channel") String channel
    ){
        try {
            Order order=new Order();
            order.setUserId(userId);
            order.setTotalPrice(totalPrice);
            order.setOrderStatus(0);
            order.setPayStatus(0);
            order.setReceiveName(receiveName);
            order.setReceivePhone(receivePhone);
            order.setReceiveAddress(receiveAddress);
            order.setDetail(detail);
            order.setQuantities(quantities);
            order.setChannel(channel);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            order.setOrderTime(simpleDateFormat.format(new Date()));
            return ApiResponse.buildSuccess(orderServiec.createOrder(order),"订单生成成功");

        }catch (Exception e){
            e.printStackTrace();
            return ApiResponse.buildFailure("订单生成失败");
        }

    }

}
