package Pants;

public class HaremPants extends Pants {
  public HaremPants() {
    super();
  }

  public boolean hasPrint() {
    return true;
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
    return false;
  }

  public boolean isShorts() {
    return false;
  }

  public String toString() {
    return this.color + " harem pants";
  }
}
