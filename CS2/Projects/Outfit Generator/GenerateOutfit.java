import Shirts.*;
import Pants.*;
import Outerwear.*;
import Shoes.*;
import Accessories.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class GenerateOutfit {
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

  private boolean showDebugMessage = true;


  public GenerateOutfit() {

  }

  public boolean getShowDebugMessage() { return showDebugMessage; }

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



    // get a random item from the Shirts class
    /*Shirts shirt = (Shirts) checkItemIsGood(shirtsList, "isShirtGood", outfit);
    outfit.setShirt(shirt);

    Pants pants = (Pants) checkItemIsGood(pantsList, "isPantsGood", outfit);
    outfit.setPants(pants);

    Outerwear outerwear = (Outerwear) checkItemIsGood(outerwearList, "isOuterwearGood", outfit);
    outfit.setOuterwear(outerwear);

    Shoes shoes = (Shoes) checkItemIsGood(shoesList, "isShoesGood", outfit);
    outfit.setShoes(shoes);

    Accessories accessory = (Accessories) checkItemIsGood(accessoriesList, "isAccessoryGood", outfit);
    outfit.setAccessory(accessory);*/
    
    return outfit;
  }

  public boolean isOutfitGood(Outfit outfit) {
    return (isShirtGood(outfit) && isPantsGood(outfit) && isOuterwearGood(outfit) && isShoesGood(outfit) && isAccessoryGood(outfit));
  }

 /**
   * Check that the shirt follows outfit rules - we always assume that the shirt (being
   * the first item picked), is good
   * @param outfit - the current outfit (at this point, none of the items in this object are filled)
   * @param selectedItem - the shirt, randomly picked from shirtsList
   * @return - whether the shirt is good - this is currently always true
   */
  public boolean isShirtGood(Outfit outfit) {
   return true;
  }

  public boolean isShirtGood(Outfit outfit, Object selectedItem) {    
    return true;
  }

  public boolean isPantsGood(Outfit outfit) {
    return isPantsGood(outfit, outfit.getPants());
  }

  public boolean isPantsGood(Outfit outfit, Object selectedItem) {
    Shirts shirt = outfit.getShirt();
    Pants selectedPants = (Pants) selectedItem;

    // don't wear a long sleeve shirt with shorts
    if (shirt.isLongSleeve() && selectedPants.isShorts()) {
      if (getShowDebugMessage()) System.out.println("Don't pair " + selectedPants + " with a long sleeve shirt (" + shirt + ")");
      return false;
    }

    // avoid mixing brown and grey for shirts, pants and shoes
    if ((shirt.getColor() == "brown" && selectedPants.getColor() == "grey") || (shirt.getColor() == "grey" && selectedPants.getColor() == "brown")) {
      if (getShowDebugMessage()) System.out.println("Don't mix a " + shirt + " shirt and " + selectedPants + "pants together");
      return false;
    }

    // only 1 of shirt, pants, outerwear or shoes can be brightly colored
    int brightlyColoredCount = shirt.isBrightlyColored() ? 1 : 0;
    brightlyColoredCount += selectedPants.isBrightlyColored() ? 1 : 0;

    if (brightlyColoredCount > 1) { 
      if (getShowDebugMessage()) System.out.println(shirt + " is already brightly colored, get another pair of pants instead of: " + selectedPants);
      return false; 
    }

    // only 1 of shirt pants or shoes can have a print
    int printCount = shirt.hasPrint() ? 1 : 0;
    printCount += selectedPants.hasPrint() ? 1 : 0;

    if (printCount > 1) {
      if (getShowDebugMessage()) System.out.println(shirt + " already has a print, get another pair of paints instead of: " + selectedPants);
      return false;
    }

    return true;
  }

  public boolean isOuterwearGood(Outfit outfit) {
    return isOuterwearGood(outfit, outfit.getOuterwear());
  }

  public boolean isOuterwearGood(Outfit outfit, Object selectedItem) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear selectedOuterwear = (Outerwear) selectedItem;

    // if the shirt and pants are formal, then the outerwear should be as well
    if (shirt.isFormal() && pants.isFormal() && !selectedOuterwear.isFormal()) {
      if (getShowDebugMessage()) System.out.println(selectedOuterwear + " is not formal. It doesn't match " + shirt + " and " + pants);
      return false;
    }

    // only 1 of shirt, pants, outerwear or shoes can be brightly colored
    int brightlyColoredCount = (shirt.isBrightlyColored() || outfit.getPants().isBrightlyColored()) ? 1 : 0;
    brightlyColoredCount += selectedOuterwear.isBrightlyColored() ? 1 : 0;

    if (brightlyColoredCount > 1) { 
      if (getShowDebugMessage()) System.out.println("The shirt (" + shirt + ") or pants (" + pants +") is already brightly colored, replace " + selectedOuterwear + " with another piece of outerwear");
      return false; 
    }

    // don't wear a winter coat with shorts
    if (selectedOuterwear.isForColdWeather() && pants.isShorts()) {
      if (getShowDebugMessage()) System.out.println(selectedOuterwear + " shouldn't be worn with " + pants);
      return false;
    }

    return true;
  }

  public boolean isShoesGood(Outfit outfit) {
    return isShoesGood(outfit, outfit.getShoes());
  }

  public boolean isShoesGood(Outfit outfit, Object selectedItem) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();
    Shoes selectedShoes = (Shoes) selectedItem;

    // if the shirt, pants and outerwear are formal, then the shoes should be as well
    if (shirt.isFormal() && pants.isFormal() && outerwear.isFormal() && !selectedShoes.isFormal()) {
      if (getShowDebugMessage()) System.out.println(selectedShoes + " are not formal. It doesn't match " + shirt + ", " + pants + " and " + outerwear);
      return false;
    }

    // don't wear heels with shorts
    if (selectedShoes.hasHeel() && pants.isShorts()) {
      if (getShowDebugMessage()) System.out.println(selectedShoes + " has heels, so it is not compatible with " + pants);
      return false;
    }

    // avoid mixing brown and grey for shirts, pants and shoes
    if (((shirt.getColor() == "brown" || pants.getColor() == "brown") && selectedShoes.getColor() == "grey") || ((shirt.getColor() == "grey" || pants.getColor() == "grey") && selectedShoes.getColor() == "brown")) {
      if (getShowDebugMessage()) System.out.println("Don't mix brown and grey clothes together. Shirt: " + shirt + ", pants: " + pants + ", current shoes: " + selectedShoes);
      return false;
    }

    // only 1 of shirt, pants, outerwear or shoes can be brightly colored
    int brightlyColoredCount = (shirt.isBrightlyColored() || pants.isBrightlyColored() || outfit.getOuterwear().isBrightlyColored()) ? 1 : 0;
    brightlyColoredCount += selectedShoes.isBrightlyColored() ? 1 : 0;

    if (brightlyColoredCount > 1) {
      if (getShowDebugMessage()) System.out.println("The shirt (" + shirt + "), pants (" + pants +") or outerwear (" + outfit.getOuterwear()+ ") is already brightly colored, replace " + selectedShoes + " with another pair of shoes");
      return false;
    }

    // only 1 of shirt pants or shoes can have a print
    int printCount = (shirt.hasPrint() || pants.hasPrint()) ? 1 : 0;
    printCount += selectedShoes.hasPrint() ? 1 : 0;

    if (printCount > 1) {
      if (getShowDebugMessage()) System.out.println(shirt + " or " + pants + " already has a print, get another pair of shoes instead of: " + selectedShoes);
      return false;
    }

    return true;
  }

  public boolean isAccessoryGood(Outfit outfit) {
    return isAccessoryGood(outfit, outfit.getAccessory());
  }

  public boolean isAccessoryGood(Outfit outfit, Object selectedItem) {
    Shirts shirt = outfit.getShirt();
    Pants pants = outfit.getPants();
    Outerwear outerwear = outfit.getOuterwear();
    Shoes shoes = outfit.getShoes();
    Accessories selectedAccessory = (Accessories) selectedItem;

    // if the shirt, pants and outerwear are formal, then the shoes should be as well
    if (shirt.isFormal() && pants.isFormal() && outerwear.isFormal() && shoes.isFormal() && !selectedAccessory.isFormal()) {
      if (getShowDebugMessage()) System.out.println(selectedAccessory + ": not formal. It doesn't match " + shirt + ", " + pants + ", " + outerwear + " and " + shoes);
      return false;
    }

    // if pants do not have pockets, then the accessory should be a bag
    if (!pants.hasPockets() && !selectedAccessory.canStoreItems()) {
      if (getShowDebugMessage()) System.out.println(pants + " doesn't have pockets, so we need to select a bag as the accessory. Current accessory: " + selectedAccessory);
      return false;
    }

    // if any of the items should not be worn with jewelry, then ensure that the accessory is not jewelry
    if ((!shirt.isGoodWithJewelry() || !pants.isGoodWithJewelry() || !outerwear.isGoodWithJewelry() || !shoes.isGoodWithJewelry()) && selectedAccessory.isJewelry()) {
      if (getShowDebugMessage()) System.out.println("Outfit (" + shirt + ", " + pants + ", " + outerwear + ", " + shoes + ") does not work well with jewelry (" + selectedAccessory + "), select another accessory");
      return false;
    }
    
    return true;
  }

  /**
   * Check that the item we randomly pick from the list follows the outfit rules
   * @param list - the list of items in a specific category (eg, a list of shirts, a list of pants, etc)
   * @param methodString - the method to execute after a random item is retrieved from the list. This method
   *                       checks that the item follows the outfit rules
   * @return - an object of the same type as the list that was passed in (eg, a shirts list will return an object of type `Shirts`)
   */
  private Object checkItemIsGood(List<?> list, String methodString, Outfit outfit) {
    Method method = checkMethodExists(methodString);
    Object item;

    if (method == null) System.out.println("Method: " + methodString + " doesn't exist");

    do {
      item = getRandomItem(list);
    } while (!invokeItemIsGood(method, outfit, item));

    return item;
  }

  private Method checkMethodExists(String methodString) {
    Method method = null;

    try {
      method = this.getClass().getMethod(methodString, Outfit.class, Object.class);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    return method;
  }

  private boolean invokeItemIsGood(Method method, Outfit outfit, Object selectedItem) {
    boolean isItemGood = false;

    try {
      isItemGood = (boolean) method.invoke(this, outfit, selectedItem);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    return isItemGood;
  }

  private Object getRandomItem(List<?> list) {
    int randomIndex = getRandomNumber(list.size());
    return list.get(randomIndex);
  }

  private int getRandomNumber(int max) {
    return ThreadLocalRandom.current().nextInt(0, max);
  }

  /**
   * Prints a list. Used for debugging
   * @param list - list of items (for example, shirts, pants, etc)
   */
  /*private void printList(List<?> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("Item: " + list.get(i).toString());
    }
  }*/
}
