package Shoes;

public class DressShoes extends Shoes {
  public DressShoes() {
    super("black");       // assume dress shoes are always black
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return true;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isBrightlyColored() {
    return false;
  }

  public boolean hasHeel() {
    return true;
  }

  public String toString() {
    return this.color + " dress shoes";
  }
}
