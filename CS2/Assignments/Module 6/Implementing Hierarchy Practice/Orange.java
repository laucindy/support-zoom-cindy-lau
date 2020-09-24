public class Orange extends Fruit {
  public Orange() {
    this.color = "orange";
  }

  public Orange(String name, String color, String origin) {
    this.name = name;
    this.color = color;
    this.origin = origin;
  }

  public Orange(String name, String color, String origin, int numberOfSeeds) {
    this.name = name;
    this.color = color;
    this.origin = origin;
    this.numberOfSeeds = numberOfSeeds;
  }

  public void print() {
    System.out.println("This is an orange");
  }

  public void printTypeOfOrange() {
    System.out.println("Type of orange: " + this.name + ", color: " + this.color);
  }
}
