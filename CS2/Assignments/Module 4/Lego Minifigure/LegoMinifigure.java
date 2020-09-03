public class LegoMinifigure {
  String name;
  LegoHat hat;
  LegoItem leftItem;
  LegoItem rightItem;

  public LegoMinifigure(String name, LegoHat hat, LegoItem leftItem, LegoItem rightItem) {
    this.name = name;
    this.hat = hat;
    this.leftItem = leftItem;
    this.rightItem = rightItem;
  }

  /**
   * Converts the Lego minifigure to a string, providing information about the Lego minifigure's name,
   * what hat it's wearing (if any), and what item(s) it's holding (if any)
   */
  public String toString() {
    String description = "A Lego minifigure named " + this.name + ", who is ";

    if ((this.hat == null) && (this.leftItem == null) && (this.rightItem == null)) {
      description += "not wearing a hat and not holding anything";
    }

    if (this.hat != null) {
      description += "wearing " + this.hat;

      if ((this.leftItem != null) || (this.rightItem != null)) description += " and ";
    }

    if (this.leftItem != null) {
      description += "holding " + this.leftItem + " in the left hand";

      if (this.rightItem != null) description += " and ";
    }

    if (this.rightItem != null) {
      if (this.leftItem == null) description += "holding ";
      description += this.rightItem + " in the right hand";
    }

    return description;
  }

  /**
   * Swaps the item that the Lego figure is holding on the left with the item on the right
   */
  public void swapHands() {
    LegoItem temp = this.leftItem;
    this.leftItem = this.rightItem;
    this.rightItem = temp;
  }

  /**
   * Changes the hat of the Lego figure to the one being passed in
   * @param hat - hat to wear (can be null)
   */
  public void wearHat(LegoHat hat) {
    this.hat = hat;
  }

  /**
   * Places an item in the left hand of the Lego figure
   * @param item - item to place (can be null)
   */
  public void placeInLeftHand(LegoItem item) {
    this.leftItem = item;
  }

  /**
   * Places an item in the right hand of the Lego figure
   * @param item - item to place (can be null)
   */
  public void placeInRightHand(LegoItem item) {
    this.rightItem = item;
  }

  /**
   * Checks if the Lego minifigure is good (hat style is 6 or higher, and
   * it isn't holding something heavy)
   * @param season - can be one of either "spring", "summer", "fall" or "winter"
   * @param threshold - maximum item weight before it is considered too heavy
   * @return true if the figure is good, false otherwise
   */
  public boolean isGood(String season, float threshold) {
    int stylePoints = hat.computeStyle(season);
    boolean isHatStylish = (this.hat != null) && (stylePoints >= 6);
    boolean isLeftItemHeavy = (this.leftItem != null) && leftItem.isHeavy(threshold);
    boolean isRightItemHeavy = (this.rightItem != null) && rightItem.isHeavy(threshold);

    if (isHatStylish && !isLeftItemHeavy && !isRightItemHeavy) {
      return true;
    }

    return false;
  }
}