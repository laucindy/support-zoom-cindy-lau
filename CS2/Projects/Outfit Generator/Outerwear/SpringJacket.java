package Outerwear;

public class SpringJacket extends Outerwear {
  public SpringJacket() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isForColdWeather = false;
  }

  public String toString() {
    return this.color + " spring jacket";
  }
}
