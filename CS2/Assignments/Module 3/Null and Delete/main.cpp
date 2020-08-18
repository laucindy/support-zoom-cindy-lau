#include <iostream>
using namespace std;

/*  Setting a pointer to null means that it is not pointing to anything useful. As a result, a
    null check is required when looping through the pointerArray. If this isn't included,
    then a segmentation fault error will occur. This basically means that the program attempted
    to access a restricted area of memory.
*/
int main()
{
  int * pointerArray[4];

  pointerArray[0] = new int;
  pointerArray[1] = new int;
  pointerArray[2] = NULL;
  pointerArray[3] = new int;

  *(pointerArray[0]) = 1;
  *(pointerArray[1]) = 10;
  *(pointerArray[3]) = 50;

  for (int i = 0; i < 4; i++) {
    if (pointerArray[i] != NULL) {
      cout << "pointerArray[" << i << "] is: " << *(pointerArray[i]) << endl;
    }
  }

  for (int i = 0; i < 4; i++) {
    if (pointerArray[i] != NULL) {
      delete pointerArray[i];
      pointerArray[i] = NULL;
    }
  }

  return 0;
}