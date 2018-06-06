package com.ljl.springboot.demo.dao;


import com.ljl.springboot.demo.common.annotation.DataSourceTypeAnno;
import com.ljl.springboot.demo.eumn.DataSourceEnum;
import com.ljl.springboot.demo.model.Order;
import com.ljl.springboot.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@DataSourceTypeAnno(DataSourceEnum.slaver)
public interface OrderDao {


    @Insert("INSERT " +
            " INTO eyeorder.order (" +
            "user_id"+
            ",total_price"+
            ",order_status"+
            ",pay_status"+
            ",receive_name"+
            ",receive_phone"+
            ",receive_address"+
            ",detail"+
            " ) " +
            " VALUES(" +
            " #{userId}"+
            ",#{totalPrice}"+
            ",#{orderStatus}"+
            ",#{payStatus}"+
            ",#{receiveName}"+
            ",#{receivePhone}"+
            ",#{receiveAddress}"+
            ",#{detail}"+
            " )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int newOrder(Order neworder);


    @Select("SELECT id, user_id, total_price, order_status, pay_status, receive_name, receive_phone, receive_address, detail, ctime, utime from order where user_id=#{userId} ")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "total_price", property = "totalPrice"),
            @Result(column = "order_status", property = "orderStatus"),
            @Result(column = "pay_status", property = "payStatus"),
            @Result(column = "receive_name", property = "receiveName"),
            @Result(column = "receivePhone", property = "receivePhone"),
            @Result(column = "receiveAddress", property = "receiveAddress"),
            @Result(column = "detail", property = "email"),
            @Result(column = "ctime", property = "openid"),
            @Result(column = "utime", property = "createTime")
    })
    public User getOrderByUserId(@Param(value = "id") String userid);

}
