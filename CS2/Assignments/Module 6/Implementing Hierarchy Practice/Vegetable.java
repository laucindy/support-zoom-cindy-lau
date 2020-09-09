public class Vegetable extends Food {
  protected String typeOfVegetable;     // eg, root vegetables like potatoes and turnips

  public void print() {
    System.out.println("This is a vegetable");
  }

  public final void printVegetableStats() {
    System.out.println(this.name + " stats: " + this.color + ", from " + this.origin + ". It is a " + this.typeOfVegetable + " vegetable.");
  }
}
