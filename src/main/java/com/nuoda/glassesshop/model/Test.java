package com.nuoda.glassesshop.model;

public class Test {

    public static void main(String [] args){

        int x=10;
        Test mytest=new Test();

        int outcome=mytest.l(-10);
        System.out.print(outcome);


    }

    public static int u(int x){
        int y=0;

        if(x%2==0){
            System.out.println("This is even number.");
            y=x+20;
        }else {
            System.out.println("This is odd number.");
            y=x-1;
        }
        return y;
    }

    public static int p(int x){
        int y=0;

        if(x%3==0) {
            System.out.println("a");
            y = x + 33333;
        }else if(x%3==1) {
            System.out.println("ddd");
            y=12345+x;
        }
        else if(x%2==3){
            System.out.println("iiii");
            y=2*x+555555;
        }
        else{
            y=x+666;}



            return y;


    }


    public static int k(int x){
        int y=0;
        switch (x%3) {
            case 0:
                System.out.println("a");
                y = x + 33333;
               break;
            case 1:
                System.out.println("ddd");
                y=12345+x;
                break;
            default:
                System.out.println("iiii");
                y=2*x+555555;

        }
        return y;
    }


    public  int l(int x){
    int y=0;
    switch (x%5) {
        case 0:
            System.out.println("1");
            y = x + 6666;
            break;
        case 1:
            System.out.println("2");
            y = x * x;
            break;
        default:
            System.out.println("3");
            y=x*x*x*x*x;

    }
    return y;
    }
}









































