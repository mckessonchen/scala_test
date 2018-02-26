package DesignPatterns.Strategy;

/**
 * Created by chenteng on 2017/4/24.
 */

public class Sneakers extends Finery {
    public Sneakers(Person person) {
        super(person);
    }

    public void Show(){
        System.out.println("运动鞋");
        super.Show();
    }
}
