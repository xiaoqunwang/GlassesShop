package com.ljl.springboot.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    int id;
    String userId;
    double totalPrice;
    int orderStatus;
    int payStatus;
    String receiveName;
    String receivePhone;
    String receiveAddress;
    String detail;
    String ctime;
    String utime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", payStatus=" + payStatus +
                ", receiveName=" + receiveName +
                ", receivePhone=" + receivePhone +
                ", receiveAddress=" + receiveAddress +
                ", detail=" + detail +
                ", ctime=" + ctime +
                ", utime=" + utime +
                '}';
    }
}
