import Shirts.*;
import Pants.*;
import Outerwear.*;
import Shoes.*;
import Accessories.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateOutfit {
  // create new lists. Each subclass for each category is an item in the list

  public List<Shirts> shirtsList = new ArrayList<Shirts>(Arrays.asList(
    new ButtonUps(), new FlannelShirts(), new Tshirts(), new Sweaters()
  ));

  public List<Pants> pantsList = new ArrayList<Pants>(Arrays.asList(
    new BoardShorts(), new Capris(), new DressPants(), new HaremPants(), new Jeans(), new Leggings(), new PlaidShorts(), new Shorts()
  ));

  public List<Outerwear> outerwearList = new ArrayList<Outerwear>(Arrays.asList(
    new BomberJacket(), new CocoonCoat(), new Parka(), new RainJacket(), new SpringJacket(), new TrenchCoat()
  ));

  public List<Shoes> shoesList = new ArrayList<Shoes>(Arrays.asList(
    new AnkleBoots(), new DressShoes(), new Flats(), new Pumps(), new Sneakers()
  ));

  public List<Accessories> accessoriesList = new ArrayList<Accessories>(Arrays.asList(
    new Backpack(), new Clutch(), new EveningBag(), new Hat(), new HoboBag(), new Necklaces(), new Rings(), new Sunglasses(), new Watch()
  ));

  private boolean showDebugMessage = false;

  public boolean showDebugMessage() { return showDebugMessage; }

  /**
   * Randomly generate a new outfit. If the outfit does not meet all of the requirements, then a completely
   * new outfit will be regenerated
   * @return - a outfit that matches all of the outfit rules (as described in the readme.md)
   */
  public Outfit generateOutfit() {
    Outfit outfit = new Outfit();

    // check that all 5 clothing items meet the outfit rules
    do {
      outfit.setShirt((Shirts) getRandomItem(shirtsList));
      outfit.setPants((Pants) getRandomItem(pantsList));
      outfit.setOuterwear((Outerwear) getRandomItem(outerwearList));
      outfit.setShoes((Shoes) getRandomItem(shoesList));
      outfit.setAccessory((Accessories) getRandomItem(accessoriesList));
    } while (!isOutfitGood(outfit));
    
    return outfit;
  }

  /**
   * Checks if the outfit follows the outfit rules
   * @param outfit - the outfit object
   * @return - true if the outfit follows the rules, false otherwise
   */
  public boolean isOutfitGood(Outfit outfit) {

    // only 1 of shirt, pants, outerwear or shoes can be brightly colored and
    // only 1 of shirt, pants or shoes can have a print (an outfit can have an item brightly colored and another with a print)
    if (!checkOnlyOneItemIsBrightlyColored(outfit) || !checkOnlyOneItemHasPrint(outfit)) { return false; }

    // avoid mixing brown and grey for shirts, pants and shoes
    if (checkBrownAndGreyMixed(outfit)) { return false; }

    return (isShirtGood(outfit) && isPantsGood(outfit) && isOuterwearGood(outfit) && isShoesGood(outfit) && isAccessoryGood(outfit));
  }

  // OUTFIT BOOLEAN METHODS

  /**
   * Check if the shirt, pants and/or shoes contain brown and grey. If yes, then
   * it breaks the outfit rules, as brown and grey shouldn't be mixed together in
   * an outfit
   * 
   * @param outfit - the outfit object
   * @return true if a shirt, pants and/or shoes are brown and grey. False
   *         otherwise
   */
  private boolean checkBrownAndGreyMixed(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Shoes shoes = outfit.getShoes();

    String colors = shirt.getColor() + ", " + pants.getColor() + ", " + shoes.getColor();

    if (colors.contains("brown") && colors.contains("grey")) {
      if (showDebugMessage()) {
        System.out.println(
            "Don't mix brown and grey clothes together. Shirt: " + shirt + ", pants: " + pants + ", shoes: " + shoes);
      }

      return true;
    }

    return false;
  }

  /**
   * Check that only 1 of either a shirt, pants, outerwear or shoes is brightly
   * colored
   * 
   * @param outfit - the outfit object
   * @return - true if only 1 item is brightly colored. False otherwise
   */
  private boolean checkOnlyOneItemIsBrightlyColored(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();
    Shoes shoes = outfit.getShoes();

    int brightlyColoredCount = (shirt.isBrightlyColored() ? 1 : 0) + (pants.isBrightlyColored() ? 1 : 0)
        + (outerwear.isBrightlyColored() ? 1 : 0) + (shoes.isBrightlyColored() ? 1 : 0);

    if (brightlyColoredCount > 1) {
      if (showDebugMessage()) {
        System.out.println("The shirt (" + shirt + "), pants (" + pants + ") or outerwear (" + outerwear
            + ") is already brightly colored. We can only have 1 brightly colored item in our outfit. Let's regenerate our outfit");
      }

      return false;
    }

    return true;
  }

  /**
   * Check that only 1 of either a shirt, pants or shoes has a print/pattern
   * 
   * @param outfit - the outfit object
   * @return - true if only 1 item has a print. False otherwise
   */
  private boolean checkOnlyOneItemHasPrint(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Shoes shoes = outfit.getShoes();

    int printCount = (shirt.hasPrint() ? 1 : 0) + (pants.hasPrint() ? 1 : 0) + (shoes.hasPrint() ? 1 : 0);

    if (printCount > 1) {
      if (showDebugMessage()) {
        System.out.println("2 or more of these items: " + shirt + ", " + pants + " or " + shoes
            + " already have a print. Let's regenerate outfits");
      }

      return false;
    }

    return true;
  }

  /**
   * Checks if the shirt follows the outfit rules. Currently set to always return true
   * @param outfit - the outfit object
   * @return - true
   */
  public boolean isShirtGood(Outfit outfit) {
   return true;
  }

  /**
   * Checks if the pants paired with other items in the outfit follow the outfit rules.
   * @param outfit - the outfit object
   * @return - true if it follows the rules, false otherwise
   */
  public boolean isPantsGood(Outfit outfit) {
    // don't wear a long sleeve shirt with shorts
    if (checkLongSleeveAndShorts(outfit)) { return false; }

    return true;
  }

  /**
   * Check if the outfit consists of a long sleeve shirt and shorts. If true, then it
   * breaks the outfit rules
   * @param outfit - the outfit object
   * @return - true if the outfit is a long sleeve shirt + shorts. False otherwise
   */
  private boolean checkLongSleeveAndShorts(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();

    if (shirt.isLongSleeve() && pants.isShorts()) {
      if (showDebugMessage()) {
        System.out.println("Don't pair " + pants + " with a long sleeve shirt (" + shirt + ")");
      }

      return true;
    }

    return false;
  }

  /**
   * Check if the outerwear paired with other items meet the outfit rules
   * @param outfit - the outfit object
   * @return - true if the outfit meets the outfit rules, false otherwise
   */
  public boolean isOuterwearGood(Outfit outfit) {
    // if the shirt and pants are formal, then the outerwear should be as well
    if (!checkFormalClothesFormalOuterwear(outfit)) { return false; }

    // don't wear a winter coat with shorts
    if (checkWinterOuterwearAndShorts(outfit)) { return false; }

    return true;
  }

  /**
   * Check if the shirt and pants are formal items. If they are, then the outerwear should be as well.
   * @param outfit - the outfit object
   * @return - true if the shirt, pants and outerwear are all formal
   */
  private boolean checkFormalClothesFormalOuterwear(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();

    if (shirt.isFormal() && pants.isFormal() && !outerwear.isFormal()) {
      if (showDebugMessage()) {
        System.out.println(outerwear + " is not formal. It doesn't match " + shirt + " and " + pants);
      }

      return false;
    }

    return true;
  }

  /**
   * Check if the outfit outerwear is for winter, and if the pants are shorts. If both are, then they
   * are breaking the outfit rules
   * @param outfit - the outfit object
   * @return true if the outerwear = for winter, and if pants = shorts. False otherwise
   */
  private boolean checkWinterOuterwearAndShorts(Outfit outfit) {
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();

    if (outerwear.isForColdWeather() && pants.isShorts()) {
      if (showDebugMessage()) {
        System.out.println(outerwear + " shouldn't be worn with " + pants);
      }

      return true;
    }

    return false;
  }

  /**
   * Check if the shoes paired with other items meet the outfit rules
   * @param outfit - the outfit object
   * @return - true if the outfit meets the outfit rules, false otherwise
   */
  public boolean isShoesGood(Outfit outfit) {
    // don't wear heels with shorts
    if (checkHeelsPairedWithShorts(outfit)) { return false; }

    return true;
  }

  /**
   * Check if heels are paired with shorts. If yes, return true
   * @param outfit - the outfit object
   * @return - true if heels are paired with shorts. False otherwise
   */
  private boolean checkHeelsPairedWithShorts(Outfit outfit) {
    Pants pants = outfit.getPants();
    Shoes shoes = outfit.getShoes();

    if (shoes.hasHeel() && pants.isShorts()) {
      if (showDebugMessage()) {
        System.out.println(shoes + " has heels, so it is not compatible with " + pants);
      }

      return true;
    }

    return false;
  }

  /**
   * Check that the accessory paired with other items meet the outfit rules
   * @param outfit - the outfit object
   * @return - true if the outfit meets the outfit rules. False otherwise
   */
  public boolean isAccessoryGood(Outfit outfit) {
    // if the shirt, pants, shoes and outerwear are formal, then the accessory should be as well
    if (!checkFormalClothesFormalAccessories(outfit)) { return false; }

    // if pants do not have pockets, then the accessory should be a bag
    if (!checkPantsHavePocketsOrBag(outfit)) { return false; }

    // if any of the items should not be worn with jewelry, then ensure that the accessory is not jewelry
    if (!checkItemsMatchJewelry(outfit)) { return false; }
    
    return true;
  }

  /**
   * Checks if all of the clothing items (shirt, pants, shoes and outerwear) are all formal
   * If they are, then the accessory should be as well
   * @param outfit - the outfit object
   * @return - true if all items including accessory is formal. False otherwise
   */
  private boolean checkFormalClothesFormalAccessories(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();
    Shoes shoes = outfit.getShoes();
    Accessories accessory = outfit.getAccessory();

    if (shirt.isFormal() && pants.isFormal() && outerwear.isFormal() && shoes.isFormal() && !accessory.isFormal()) {
      if (showDebugMessage()) {
        System.out.println(accessory + ": not formal. It doesn't match " + shirt + ", " + pants + ", " + outerwear + " and " + shoes);
      }

      return false;
    }

    return true;
  }

  /**
   * Check if the outfit's pants have pockets. If they don't, then the accessory should be a bag
   * @param outfit - the outfit object
   * @return - false if the pants do not have pockets and the accessory is not a bag. True otherwise
   */
  private boolean checkPantsHavePocketsOrBag(Outfit outfit) {
    Pants pants = outfit.getPants();
    Accessories accessory = outfit.getAccessory();

    if (!pants.hasPockets() && !accessory.canStoreItems()) {
      if (showDebugMessage()) {
        System.out.println(pants + " doesn't have pockets, so we need to select a bag as the accessory. Current accessory: " + accessory);
      }

      return false;
    }

    return true;
  }

  /**
   * Check if the clothing items are all good to wear with jewelry. If they aren't, then the accessory
   * shouldn't be a jewelry piece
   * @param outfit - the outfit object
   * @return - false if the clothing items are not good paired with jewelry, but the accessory is a jewelry piece. True otherwise
   */
  private boolean checkItemsMatchJewelry(Outfit outfit) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();
    Shoes shoes = outfit.getShoes();
    Accessories accessory = outfit.getAccessory();

    if ((!shirt.isGoodWithJewelry() || !pants.isGoodWithJewelry() || !outerwear.isGoodWithJewelry() || !shoes.isGoodWithJewelry()) && accessory.isJewelry()) {
      if (showDebugMessage()) {
        System.out.println("Outfit (" + shirt + ", " + pants + ", " + outerwear + ", " + shoes + ") does not work well with jewelry (" + accessory + "), select another accessory");
      }

      return false;
    }

    return true;
  }

  /**
   * Get a random item from the list (eg, shirts list, pants list, etc)
   * @param list - the list to get an item from
   * @return - the item at a random index in the list
   */
  private Object getRandomItem(List<?> list) {
    int randomIndex = getRandomNumber(list.size());
    return list.get(randomIndex);
  }

  /**
   * Get a random number, from 0 to the max number (not including the max number)
   * @param max - the max number
   * @return - a random integer between 0 and the max
   */
  private int getRandomNumber(int max) {
    return ThreadLocalRandom.current().nextInt(0, max);
  }
}
