package Pants;

public class DressPants extends Pants {
  public DressPants() {
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasPockets = true;
    isShorts = false;
  }

  public String toString() {
    return this.color + " dress pants";
  }
}