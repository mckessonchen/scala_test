package DesignPatterns.ProxyPatterns;

/**
 * Created by chenteng on 2017/4/24.
 */

public class Pursuit implements IGiveGift {
    private SchoolGirl mm;

    public Pursuit(SchoolGirl schoolGirl) {
        this.mm = schoolGirl;
    }

    @Override
    public void GiveFlower() {
        System.out.println("送给你花："+mm.getName());
    }

    @Override
    public void GiveDolls() {
        System.out.println("送给你洋娃娃："+mm.getName());
    }

    @Override
    public void GiveChocolate() {
        System.out.println("送给你巧克力："+mm.getName());
    }
}
