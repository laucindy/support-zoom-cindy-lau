package Pants;

public class HaremPants extends Pants {
  public HaremPants() {
    hasPrint = true;
    isFormal = false;
    isGoodWithJewelry = false;
    isBrightlyColored = false;
    hasPockets = false;
    isShorts = false;
  }

  public String toString() {
    return this.color + " harem pants";
  }
}
