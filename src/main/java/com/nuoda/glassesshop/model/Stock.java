package com.nuoda.glassesshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    long uniond;
    String product_name;
    int stock;
    double price;
    int status;
    String ctime;
    String utime;

    @Override
    public String toString() {
        return "Stock{" +
                "uniond=" + uniond +
                ", product_name='" + product_name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", status=" + status +
                ", ctime='" + ctime + '\'' +
                ", utime='" + utime + '\'' +
                '}';
    }
}
