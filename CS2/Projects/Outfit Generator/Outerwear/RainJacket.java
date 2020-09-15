package Outerwear;

public class RainJacket extends Outerwear {
  public RainJacket() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isBrightlyColored() {
    return true;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isForColdWeather() {
    return false;
  }

  public String toString() {
    return "bright " + this.color + " rain jacket";
  }
}
