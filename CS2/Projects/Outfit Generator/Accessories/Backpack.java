package Accessories;

public class Backpack extends Accessories {
  public boolean isFormal() {
    return false;
  }

  public boolean isJewelry() {
    return false;
  }

  public boolean canStoreItems() {
    return true;
  }

  public String toString() {
    return this.color + " backpack";
  }
}
