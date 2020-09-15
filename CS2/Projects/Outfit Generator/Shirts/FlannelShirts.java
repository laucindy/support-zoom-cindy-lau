package Shirts;

public class FlannelShirts extends Shirts {
  public FlannelShirts() {
    super();
  }

  public boolean hasPrint() {
    return true;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return false;
  }

  public boolean isBrightlyColored() {
    return false;
  }

  public boolean isLongSleeve() {
    return true;
  }

  public String toString() {
    return this.color + " flannel shirt";
  }
}
