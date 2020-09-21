package Pants;

public class Capris extends Pants {
  public Capris() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasPockets = false;
    isShorts = false;
  }

  public String toString() {
    return this.color + " capris";
  }
}
