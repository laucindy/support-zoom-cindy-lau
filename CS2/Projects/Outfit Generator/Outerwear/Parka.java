package Outerwear;

public class Parka extends Outerwear {
  public Parka() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isForColdWeather = true;
  }

  public String toString() {
    return this.color + " parka";
  }
}