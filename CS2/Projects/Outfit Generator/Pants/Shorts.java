package Pants;

public class Shorts extends Pants {
  public Shorts() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = false;
    isBrightlyColored = false;
    hasPockets = true;
    isShorts = true;
  }

  public String toString() {
    return this.color + " shorts";
  }
}
