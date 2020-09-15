package Outerwear;

public class TrenchCoat extends Outerwear {
  public TrenchCoat() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return true;
  }

  public boolean isBrightlyColored() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isForColdWeather() {
    return true;
  }

  public String toString() {
    return this.color + " trench coat";
  }
}
