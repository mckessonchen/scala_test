package DesignPatterns.ProxyPatterns;

/**
 * Created by chenteng on 2017/4/24.
 */

public class Main {
    public static void main(String[] args){
        SchoolGirl jiaojiao = new SchoolGirl("李娇娇");
        TProxy jiayi = new TProxy(jiaojiao);
        jiayi.GiveDolls();
        jiayi.GiveFlower();
        jiayi.GiveChocolate();
    }
}