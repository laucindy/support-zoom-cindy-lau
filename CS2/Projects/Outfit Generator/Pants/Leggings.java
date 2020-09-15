package Pants;

public class Leggings extends Pants {
  public Leggings() {
    super("black");      // assume leggings are always black
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
    return this.color + " leggings";
  }
}