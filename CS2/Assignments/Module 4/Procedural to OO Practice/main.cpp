#include <iostream>
#include <string.h>

using namespace std;

class flower {
  public:
    string color;
    int height;
    float percentWater;

  flower(string color, int height, float percentWater) {
    this->color = color;
    this->height = height;
    this->percentWater = percentWater;
  }

  void printFlower() {
    cout << this->color << " (" << this->height << " cm, " << this->percentWater << "% water)" << endl;
  }

  void growFlower() {
    this->height += 2;
    this->percentWater -= 0.05f;
  }

  void waterFlower() {
    this->percentWater += 0.1f;
  }
};

int main() {
  flower f("purple", 10, 0.5f);

  f.printFlower();

  f.waterFlower();
  f.printFlower();

  f.growFlower();
  f.printFlower();

  return 0;
}