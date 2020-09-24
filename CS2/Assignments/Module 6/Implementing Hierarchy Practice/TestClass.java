public class TestClass {
  TestClass() {

  }

  public static void main(String[] args) {
    Fruit fruit = new Fruit();
    fruit.print();

    Vegetable vegetable = new Vegetable();
    vegetable.print();
    System.out.println("");

    Apple apple = new Apple();
    apple.print();
    System.out.println("");

    // fujiApple => test inheritance, call methods from a class higher up
    Apple fujiApple = new FujiApple();
    fujiApple.setName("Fuji apple");
    fujiApple.setOrigin("Japan");
    fujiApple.setNumberOfSeeds(7);
    fujiApple.print();
    fujiApple.printFruitStats();
    System.out.println("");

    // grannySmith => test a method specific to the GrannySmithApple class (adding baking recipes), and 
    // test that calling the `printFruitStats()` method from a class higher up still works
    GrannySmithApple grannySmith = new GrannySmithApple("Granny Smith", "green", "Washington", 10);
    grannySmith.addBakingRecipe("apple pie");
    grannySmith.addBakingRecipe("apple crisp");
    grannySmith.addBakingRecipe("apple cinnamon muffins");
    grannySmith.print();
    grannySmith.printFruitStats();
    System.out.println("");

    Orange orange = new Orange();
    orange.print();
    System.out.println("");

    // test super keyword
    Orange bloodOrange = new BloodOrange();
    bloodOrange.print();
    bloodOrange.printTypeOfOrange();
    bloodOrange.printFruitStats();
    System.out.println("");

    Potato potato = new Potato();
    potato.print();
    System.out.println("");

    // test that the `print()` method from the Potato class has the correct output
    // ("This is a Yukon potato!", instead of "This is a potato!")
    Potato yukonPotato = new YukonPotato("Yukon potato", "golden brown", "Canada");
    yukonPotato.print();
    yukonPotato.printVegetableStats();    
  }
}