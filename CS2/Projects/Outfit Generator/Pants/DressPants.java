package Pants;

public class DressPants extends Pants {
  public DressPants() {
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

  public boolean hasPockets() {
    return true;
  }

  public boolean isShorts() {
    return false;
  }

  public String toString() {
    return this.color + " dress pants";
  }
}