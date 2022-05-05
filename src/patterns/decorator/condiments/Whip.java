package src.patterns.decorator.condiments;

import src.patterns.decorator.Beverage;
import src.patterns.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {


        private Beverage beverage;
        public Whip(Beverage beverage) {
                this.beverage = beverage;
        }

        @Override
        public int cost() {
                return beverage.cost()+5;
        }

        @Override
        public String getDesc() {
                return beverage.getDesc()+", Whip";
        }
}
