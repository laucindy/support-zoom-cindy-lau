package Outerwear;

public class BomberJacket extends Outerwear {
  public BomberJacket() {
    super();
  }

  public boolean hasPrint() {
    return true;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isBrightlyColored() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isForColdWeather() {
    return false;
  }

  public String toString() {
    return this.color + " bomber jacket";
  }
}
