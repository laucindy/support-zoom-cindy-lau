public class GrannySmithApple extends Apple {
  public GrannySmithApple() {
    this.color = "green";
  }

  public GrannySmithApple(String name, String color, String origin) {
    this.name = name;
    this.color = color;
    this.origin = origin;
  }

  public GrannySmithApple(String name, String color, String origin, int numberOfSeeds) {
    this.name = name;
    this.color = color;
    this.origin = origin;
    this.numberOfSeeds = numberOfSeeds;
  }

  public void print() {
    System.out.println("This is a Granny Smith apple");
  }
}
