package Shoes;

public class Pumps extends Shoes {
  public Pumps() {
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasHeel = true;
  }

  public String toString() {
    return this.color + " pumps";
  }
}
