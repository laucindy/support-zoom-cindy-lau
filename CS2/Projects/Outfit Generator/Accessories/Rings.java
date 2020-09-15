package Accessories;

public class Rings extends Accessories {
  public boolean isFormal() {
    return true;
  }

  public boolean isJewelry() {
    return true;
  }

  public boolean canStoreItems() {
    return false;
  }

  public String toString() {
    return this.color + " ring";
  }
}
