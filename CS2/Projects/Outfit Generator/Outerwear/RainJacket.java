package Outerwear;

public class RainJacket extends Outerwear {
  public RainJacket() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = true;
    isForColdWeather = false;
  }

  public String toString() {
    return "bright " + this.color + " rain jacket";
  }
}
