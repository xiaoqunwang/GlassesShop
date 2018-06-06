package com.ljl.springboot.demo.model;

import java.util.Scanner;

public class Cola implements IDrink,Imedicine{

    //------------类的属性（数据域）-----
    double sugar;
    double color;
    double co2;
    double water;
    Bottle bottle;
    //---------------------------------


    //----------- 类的技能（方法域）--------------

   //这是Cola类的无参数构造器，专门用来初始化Cola类的具体对象，返回的就是Cola类的具体对象
    public Cola() {
    }

    //我们自己定义的无糖构造器
    public Cola(double color,double co2,double water,Bottle bottle){

        System.out.println("调用了构造器");
        this.sugar=0;
        this.color=color;
        this.co2=co2;
        this.water=water;
        this.bottle=bottle;
    }

    //------------------------------ 这些是取值方法和设值方法-----------------------------

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    //------------------------------这是打印字符串模板--------------------------------------


    @Override
    public String toString() {
        return "Cola{" +
                "sugar=" + sugar +
                ", color=" + color +
                ", co2=" + co2 +
                ", water=" + water +
                ", bottle=" + bottle +
                '}';
    }

    private Cola mix(double sugar, double color, double co2, double water,Bottle bottle){
        Cola mycola=new Cola(color,co2,water,bottle);
        //mycola.setSugar(sugar);
        return mycola;
    }



    //---------------------------------------------------------------------




//main入口，主要是控制台测试或演示用
    public static void main(String[] args){
        Cola cola=new Cola();
        Scanner scanner=new Scanner(System.in);
        double sugar=scanner.nextDouble();
        double color=scanner.nextDouble();
        double co2=scanner.nextDouble();
        double water=scanner.nextDouble();

        Bottle bottle=new Bottle("plastic",1.0);


        Cola mycola1=cola.mix(sugar,color,co2,water,bottle);

        System.out.println("我就是一瓶可爱的无糖可乐1："+mycola1);



        cola.drink();
        cola.cure();




    }


    @Override
    public void drink() {
        System.out.println("喝可乐");
    }

    @Override
    public void cure() {
        System.out.println("治感冒");
    }
}
