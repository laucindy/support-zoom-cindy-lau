package Pants;

import Clothing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Pants extends Clothing {
  protected String color;
  protected boolean hasPockets;
  protected boolean isShorts;

  public Pants() {
    this.color = getRandomColor();
  }

  public Pants(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public boolean hasPockets() {
    return hasPockets;
  }

  public boolean isShorts() {
    return isShorts;
  }

  private String getRandomColor() {
    String[] colors = { "maroon", "green", "blue", "brown", "black" };
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}