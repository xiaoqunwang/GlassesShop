package com.nuoda.glassesshop.dao;



import com.nuoda.glassesshop.model.Order;
import com.nuoda.glassesshop.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao {


    @Insert("INSERT " +
            " INTO order_info (" +
            "user_id"+
            ",total_price"+
            ",quantities"+
            ",order_status"+
            ",pay_status"+
            ",receive_name"+
            ",receive_phone"+
            ",receive_address"+
            ",detail"+
            ",channel"+
            ",pay_time"+
            ",order_time"+
            " ) " +
            " VALUES(" +
            " #{userId}"+
            ",#{totalPrice}"+
            ",#{quantities}"+
            ",#{orderStatus}"+
            ",#{payStatus}"+
            ",#{receiveName}"+
            ",#{receivePhone}"+
            ",#{receiveAddress}"+
            ",#{detail}"+
            ",#{channel}"+
            ",#{payTime}"+
            ",#{orderTime}"+
            " )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
     int newOrder(Order neworder);


    @Select("SELECT id, user_id, total_price,quantities, order_status, pay_status, receive_name, receive_phone, receive_address, detail,transport_num,channel, ctime, utime from order_info where user_id=#{userId} ")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "total_price", property = "totalPrice"),
            @Result(column = "quantities", property = "quantities"),
            @Result(column = "order_status", property = "orderStatus"),
            @Result(column = "pay_status", property = "payStatus"),
            @Result(column = "receive_name", property = "receiveName"),
            @Result(column = "receive_phone", property = "receivePhone"),
            @Result(column = "receive_address", property = "receiveAddress"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "transport_num", property = "transportNum"),
            @Result(column = "channel", property = "channel"),
            @Result(column = "ctime", property = "ctime"),
            @Result(column = "utime", property = "utime")
    })
     List<Order> getOrderByUserId(@Param(value = "userId") String userid);

    @Select("SELECT id, user_id, total_price,quantities, order_status, pay_status, receive_name, receive_phone, receive_address, detail,transport_num,channel, ctime, utime from order_info where id=#{orderid} ")
    Order getOrderById(@Param(value = "orderid") long orderid);


    @Update("UPDATE order_info set " +
            "total_price=#{totalPrice}," +
            "quantities=#{quantities}," +
            "order_status=#{orderStatus}," +
            "pay_status=#{payStatus}," +
            "receive_name=#{receiveName}," +
            "receive_phone=#{receivePhone}," +
            "receive_address=#{receiveAddress}," +
            "transport_num=#{transportNum},"+
            "detail=#{detail} where id=#{id}" )
    int updateOrder(Order order);

}
