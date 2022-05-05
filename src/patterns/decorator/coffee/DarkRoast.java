package src.patterns.decorator.coffee;

import src.patterns.decorator.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast(){
        this.setDesc("DarkRoast");
    }
    @Override
    public int cost() {
        return 0;
    }
}
