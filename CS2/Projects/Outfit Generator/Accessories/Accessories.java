package Accessories;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Accessories {
  protected String color;
  protected boolean isFormal;
  protected boolean isJewelry;
  protected boolean canStoreItems;

  public Accessories() {
    this.color = getRandomColor();
  }

  public Accessories(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public boolean isFormal() {
    return isFormal;
  }

  public boolean isJewelry() {
    return isJewelry;
  }

  public boolean canStoreItems() {
    return canStoreItems;
  }

  private String getRandomColor() {
    String[] colors = { "white", "silver", "gold", "rose gold", "black" };
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}
