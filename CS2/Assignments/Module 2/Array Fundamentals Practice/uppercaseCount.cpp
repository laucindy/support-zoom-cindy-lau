#include <iostream>

using namespace std;

int uppercaseCount(char array[], int numItems) {
  int uppercaseLetters = 0;

  for (int i = 0; i < numItems; i++) {
    if ((array[i] >= 'A') && (array[i] <= 'Z')) {
      uppercaseLetters++;
    }
  }

  return uppercaseLetters;
}

int main() {
  // Testing
  const int TEST_ARRAY_SIZE = 10;

  // Test 1: 3 uppercase characters
  char testArray1[TEST_ARRAY_SIZE] = {'A', 'b', 'c', 'd', 'E', 'F', 'g', 'h', 'i', 'j'};
  cout << "There are " << uppercaseCount(testArray1, TEST_ARRAY_SIZE) << " uppercase letters in this array" << endl;

  // Test 2: No uppercase characters
  char testArray2[TEST_ARRAY_SIZE] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
  cout << "There are " << uppercaseCount(testArray2, TEST_ARRAY_SIZE) << " uppercase letters in this array" << endl;

  // Test 3: All uppercase characters
  char testArray3[TEST_ARRAY_SIZE] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
  cout << "There are " << uppercaseCount(testArray3, TEST_ARRAY_SIZE) << " uppercase letters in this array" << endl;

  // Test 4: Array consisting of all spaces (0 uppercase letters)
  char testArray4[TEST_ARRAY_SIZE] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
  cout << "There are " << uppercaseCount(testArray4, TEST_ARRAY_SIZE) << " uppercase letters in this array" << endl;

  // Test 5: Numbers and punctuation in array (4 uppercase letters)
  char testArray5[TEST_ARRAY_SIZE] = {'A', '.', '?', 'D', 'E', '5', 'g', 'H', '1', 'j'};
  cout << "There are " << uppercaseCount(testArray5, TEST_ARRAY_SIZE) << " uppercase letters in this array" << endl;

  return 0;
}