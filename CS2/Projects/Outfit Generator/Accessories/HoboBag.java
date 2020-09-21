package Accessories;

public class HoboBag extends Accessories {
  public HoboBag() {
    isFormal = false;
    isJewelry = false;
    canStoreItems = true;
  }

  public String toString() {
    return this.color + " hobo bag";
  }
}
