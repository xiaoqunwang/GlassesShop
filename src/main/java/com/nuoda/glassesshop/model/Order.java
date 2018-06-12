package com.nuoda.glassesshop.model;

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
    int quantities;
    int orderStatus;
    int payStatus;
    String receiveName;
    String receivePhone;
    String receiveAddress;
    String detail;
    String orderTime;
    String payTime;
    String channel;
    String ctime;
    String utime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantities=" + quantities +
                ", orderStatus=" + orderStatus +
                ", payStatus=" + payStatus +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", detail='" + detail + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", channel='" + channel + '\'' +
                ", ctime='" + ctime + '\'' +
                ", utime='" + utime + '\'' +
                '}';
    }
}





