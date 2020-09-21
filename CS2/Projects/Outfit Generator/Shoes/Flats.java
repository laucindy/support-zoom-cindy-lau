package Shoes;

public class Flats extends Shoes {
  public Flats() {
    hasPrint = false;
    isFormal = false;
    isGoodWithJewelry = true;
    isBrightlyColored = true;
    hasHeel = false;
  }

  public String toString() {
    return "bright " + this.color + " flats";
  }
}
