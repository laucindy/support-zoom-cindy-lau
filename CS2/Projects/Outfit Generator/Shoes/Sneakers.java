package Shoes;

public class Sneakers extends Shoes {
  public Sneakers() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasHeel = false;
  }

  public String toString() {
    return this.color + " sneakers";
  }
}
