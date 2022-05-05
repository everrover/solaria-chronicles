package src.patterns.decorator.condiments;

import src.patterns.decorator.Beverage;
import src.patterns.decorator.CondimentDecorator;

import javax.swing.border.BevelBorder;

public class Cream extends CondimentDecorator {

  private Beverage beverage;
  public Cream(Beverage beverage) {
    this.beverage = beverage;
//    beverage.setDesc(beverage.getDesc()+", Cream"); // thought this, changed desc for all
  }

  @Override
  public int cost() {
    return beverage.cost()+1;
  }

  @Override
  public String getDesc() {
    return beverage.getDesc()+", Cream";
//    return beverage.getDesc();
  }

}
