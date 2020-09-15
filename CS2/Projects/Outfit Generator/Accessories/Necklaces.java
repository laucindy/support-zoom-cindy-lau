package Accessories;

public class Necklaces extends Accessories {
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
    return this.color + " necklace";
  }
}
