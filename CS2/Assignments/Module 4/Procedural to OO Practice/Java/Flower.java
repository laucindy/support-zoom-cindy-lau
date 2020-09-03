public class Flower {
  String color;
  int height;
  float percentWater;

  public Flower(String color, int height, float percentWater) {
    this.color = color;
    this.height = height;
    this.percentWater = percentWater;
  }

  public void printFlower() {
    System.out.println(this.color + " (" + this.height + " cm, " + this.percentWater + "% water)");
  }

  public void growFlower() {
    this.height += 2;
    this.percentWater -= 0.05f;
  }

  public void waterFlower() {
    this.percentWater += 0.1f;
  }
}