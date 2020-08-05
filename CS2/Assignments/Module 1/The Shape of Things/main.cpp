#include <iostream>

using namespace std;

bool outputChar(int hashNum, int row) {
  bool showCharLeftHalf = (hashNum >= row) && ((hashNum - row) < row);
  bool showCharRightHalf = (hashNum > (19 - row + 1 - row)) && (hashNum <= 19 - row + 1);

  return showCharLeftHalf || showCharRightHalf || ((row == 5) && (hashNum == 10));
}

void drawChar(int row) {
  for (int hashNum = 1; hashNum <= 19; hashNum++) {
      if (outputChar(hashNum, row)) {
        cout << "#";
      } else {
        cout << " ";
      }
    }

    cout << "\n";
}

void drawTopHalf() {
  for (int row = 1; row <= 5; row++) {
    drawChar(row);
  }
}

void drawBottomHalf() {
  for (int row = 5; row >= 0; row--) {
    drawChar(row);
  }
}

int main() {
  drawTopHalf();
  drawBottomHalf();

  return 0;
}