package Accessories;

public class EveningBag extends Accessories {
  public EveningBag() {
    isFormal = true;
    isJewelry = false;
    canStoreItems = true;
  }

  public String toString() {
    return this.color + " evening bag";
  }
}
