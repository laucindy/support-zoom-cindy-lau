package Shoes;

public class AnkleBoots extends Shoes {
  public AnkleBoots() {
    super("brown");       // assume ankle boots are always brown
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

  public boolean hasHeel() {
    return true;
  }

  public String toString() {
    return this.color + " ankle boots";
  }
}
