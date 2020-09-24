package Clothing;

// Shirts, pants, outerwear, and shoes
public abstract class Clothing {
  protected boolean hasPrint;
  protected boolean isFormal;
  protected boolean isBrightlyColored;
  protected boolean isGoodWithJewelry;

  public boolean hasPrint() {
    return hasPrint;
  }

  public boolean isFormal() {
    return isFormal;
  }

  public boolean isBrightlyColored() {
    return isBrightlyColored;
  }

  public boolean isGoodWithJewelry() {
    return isGoodWithJewelry;
  }
}
