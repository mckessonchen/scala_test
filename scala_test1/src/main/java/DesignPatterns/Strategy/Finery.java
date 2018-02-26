package DesignPatterns.Strategy;

/**
 * Created by chenteng on 2017/4/24.
 */

public class Finery extends Person {
    private Person person;

    public Finery(Person person){
        this.person = person;
    }

    public void Show(){
        if (person!=null)
            person.Show();
    }
}
