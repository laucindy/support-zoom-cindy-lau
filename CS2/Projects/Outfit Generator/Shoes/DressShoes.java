package Shoes;

public class DressShoes extends Shoes {
  public DressShoes() {
    super("black");       // assume dress shoes are always black
    hasPrint = false;
    isFormal = true;
    isGoodWithJewelry = true;
    isBrightlyColored = false;
    hasHeel = true;
  }

  public String toString() {
    return this.color + " dress shoes";
  }
}
