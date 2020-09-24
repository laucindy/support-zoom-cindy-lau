package Outerwear;

import Clothing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Outerwear extends Clothing {
  protected String color;
  protected boolean isForColdWeather;

  public Outerwear() {
    this.color = getRandomColor();
  }

  public Outerwear(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public boolean isForColdWeather() {
    return isForColdWeather;
  }

  private String getRandomColor() {
    String[] colors = { "coral", "yellow", "orange", "sea green", "teal", "silver", "brown", "black" };
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}
