public class TestClass {
  public static void main(String[] args) {
    // \033[92m => output text in green, \033[37m => output text in white
    // Colors: https://en.wikipedia.org/wiki/ANSI_escape_code#Colors

    System.out.println("\033[92m \nTest LegoHat class: \033[37m");
    testLegoHatClass();

    System.out.println("\033[92m \nTest LegoItem class: \033[37m");
    testLegoItemClass();

    System.out.println("\033[92m \nTest LegoMinifigure various item combination strings: \033[37m");
    testLegoMinifigureItemCombinations();

    System.out.println("\033[92m \nTest LegoMinifigure swap and replace functions: \033[37m");
    testLegoMinifigureSwapAndReplace();

    System.out.println("\033[92m \nTest LegoMinifigure isGood() function: \033[37m");
    testLegoMinifigureIsGood();
  }

  /**
   * Test the Lego Hat class, with various hats and seasons
   * Prints out whether the given hat in a specific season is styish or not 
   * (1 for being completely ugly, 10 for being completely perfect)
   */
  public static void testLegoHatClass() {
    // Toque in winter - completely perfect (style points: 10)
    LegoHat mediumToque = new LegoHat("toque", 6);
    String season = "winter";
    LegoHat.printStyle(mediumToque.toString(), season, mediumToque.computeStyle(season));

    // Toque in summer - completely ugly (style points: 1)
    season = "summer";
    LegoHat.printStyle(mediumToque.toString(), season, mediumToque.computeStyle(season));

    System.out.print("\n");

    // Sun visor in summer - completely perfect (style points: 10)
    LegoHat xLSunvisor = new LegoHat("sun visor", 9);
    season = "summer";
    LegoHat.printStyle(xLSunvisor.toString(), season, xLSunvisor.computeStyle(season));

    // Sun visor in winter - completely ugly (style points: 1)
    season = "winter";
    LegoHat.printStyle(xLSunvisor.toString(), season, xLSunvisor.computeStyle(season));
  }

  /**
   * Test the LegoItem class, with various items, and print out the results
   */
  public static void testLegoItemClass() {
    LegoItem sword = new LegoItem("sword", 7.4f);
    LegoItem shield = new LegoItem("shield", 15);
    float threshold = 10f;

    System.out.println("LegoItem sword toString(): " + sword + ". isHeavy(threshold = 10) returns: " + sword.isHeavy(threshold));
    System.out.println("LegoItem shield toString(): " + shield + ". isHeavy(threshold = 10) returns: " + shield.isHeavy(threshold));
  }

  /**
   * Test various combinations of hats and items, and checks that the 
   * LegoMinifigure's toString() function returns the correct string
   */
  public static void testLegoMinifigureItemCombinations() {
    LegoHat hat = new LegoHat("toque", 6);
    LegoItem leftItem = new LegoItem("sword", 10);
    LegoItem rightItem = new LegoItem("shield", 15);

    LegoMinifigure rodneyFigure = new LegoMinifigure("Rodney", null, null, null);

    // No hat, no items
    System.out.println("No hat, no items: \n" + rodneyFigure + "\n");

    // Hat, no items
    rodneyFigure.wearHat(hat);
    System.out.println("Hat only: \n" + rodneyFigure + "\n");

    // Hat, left item only
    rodneyFigure.placeInLeftHand(leftItem);
    System.out.println("Hat, 1 item (left): \n" + rodneyFigure + "\n");

    // Hat, right item only
    rodneyFigure.placeInLeftHand(null);
    rodneyFigure.placeInRightHand(rightItem);
    System.out.println("Hat, 1 item (right): \n" + rodneyFigure + "\n");

    // No hat, right item only
    rodneyFigure.wearHat(null);
    System.out.println("No hat, 1 item (right): \n" + rodneyFigure + "\n");

    // No hat, left item only
    rodneyFigure.placeInRightHand(null);
    rodneyFigure.placeInLeftHand(leftItem);
    System.out.println("No hat, 1 item (left): \n" + rodneyFigure + "\n");

    // No hat, both items
    rodneyFigure.placeInRightHand(rightItem);
    System.out.println("No hat, 2 items: \n" + rodneyFigure + "\n");

    // Hat, both items
    rodneyFigure.wearHat(hat);
    System.out.println("Hat, 2 items: \n" + rodneyFigure + "\n");
  }

  /**
   * Test the swap and replace hat/item functions in the LegoMinifigure class
   */
  public static void testLegoMinifigureSwapAndReplace() {
    // Wearing a hat, and holding two items
    LegoHat cap = new LegoHat("cap", 9);
    LegoItem sword = new LegoItem("sword", 9.8f);
    LegoItem shield = new LegoItem("shield", 14.2f);
    LegoMinifigure linkFigure = new LegoMinifigure("Link", cap, shield, sword);

    System.out.println(linkFigure + "\n");

    // swap left and right items
    linkFigure.swapHands();
    System.out.println("Swapped left and right items:\n" + linkFigure + "\n");

    // swap hats
    LegoHat smallerCap =  new LegoHat("cap", 5);
    linkFigure.wearHat(smallerCap);

    System.out.println("Link can't see! Let's swap hats:\n" + linkFigure + "\n");

    // place another object in the left hand
    LegoItem bow = new LegoItem("bow", 10);
    linkFigure.placeInLeftHand(bow);

    // place another object in the right hand
    LegoItem arrow = new LegoItem("arrow", 2.1f);
    linkFigure.placeInRightHand(arrow);

    System.out.println("Replaced sword and shield with a bow (left) and arrow (right):\n" + linkFigure + "\n");
  }

  /**
   * Test the isGood() function within the LegoMinifigure class
   */
  public static void testLegoMinifigureIsGood() {
    String summer = "summer";
    String winter = "winter";
    float threshold = 5.5f;

    LegoHat hat = new LegoHat("cap", 9);
    LegoItem leftItem = new LegoItem("sword", 9.8f);
    LegoItem rightItem = new LegoItem("shield", 14.2f);
    LegoMinifigure linkFigure = new LegoMinifigure("Link", hat, leftItem, rightItem);

    // return false, because both items are too heavy
    System.out.println(linkFigure);
    System.out.println("linkFigure.isGood() returns: " + linkFigure.isGood(summer, threshold) + "\n");


    System.out.println("Remove items from left and right hand, and replace hat with a toque, season = winter:");
    hat = new LegoHat("toque", 4);
    leftItem = null;
    rightItem = null;

    linkFigure.wearHat(hat);
    linkFigure.placeInLeftHand(leftItem);
    linkFigure.placeInRightHand(rightItem);

    // return true, because it is holding nothing, and the hat's style points is 10
    System.out.println("linkFigure.isGood() returns: " + linkFigure.isGood(winter, threshold) + "\n");

    // add a light item to the left hand
    leftItem = new LegoItem("apple", 3);
    linkFigure.placeInLeftHand(leftItem);

    // return true, because item is light enough and the hat is stylish
    System.out.println("Added a 3.0g apple to the left hand:");
    System.out.println("linkFigure.isGood() returns: " + linkFigure.isGood(winter, threshold));
  }
}