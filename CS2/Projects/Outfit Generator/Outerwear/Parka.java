package Outerwear;

public class Parka extends Outerwear {
  public Parka() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
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
    return this.color + " parka";
  }
}