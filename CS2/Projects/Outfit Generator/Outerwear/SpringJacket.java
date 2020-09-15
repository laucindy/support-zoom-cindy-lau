package Outerwear;

public class SpringJacket extends Outerwear {
  public SpringJacket() {
    super();
  }

  public boolean hasPrint() {
    return false;
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
    return this.color + " spring jacket";
  }
}
