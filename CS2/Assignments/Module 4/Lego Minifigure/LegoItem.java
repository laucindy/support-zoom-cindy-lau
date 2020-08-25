public class LegoItem {
  String name;
  float weight;

  public LegoItem(String name, float weight) {
    this.name = name;
    this.weight = weight;
  }

  /**
   * Converts the item to a string, of the format "a (weight)g (name)"
   * eg. "a 10g shield"
   */
  public String toString() {
    return "a " + this.weight + "g " + this.name;
  }

  /**
   * Checks if the item is above a specified threshold
   * @param threshold - item weight to check against
   * @return true if the item is above the specified threshold, false otherwise
   */
  public boolean isHeavy(float threshold) {
    return (this.weight > threshold);
  }
}