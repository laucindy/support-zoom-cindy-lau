#include <iostream>
#include <iomanip>
using namespace std;

float getAverageScore(int scoreArray[], int length) {
  float total = 0.0;

  for (int i = 0; i < length; i++) {
    total += scoreArray[i];
  }

  return total / length;
}

int main() {
  const int SCORES_LENGTH = 10;
  int scores[SCORES_LENGTH] = { };    // initialize all elements to 0

  for (int i = 0; i < SCORES_LENGTH; i+=2) {
    scores[i] = i;
  }

  cout << "Average score: " << fixed << setprecision(1) << getAverageScore(scores, SCORES_LENGTH) << endl;

  return 0;
}