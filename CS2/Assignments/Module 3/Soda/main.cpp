#include <iostream>
using namespace std;

struct soda
{
  int gramsOfSugar;
  float gramsOfCarbonation;
};

// This function initializes, prints and then deletes sodaArray
int main() {
  int ARRAY_SIZE = 3;
  soda **sodaArray = new soda*[3];
  
  // initialize with values
  sodaArray[0] = new soda;
  sodaArray[0]->gramsOfSugar = 41;
  sodaArray[0]->gramsOfCarbonation = 23;

  sodaArray[1] = new soda;
  sodaArray[1]->gramsOfSugar = 33;
  sodaArray[1]->gramsOfCarbonation = 14;

  sodaArray[2] = new soda;
  sodaArray[2]->gramsOfSugar = 25;
  sodaArray[2]->gramsOfCarbonation = 9;

  sodaArray[3] = new soda;
  sodaArray[3]->gramsOfSugar = 52;
  sodaArray[3]->gramsOfCarbonation = 27;

  // print values
  for (int i = 0; i < ARRAY_SIZE; i++) {
    cout << "sodaArray[" << i << "]: " << sodaArray[i]->gramsOfSugar << " grams of sugar, " << sodaArray[i]->gramsOfCarbonation << " grams of carbonation" << endl;
  }

  // delete memory allocated to sodaArray
  for (int i = 0; i < ARRAY_SIZE; i++) {
    delete sodaArray[i];
  }

  delete[] sodaArray;

  return 0;
}