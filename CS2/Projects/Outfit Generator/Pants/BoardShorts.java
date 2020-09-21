package Pants;

public class BoardShorts extends Pants {
  public BoardShorts() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = false;
    isBrightlyColored = true;
    hasPockets = true;
    isShorts = true;
  }

  public String toString() {
    return "bright " + this.color + " board shorts";
  }
}
