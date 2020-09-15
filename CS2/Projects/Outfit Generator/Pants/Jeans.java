package Pants;

public class Jeans extends Pants {
  public Jeans() {
    super("blue");      // assume jeans are always blue
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
    return false;
  }

  public boolean hasPockets() {
    return true;
  }

  public boolean isShorts() {
    return false;
  }

  public String toString() {
    return this.color + " jeans";
  }
}
