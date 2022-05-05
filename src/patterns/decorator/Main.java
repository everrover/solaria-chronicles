package src.patterns.decorator;

import src.patterns.decorator.coffee.Expresso;

public class Main {
    public static void main(String[] args) {
        Beverage b1 = new Expresso();
        b1 = CondimentDecorator.addCondiment(b1, "mocha");
        b1 = CondimentDecorator.addCondiment(b1, "whip");
        b1 = CondimentDecorator.addCondiment(b1, "whip");
        b1 = CondimentDecorator.addCondiment(b1, "cream");
        System.out.println(b1.getDesc());
        System.out.println(b1.cost());
    }
}
