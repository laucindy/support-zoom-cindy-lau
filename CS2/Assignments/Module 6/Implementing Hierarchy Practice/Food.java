public class Food {
  protected String name;
  protected String color;
  protected String origin;

  public String getName() { return name; }
  public String getColor() { return color; }
  public String getOrigin() { return origin; }

  public void setName(String newName) { name = newName; }
  public void setColor(String newColor) { color = newColor; }
  public void setOrigin(String newOrigin) { origin = newOrigin; }

  public Food() {
    this.name = "Name not set";
    this.color = "color not set";
    this.origin = "no origin";
  }

  public void print() {
    System.out.println("This is a food");
  }
}
