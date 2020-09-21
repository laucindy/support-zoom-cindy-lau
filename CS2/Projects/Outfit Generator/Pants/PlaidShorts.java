package Pants;

public class PlaidShorts extends Pants {
  public PlaidShorts() {
    hasPrint = true;
    isFormal = false;
    isGoodWithJewelry = false;
    isBrightlyColored = false;
    hasPockets = true;
    isShorts = true;
  }

  public String toString() {
    return this.color + " plaid shorts";
  }
}
