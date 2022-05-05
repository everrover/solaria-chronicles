package src.patterns.decorator.coffee;

import src.patterns.decorator.Beverage;

public class Decaf extends Beverage {
    public Decaf(){
        this.setDesc("Decaf");
    }

    @Override
    public int cost() {
        return 20;
    }
}
