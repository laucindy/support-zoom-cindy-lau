package Pants;

public class PlaidShorts extends Pants {
  public PlaidShorts() {
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
    return true;
  }

  public boolean isShorts() {
    return true;
  }

  public String toString() {
    return this.color + " plaid shorts";
  }
}
