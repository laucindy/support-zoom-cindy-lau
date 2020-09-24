package Shoes;

import Clothing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Shoes extends Clothing {
  protected String color;
  protected boolean hasHeel;

  public Shoes() {
    this.color = getRandomColor();
  }

  public Shoes(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public boolean hasHeel() {
    return hasHeel;
  }

  private String getRandomColor() {
    String[] colors = {"pink", "red", "yellow", "orange", "green", "blue", "purple", "grey", "brown", "black"};
    int randomIndex = ThreadLocalRandom.current().nextInt(0, colors.length);

    return colors[randomIndex];
  }
}