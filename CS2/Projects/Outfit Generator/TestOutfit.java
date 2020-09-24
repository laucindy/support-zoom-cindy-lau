public class TestOutfit {
  public static void main(String[] args) {
    Outfit outfit = (new GenerateOutfit()).generateOutfit();    
    System.out.println("Outfit 1:\n\t" + outfit + "\n");

    // re-randomize the colors and generate a new outfit
    outfit = (new GenerateOutfit()).generateOutfit();
    System.out.println("Outfit 2:\n\t" + outfit + "\n");

    // re-randomize the colors and generate a new outfit
    outfit = (new GenerateOutfit()).generateOutfit();
    System.out.println("Outfit 3:\n\t" + outfit + "\n");
  }
}