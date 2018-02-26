package DesignPatterns.ProxyPatterns;

/**
 * Created by chenteng on 2017/4/24.
 */

public class TProxy implements IGiveGift {
    private Pursuit pursuit;

    public TProxy(SchoolGirl mm) {
        this.pursuit = new Pursuit(mm);
    }

    @Override
    public void GiveFlower() {
        pursuit.GiveFlower();
    }

    @Override
    public void GiveDolls() {
        pursuit.GiveDolls();
    }

    @Override
    public void GiveChocolate() {
        pursuit.GiveChocolate();
    }
}
