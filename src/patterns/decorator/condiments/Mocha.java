package src.patterns.decorator.condiments;

import src.patterns.decorator.Beverage;
import src.patterns.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {


        private Beverage beverage;
        public Mocha(Beverage beverage) {
                this.beverage = beverage;
        }

        @Override
        public int cost() {
                return beverage.cost()+2;
        }

        @Override
        public String getDesc() {
                return beverage.getDesc()+", Mocha";
        }
}
