package Shirts;

public class Sweaters extends Shirts {
  public Sweaters() {
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

  public boolean isLongSleeve() {
    return true;
  }

  public String toString() {
    return this.color + " sweater";
  }
}
