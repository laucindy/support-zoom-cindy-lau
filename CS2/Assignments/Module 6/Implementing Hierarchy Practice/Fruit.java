public class Fruit extends Food {
  // ignore bell peppers have seeds
  protected int numberOfSeeds;

  public Fruit() {
    this.numberOfSeeds = 0;
  }

  public int getNumberOfSeeds() { return numberOfSeeds; }
  public void setNumberOfSeeds(int newNumberOfSeeds ) { numberOfSeeds = newNumberOfSeeds; }

  public void print() {
    System.out.println("This is a fruit");
  }

  public final void printFruitStats() {
    System.out.println(this.name + " stats: " + this.color + ", from " + this.origin + ". It has " + this.numberOfSeeds + " seeds.");
  }
}
