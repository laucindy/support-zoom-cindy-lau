package Shoes;

public class AnkleBoots extends Shoes {
  public AnkleBoots() {
    super("brown");       // assume ankle boots are always brown
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasHeel = true;
  }

  public String toString() {
    return this.color + " ankle boots";
  }
}
