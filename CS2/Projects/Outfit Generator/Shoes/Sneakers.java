package Shoes;

public class Sneakers extends Shoes {
  public Sneakers() {
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
    return false;
  }

  public boolean hasHeel() {
    return false;
  }

  public String toString() {
    return this.color + " sneakers";
  }
}
