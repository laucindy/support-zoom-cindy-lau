#include <iostream>

using namespace std;

bool isSorted(int array[], int numItems) {
  bool isSorted = true;

  for (int i = 1; i < numItems; i++) {
    if (array[i - 1] > array[i]) {
      isSorted = false;
      break;
    }
  }

  return isSorted;
}

int main() {
  // Testing

  // Test 1: Ascending order
  const int TEST_ARRAY_1_SIZE = 7;
  int testArray1[TEST_ARRAY_1_SIZE] = {0, 2, 4, 5, 6, 7, 8};
  cout << "isSorted returned " << isSorted(testArray1, TEST_ARRAY_1_SIZE) << endl;

  // Test 2: Not in ascending order
  const int TEST_ARRAY_2_SIZE = 7;
  int testArray2[TEST_ARRAY_2_SIZE] = {4, 2, 4, 5, 6, 7, 8};
  cout << "isSorted returned " << isSorted(testArray2, TEST_ARRAY_2_SIZE) << endl;

  // Test 3: Not in ascending order
  const int TEST_ARRAY_3_SIZE = 7;
  int testArray3[TEST_ARRAY_3_SIZE] = {0, 2, 4, 5, 60, 7, 8};
  cout << "isSorted returned " << isSorted(testArray3, TEST_ARRAY_3_SIZE) << endl;

  // Test 4: Array with 1 element (returns true)
  const int TEST_ARRAY_4_SIZE = 1;
  int testArray4[TEST_ARRAY_4_SIZE] = {25};
  cout << "isSorted returned " << isSorted(testArray4, TEST_ARRAY_4_SIZE) << endl;

  // Test 5: Array with letters in order (returns true)
  const int TEST_ARRAY_5_SIZE = 5;
  int testArray5[TEST_ARRAY_5_SIZE] = {'a', 'b', 'c', 'd', 'e'};
  cout << "isSorted returned " << isSorted(testArray5, TEST_ARRAY_5_SIZE) << endl;

  // Test 6: Array with letters not in order (returns false)
  const int TEST_ARRAY_6_SIZE = 5;
  int testArray6[TEST_ARRAY_6_SIZE] = {'e', 'a', 'b', 'c', 'd'};
  cout << "isSorted returned " << isSorted(testArray6, TEST_ARRAY_6_SIZE) << endl;

  return 0;
}