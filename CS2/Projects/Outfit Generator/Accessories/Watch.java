package Accessories;

public class Watch extends Accessories {
  public Watch() {
    super();
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
    return this.color + " watch";
  }
}
