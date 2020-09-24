package Accessories;

public class Watch extends Accessories {
  public Watch() {
    isFormal = true;
    isJewelry = true;
    canStoreItems = false;
  }

  public String toString() {
    return this.color + " watch";
  }
}
