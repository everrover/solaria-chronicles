package src.patterns.decorator.coffee;

import src.patterns.decorator.Beverage;

public class Expresso extends Beverage {
    public Expresso(){
        this.setDesc("Expresso");
    }
    @Override
    public int cost() {
        return 22;
    }
}
