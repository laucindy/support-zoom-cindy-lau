package Outerwear;

public class CocoonCoat extends Outerwear {
  public CocoonCoat() {
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isForColdWeather = true;
  }

  public String toString() {
    return this.color + " cocoon coat";
  }
}
