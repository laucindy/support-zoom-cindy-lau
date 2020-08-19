#include "header.h"

using namespace std;

int main() {
  const int DOMINO_SET_SIZE = 28;
  Domino dominoes[DOMINO_SET_SIZE];

  initializeDominoes(dominoes);

  cout << "\nOriginal sort order: \n" << endl;
//  printArray(dominoes, DOMINO_SET_SIZE, true);
  printDominoes(dominoes, DOMINO_SET_SIZE, true);

  cout << "\nSorting by the number on the right hand side of the domino... \n" << endl;
  sort(dominoes, dominoes + DOMINO_SET_SIZE, sortByRightNumber);
  
  cout << "New sort order: \n" << endl;
//  printArray(dominoes, DOMINO_SET_SIZE, false);
  printDominoes(dominoes, DOMINO_SET_SIZE, false);

  return 0;
}

void initializeDominoes(Domino (&dominoes)[28]) {
  const int SUIT_SIZE = 7;
  int k = 0;

  // initialize dominoes array with values
  for (int i = 0; i < SUIT_SIZE; i++) {
    int j = 0;
    while (j <= i) {
      dominoes[k].left = i;
      dominoes[k].right = j;
      j++;
      k++;
    }
  }
}

bool sortByRightNumber(Domino domino1, Domino domino2) {
  return domino2.right > domino1.right;
}

//// Print array functions below

/* Prints the dominoes array using numbers to represent the left and right side of a domino */
void printArray(Domino dominoes[], int numDominoes, bool sortByLeft) {
  for (int i = 0; i < numDominoes; i++) {
    cout << dominoes[i].left << "|" << dominoes[i].right << " ";

    if (i == (numDominoes - 1)) break;

    if (sortByLeft) {
      if (dominoes[i + 1].left > dominoes[i].left) {
        cout << endl;
      }
    } else {
      if (dominoes[i + 1].right > dominoes[i].right) {
        cout << endl;
      }
    }
  }

  cout << endl;
}

/* Prints dominoes as they would physically appear, with the * character representing number of dots */
void printDominoes(Domino dominoes[], int numDominoes, bool sortByLeft) {
  const int NEW_LINE_SIZE = 8;
  int newLineIndexes[NEW_LINE_SIZE] = {0, -1, -1, -1, -1, -1, -1, 28};
  int newLineIndex = 1;

  // get indexes to determine how many dominoes should appear per row
  for (int i = 0; i < numDominoes; i++) {
    if (sortByLeft) {
      if (dominoes[i + 1].left > dominoes[i].left) {
        newLineIndexes[newLineIndex] = i + 1;
        newLineIndex++;
      }
    } else {
      if (dominoes[i + 1].right > dominoes[i].right) {
        newLineIndexes[newLineIndex] = i + 1;
        newLineIndex++;
      }
    }
  }

  // print out dominoes for each row
  for (int i = 1; i < NEW_LINE_SIZE; i++) {
    if (newLineIndexes[i] == -1) break;
    printDomino(dominoes, newLineIndexes[i-1], newLineIndexes[i]);
  }
}

void printDomino(Domino dominoes[], int startIndex, int endIndex) {
  printBorder(dominoes, startIndex, endIndex);
  printFirstLine(dominoes, startIndex, endIndex);
  printSecondLine(dominoes, startIndex, endIndex);
  printThirdLine(dominoes, startIndex, endIndex);
  printBorder(dominoes, startIndex, endIndex);
}

void printBorder(Domino dominoes[], int startIndex, int endIndex) {
  for (int j = startIndex; j < endIndex; j++) {
    cout << " ------------ ";
  }
  
  cout << endl;
}

void printFirstLine(Domino dominoes[], int startIndex, int endIndex) {
  for (int j = startIndex; j < endIndex; j++) {
    int sides[2] = { dominoes[j].left, dominoes[j].right };

    for (int side : sides) {
      switch (side) {
        case 0: case 1:
          cout << "|     |";
          break;
        case 2: case 3:
          cout << "| *   |";
          break;
        case 4: case 5: case 6:
          cout << "| * * |";
          break;
      }
    }
  }

  cout << endl;
}

void printSecondLine(Domino dominoes[], int startIndex, int endIndex) {
  for (int j = startIndex; j < endIndex; j++) {
    int sides[2] = { dominoes[j].left, dominoes[j].right };

    for (int side : sides) {
      switch (side) {
        case 0: case 2: case 4:
          cout << "|     |";
          break;
        case 1: case 3: case 5:
          cout << "|  *  |";
          break;
        case 6:
          cout << "| * * |";
          break;
      }
    }
  }

  cout << endl;
}

void printThirdLine(Domino dominoes[], int startIndex, int endIndex) {
  for (int j = startIndex; j < endIndex; j++) {
    int sides[2] = { dominoes[j].left, dominoes[j].right };

    for (int side : sides) {
      switch (side) {
        case 0: case 1:
          cout << "|     |";
          break;
        case 2: case 3:
          cout << "|   * |";
          break;
        case 4: case 5: case 6:
          cout << "| * * |";
          break;
      }
    }
  }
  
  cout << endl;
}