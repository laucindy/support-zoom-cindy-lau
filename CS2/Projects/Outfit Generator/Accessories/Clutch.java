package Accessories;

public class Clutch extends Accessories {
  public boolean isFormal() {
    return true;
  }

  public boolean isJewelry() {
    return false;
  }

  public boolean canStoreItems() {
    return true;
  }

  public String toString() {
    return this.color + " clutch";
  }
}
