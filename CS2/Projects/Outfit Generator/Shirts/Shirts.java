package Shirts;

import Clothing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Shirts extends Clothing { 
  protected String color;
  protected boolean isLongSleeve;

  public Shirts() {
    this.color = getRandomColor();
  }

  public Shirts(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public boolean isLongSleeve() {
    return isLongSleeve;
  }

  private String getRandomColor() {
    String[] colors = {"pink", "red", "yellow", "orange", "green", "blue", "purple", "grey", "brown", "black"};
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}
