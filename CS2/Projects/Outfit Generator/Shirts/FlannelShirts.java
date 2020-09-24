package Shirts;

public class FlannelShirts extends Shirts {
  public FlannelShirts() {
    hasPrint = true;
    isFormal = false;
    isGoodWithJewelry = false;
    isBrightlyColored = false;
    isLongSleeve = true;
  }

  public String toString() {
    return this.color + " flannel shirt";
  }
}
