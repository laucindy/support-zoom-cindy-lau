package Accessories;

public class Hat extends Accessories {
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
    return this.color + " hat";
  }
}
