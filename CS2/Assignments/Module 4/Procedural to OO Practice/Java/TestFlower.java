public class TestFlower {
  public static void main(String[] args) {
    Flower f = new Flower("purple", 10, 0.5f);

    f.printFlower();
    
    f.waterFlower();
    f.printFlower();

    f.growFlower();
    f.printFlower();
  }
}