package Accessories;

public class Clutch extends Accessories {
  public Clutch() {
    isFormal = true;
    isJewelry = false;
    canStoreItems = true;
  }

  public String toString() {
    return this.color + " clutch";
  }
}
