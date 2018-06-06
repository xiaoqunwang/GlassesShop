package com.ljl.springboot.demo.model;



public  class Drink {

    double co2,water;
    Bottle bottle;

    //mix是具体方法
    public  Drink mixdrink(){
        Drink drink= new Drink();
        drink.co2=1;
        drink.water=1;
        drink.bottle=new Bottle("glasses",1);
        return drink;
    };

    @Override
    public String toString() {
        return "Drink{" +
                "co2=" + co2 +
                ", water=" + water +
                ", bottle=" + bottle +
                '}';
    }
}
