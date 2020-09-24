public class Potato extends Vegetable {
  public Potato() {
    this.name = "potato";
    this.typeOfVegetable = "root";
  }

  public Potato(String name, String color, String origin) {
    this.name = name;
    this.color = color;
    this.origin = origin;
    this.typeOfVegetable = "root";
  }

  public final void print() {
    System.out.println("This is a " + this.name + "!");
  }
}
