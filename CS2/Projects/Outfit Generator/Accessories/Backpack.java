package Accessories;

public class Backpack extends Accessories {
  public Backpack() {
    isFormal = false;
    isJewelry = false;
    canStoreItems = true;
  }

  public String toString() {
    return this.color + " backpack";
  }
}
