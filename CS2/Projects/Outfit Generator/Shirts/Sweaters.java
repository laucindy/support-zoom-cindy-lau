package Shirts;

public class Sweaters extends Shirts {
  public Sweaters() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isLongSleeve = true;
  }

  public String toString() {
    return this.color + " sweater";
  }
}
