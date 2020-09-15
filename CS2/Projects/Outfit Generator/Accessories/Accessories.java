package Accessories;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Accessories {
  protected String color;

  public abstract boolean isFormal();
  public abstract boolean isJewelry();
  public abstract boolean canStoreItems();

  public Accessories() {
    this.color = getRandomColor();
  }

  public Accessories(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  private String getRandomColor() {
    String[] colors = { "white", "silver", "gold", "rose gold", "black" };
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}
