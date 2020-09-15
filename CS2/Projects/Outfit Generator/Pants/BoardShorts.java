package Pants;

public class BoardShorts extends Pants {
  public BoardShorts() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return false;
  }

  public boolean isBrightlyColored() {
    return true;
  }

  public boolean hasPockets() {
    return true;
  }

  public boolean isShorts() {
    return true;
  }

  public String toString() {
    return "bright " + this.color + " board shorts";
  }
}
