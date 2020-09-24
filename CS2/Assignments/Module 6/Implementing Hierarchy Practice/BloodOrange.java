public class BloodOrange extends Orange {
  // pass arguments to the Orange class
  public BloodOrange() {
    super("Blood Orange", "crimson", "Spain", 3);
  }

  public void print() {
    System.out.println("This is a blood orange");
  }

  public void printTypeOfOrange() {
    System.out.println("Going up to the `Orange` class, to the `printTypeOfOrange` method...:");
    super.printTypeOfOrange();
  }
}
