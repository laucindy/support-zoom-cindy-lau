package Pants;

import Clothing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Pants implements Clothing {
  public abstract boolean hasPockets();
  public abstract boolean isShorts();

  protected String color;

  public Pants() {
    this.color = getRandomColor();
  }

  public Pants(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  private String getRandomColor() {
    String[] colors = { "maroon", "green", "blue", "brown", "black" };
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}