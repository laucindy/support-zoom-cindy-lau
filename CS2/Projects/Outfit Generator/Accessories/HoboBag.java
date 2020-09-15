package Accessories;

public class HoboBag extends Accessories {
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
    return this.color + " hobo bag";
  }
}
