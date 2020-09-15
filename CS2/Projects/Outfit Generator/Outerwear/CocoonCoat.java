package Outerwear;

public class CocoonCoat extends Outerwear {
  public CocoonCoat() {
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
    return this.color + " cocoon coat";
  }
}
