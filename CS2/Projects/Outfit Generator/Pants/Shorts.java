package Pants;

public class Shorts extends Pants {
  public Shorts() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return false;
  }

  public boolean isBrightlyColored() {
    return false;
  }

  public boolean hasPockets() {
    return true;
  }

  public boolean isShorts() {
    return true;
  }

  public String toString() {
    return this.color + " shorts";
  }
}
