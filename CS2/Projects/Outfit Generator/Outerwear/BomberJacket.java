package Outerwear;

public class BomberJacket extends Outerwear {
  public BomberJacket() {
    hasPrint = true;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isForColdWeather = false;
  }

  public String toString() {
    return this.color + " bomber jacket";
  }
}
