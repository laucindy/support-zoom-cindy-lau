package Accessories;

public class Rings extends Accessories {
  public Rings() {
    isFormal = true;
    isJewelry = true;
    canStoreItems = false;
  }

  public String toString() {
    return this.color + " ring";
  }
}
