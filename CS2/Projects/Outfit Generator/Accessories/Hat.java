package Accessories;

public class Hat extends Accessories {
  public Hat() {
    isFormal = false;
    isJewelry = false;
    canStoreItems = false;
  }

  public String toString() {
    return this.color + " hat";
  }
}
