package Outerwear;

public class TrenchCoat extends Outerwear {
  public TrenchCoat() {
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isForColdWeather = true;
  }

  public String toString() {
    return this.color + " trench coat";
  }
}
