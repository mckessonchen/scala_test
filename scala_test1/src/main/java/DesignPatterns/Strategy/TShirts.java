package DesignPatterns.Strategy;

/**
 * Created by chenteng on 2017/4/24.
 */

public class TShirts extends Finery{

    public TShirts(Person person) {
        super(person);
    }

    public void Show(){
        System.out.println("TShirts");
        super.Show();
    }
}
