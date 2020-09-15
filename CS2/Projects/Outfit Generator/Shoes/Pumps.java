package Shoes;

public class Pumps extends Shoes {
  public Pumps() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return true;
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
    return this.color + " pumps";
  }
}
