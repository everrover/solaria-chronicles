package src.patterns.decorator;

import src.patterns.decorator.condiments.Cream;
import src.patterns.decorator.condiments.Mocha;
import src.patterns.decorator.condiments.Whip;

public abstract class CondimentDecorator extends Beverage{
    public abstract String getDesc();

    public static Beverage addCondiment(Beverage beverage, String type){
        Beverage b = beverage;
        if(type.equals("mocha")){
            b = new Mocha(b);
        }else if(type.equals("cream")){
            b = new Cream(b);
        }else if(type.equals("whip")){
            b = new Whip(b);
        }else{
            // add nth
        }
        return b;
    }

}
