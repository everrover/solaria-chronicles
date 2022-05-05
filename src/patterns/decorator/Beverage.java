package src.patterns.decorator;

public abstract class Beverage {
    private String desc = "Unknown beverage";

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract int cost();
}
