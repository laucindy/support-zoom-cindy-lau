package Shoes;

public class Flats extends Shoes {
  public Flats() {
    super();
  }

  public boolean hasPrint() {
    return false;
  }

  public boolean isFormal() {
    return false;
  }

  public boolean isGoodWithJewelry() {
    return true;
  }

  public boolean isBrightlyColored() {
    return true;
  }

  public boolean hasHeel() {
    return false;
  }

  public String toString() {
    return "bright " + this.color + " flats";
  }
}
