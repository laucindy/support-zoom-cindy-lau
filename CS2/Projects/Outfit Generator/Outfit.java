import Shirts.*;
import Pants.*;
import Outerwear.*;
import Shoes.*;
import Accessories.*;

public class Outfit {
  private Shirts shirt;
  private Pants pants;
  private Outerwear outerwear;
  private Shoes shoes;
  private Accessories accessory;

  public Shirts getShirt() { return shirt; }
  public Pants getPants() { return pants; }
  public Outerwear getOuterwear() { return outerwear; }
  public Shoes getShoes() { return shoes; }
  public Accessories getAccessory() { return accessory; }

  public void setShirt(Shirts shirt) { this.shirt = shirt; }
  public void setPants(Pants pants) { this.pants = pants; }
  public void setOuterwear(Outerwear outerwear) { this.outerwear = outerwear; }
  public void setShoes(Shoes shoes) { this.shoes = shoes; }
  public void setAccessory(Accessories accessory) { this.accessory = accessory; }

  public String toString() {
    return "Recommended outfit: \n\t" + this.shirt + ", " + this.pants + ", " + this.outerwear + ", " + this.shoes + ", " + this.accessory;
  }
}
