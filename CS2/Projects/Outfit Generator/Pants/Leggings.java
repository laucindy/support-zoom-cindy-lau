package Pants;

public class Leggings extends Pants {
  public Leggings() {
    super("black");      // assume leggings are always black
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasPockets = false;
    isShorts = false;
  }

  public String toString() {
    return this.color + " leggings";
  }
}