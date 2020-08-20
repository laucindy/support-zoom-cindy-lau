// original code below, written using procedural code. Converted to object oriented code in main.cpp
#include <iostream>
#include <string.h>

using namespace std;

class flower
{
public:
  string color;
  int height;
  float percentWater;
};

void printFlower(flower &f)
{
  cout << f.color << " (" << f.height << " cm, "
       << f.percentWater << "% water)" << endl;
}

void growFlower(flower &f)
{
  f.height += 2;
  f.percentWater -= 0.05f;
}

void waterFlower(flower &f)
{
  f.percentWater += 0.1f;
}

int main()
{
  flower f;
  f.color = "purple";
  f.height = 10;
  f.percentWater = 0.5f;

  printFlower(f);

  waterFlower(f);

  printFlower(f);

  growFlower(f);

  printFlower(f);

  return 0;
}