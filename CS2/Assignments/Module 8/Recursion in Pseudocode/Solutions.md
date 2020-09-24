## Question 1

**Suppose you are given a number n, and you want to determine the sum of all integers from 1 to n (inclusive) using recursion. Explain in English what the base case would be, and how you would reduce the problem size for the recursive call. Write pseudo-code that illustrates what the recursive function would look like, including what the inputs and output would be.**

---

Since the numbers should be summed up from 1 to n, the base case would be when n = 1. The sum should return 1.

The recursive call would only need one input parameter - the number (an integer value). This number would be reduced by one every time it is called, until n = 1. At this point, 1 is returned, and the current number should also be added to it to get the sum.

The iterative function would look something like this:

```
public int sumIterative(int number) {
  int sum = 0;
  for (int i = 1; i <= number; i++) {
    sum += i;
  }

  return sum;
}
```

The recursive function would look like this:

```
public int sumRecursive(int number) {
  if (number == 1) return 1;

  int sum = sumRecursive(number - 1) + number;

  return sum;
}
```

---


## Question 2

**The ancient hero Achilles has an amazing power: he can cut the distance to his goal in half with only a single step. Also, he can take a normal step, which (for Achilles) covers 1 meter. Write pseudocode for a recursive function that counts how many steps Achilles will take to reach his goal, given an input distance in meters.**

---

The base case would be when the distance = 1m. The number of steps returned should be 1.

The iterative function would look like this:

```
public int getStepsIterative(float distance) {
  int steps = 0;
  while (distance > 1) {
    distance = distance / 2;
    steps++;
  }

  // add a final step
  steps++;

  return steps;
}
```

The recursive function would look like this:

```
public static int getStepsRecursive(float distance) {
  if (distance == 1 || distance < 1) return 1;

  int steps = getStepsRecursive(distance/2) + 1;

  return steps;
}
```