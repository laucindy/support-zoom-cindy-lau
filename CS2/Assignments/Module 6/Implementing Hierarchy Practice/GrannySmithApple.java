import java.util.*;

public class GrannySmithApple extends Apple {
  private List<String> bakingRecipes = new ArrayList<String>();

  public GrannySmithApple() {
    this.color = "green";
  }

  public List<String> getBakingRecipes() { return bakingRecipes; }

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

  public void addBakingRecipe(String item) {
    bakingRecipes.add(item);
  }

  public void print() {
    System.out.println("This is a Granny Smith apple, and it's good for baking: ");

    for (int i = 0; i < bakingRecipes.size(); i++) {
      System.out.println(bakingRecipes.get(i));
    }

    System.out.println("");
  }
}
