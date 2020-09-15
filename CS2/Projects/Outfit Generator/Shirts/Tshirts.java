package Shirts;

public class Tshirts extends Shirts {
  public Tshirts() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isBrightlyColored() {
    return true;
  }

  public boolean isLongSleeve() {
    return false;
  }

  public String toString() {
    return "bright " + this.color + " t-shirt";
  }
}
