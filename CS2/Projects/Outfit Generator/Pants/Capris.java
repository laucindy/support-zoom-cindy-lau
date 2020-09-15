package Pants;

public class Capris extends Pants {
  public Capris() {
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

  public boolean hasPockets() {
    return false;
  }

  public boolean isShorts() {
    return false;
  }

  public String toString() {
    return this.color + " capris";
  }
}
