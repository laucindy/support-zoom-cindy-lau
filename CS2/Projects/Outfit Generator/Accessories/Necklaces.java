package Accessories;

public class Necklaces extends Accessories {
  public Necklaces() {
    isFormal = true;
    isJewelry = true;
    canStoreItems = false;
  }

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
