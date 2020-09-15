package Accessories;

public class Sunglasses extends Accessories {
  public boolean isFormal() {
    return false;
  }

  public boolean isJewelry() {
    return false;
  }

  public boolean canStoreItems() {
    return false;
  }

  public String toString() {
    return this.color + " sunglasses";
  }
}
