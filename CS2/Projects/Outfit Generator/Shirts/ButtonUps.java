package Shirts;

public class ButtonUps extends Shirts {
  public ButtonUps() {
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

  public boolean isLongSleeve() {
    return true;
  }

  public String toString() {
    return this.color + " button-up shirt";
  }
}
