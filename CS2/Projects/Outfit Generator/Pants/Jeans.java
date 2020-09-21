package Pants;

public class Jeans extends Pants {
  public Jeans() {
    super("blue");      // assume jeans are always blue
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasPockets = true;
    isShorts = false;
  }

  public String toString() {
    return this.color + " jeans";
  }
}
