package com.springboot.glassesshop.model;

public class Bottle {
    String material;
    double size;

    public Bottle(String material,double size){
        this.material=material;
        this.size=size;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "material='" + material + '\'' +
                ", size=" + size +
                '}';
    }

}
