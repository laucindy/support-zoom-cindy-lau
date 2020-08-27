// Testing for printing dominoes
#include <iostream>

using namespace std;

void printDominoes() {
  cout << "1 x 1: " << endl;
  cout << " ------------ " << endl;
  cout << "|     ||     |" << endl;
  cout << "|  *  ||  *  |" << endl;
  cout << "|     ||     |" << endl;
  cout << " ------------ " << endl;

  cout << "2 x 2: " << endl;
  cout << " ------------ " << endl;
  cout << "| *   || *   |" << endl;
  cout << "|     ||     |" << endl;
  cout << "|   * ||   * |" << endl;
  cout << " ------------ " << endl;

  cout << "3 x 3: " << endl;
  cout << " ------------ " << endl;
  cout << "| *   || *   |" << endl;
  cout << "|  *  ||  *  |" << endl;
  cout << "|   * ||   * |" << endl;
  cout << " ------------ " << endl;

  cout << "4 x 4: " << endl;
  cout << " ------------ " << endl;
  cout << "| * * || * * |" << endl;
  cout << "|     ||     |" << endl;
  cout << "| * * || * * |" << endl;
  cout << " ------------ " << endl;

  cout << "5 x 5: " << endl;
  cout << " ------------ " << endl;
  cout << "| * * || * * |" << endl;
  cout << "|  *  ||  *  |" << endl;
  cout << "| * * || * * |" << endl;
  cout << " ------------ " << endl;

  cout << "6 x 6: " << endl;
  cout << " ------------" << endl;
  cout << "| * * || * * |" << endl;
  cout << "| * * || * * |" << endl;
  cout << "| * * || * * |" << endl;
  cout << " ------------" << endl;
}

int main() {
  printDominoes();
  return 0;
}