package Shirts;

public class Tshirts extends Shirts {
  public Tshirts() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = true;
    isLongSleeve = false;
  }

  public String toString() {
    return "bright " + this.color + " t-shirt";
  }
}
