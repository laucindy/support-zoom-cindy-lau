public class LegoHat {
  String style;
  int size;

  public LegoHat(String style, int size) {
    this.style = style;
    this.size = size;
  }

  /**
   * Converts the hat to a string, of the format "a(n) (size) (style)"
   * eg, "a medium toque"
   */
  public String toString() {
    String prefix = "a";
    String sizeToString = sizeToString(this.size);

    // change prefix from "a" to "an" if first character of sizeToString begins with "e"
    if (sizeToString.charAt(0) == 'e') {
      prefix += "n";
    }

    return prefix + " " + sizeToString + " " + this.style;
  }

  /**
   * Given a hat, determines whether it is stylish or not.
   * Similar to fashion magazines, a hat will be randomly stylish, depending on the program's mood (barring the exceptions noted below)
   * @param season - one of the following: "spring", "summer", "fall", or "winter"
   * @return - a random number between 1 or 10, unless the specific combination is a toque in winter (returns 10), a sun visor in summer (returns 10), a toque not in winter (returns 1) or a sun visor not in summer (returns 1)
   */
  public int computeStyle(String season) {
    if (((this.style == "toque") && (season != "winter")) || ((this.style == "sun visor") && (season != "summer"))) {
      return 1;
    }

    if (((this.style == "toque") && (season == "winter")) || ((this.style == "sun visor") && (season == "summer"))) {
      return 10;
    }

    int randomNumber = (int) (Math.random() * 10) + 1;    // range between 1 to 10

    return randomNumber;
  }

  /**
   * Prints out whether the given hat and season combination is stylish
   * @param hat - the hat, converted to a string using the toString() function within this class
   * @param season - one of the following: "spring", "summer", "fall", or "winter"
   * @param stylePoints - the integer returned from computeStyle
   */
  public static void printStyle(String hat, String season, int stylePoints) {
    String stylePointsString = stylePoints + " style point";

    if (stylePoints > 1) {
      stylePointsString += "s";
    }

    System.out.println("Is " + hat + " in " + season + " stylish? This combination is awarded " + stylePointsString + "!");
  }

  /**
   * Converts a numerical size to the text equivalent (eg, a size 5 = medium)
   * @param size - an integer
   * @return - a string representing a size
   */
  private String sizeToString(int size) {
    if (size <= 2) {
      return "extra small";
    } else if (size <= 4) {
      return "small";
    } else if (size <= 6) {
      return "medium";
    } else if (size <= 8) {
      return "large";
    } else if (size <= 10) {
      return "extra large";
    } else {
      return "extra extra large";
    }
  }
}