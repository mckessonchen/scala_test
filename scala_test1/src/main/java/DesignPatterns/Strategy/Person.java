package DesignPatterns.Strategy;

/**
 * Created by chenteng on 2017/4/24.
 * 在人选择穿衣的问题上使用策略模式
 */

public class Person {
    private String name;

    public Person(){}

    public Person (String name){
        this.name = name;
    }

    public void Show() {
        System.out.println("装的人:" + name);
    }

    public static void main(String[] args){
        Person person = new Person("cc");
        TShirts tShirts = new TShirts(person);
        Sneakers sneakers = new Sneakers(tShirts);
        sneakers.Show();
    }
}
