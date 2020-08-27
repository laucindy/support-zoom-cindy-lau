// original code below - translate to Java

#include <iostream>
using namespace std;

class scotchTape
{
public:
  string colour;
  int weight;
  int length;
};

void printTapeArray(scotchTape tapeArray[], int length)
{
  for (int i=0; i < length; i++)
  {
    cout << tapeArray[i].colour << " (" 
         << tapeArray[i].length << " cm, "
         << tapeArray[i].weight << " oz)" << endl;
  }
}

void stickTape(scotchTape &tape, float percentToUse)
{
  tape.weight -= (int)(tape.weight * percentToUse);
  tape.length -= (int)(tape.length * percentToUse);
}

int main()
{
  const int NUM_TAPES = 3;
  scotchTape tapes[NUM_TAPES] =
  {
    {"clear", 3, 22},
    {"green", 1, 15},
    {"blue", 2, 19},
  };

  printTapeArray(tapes, NUM_TAPES);

  stickTape(tapes[0], 0.5);
  stickTape(tapes[1], 0.3);
  stickTape(tapes[2], 0.9);

  cout << endl;
  printTapeArray(tapes, NUM_TAPES);

  return 0;
}