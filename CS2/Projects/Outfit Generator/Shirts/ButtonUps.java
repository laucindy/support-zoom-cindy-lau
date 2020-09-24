package Shirts;

public class ButtonUps extends Shirts {
  public ButtonUps() {
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    isLongSleeve = true;
  }

  public String toString() {
    return this.color + " button-up shirt";
  }
}
