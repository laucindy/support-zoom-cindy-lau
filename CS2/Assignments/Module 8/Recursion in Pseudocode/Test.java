public class Test {
  public static void main(String[] args) {
    float distance = 25;
    System.out.println("iterative: " + getStepsIterative(distance));
    System.out.println("recursive: " + getStepsRecursive(distance));
  }

  public static int getStepsIterative(float distance) {
    int steps = 0;
    while (distance > 1) {
      distance = distance / 2;
      steps++;
    }

    // add a final step
    steps++;

    return steps;
  }

  public static int getStepsRecursive(float distance) {
    if (distance == 1 || distance < 1) return 1;

    int steps = getStepsRecursive(distance/2) + 1;

    return steps;
  }

  public static int sumIterativeQ1(int number) {
    int sum = 0;
    for (int i = 1; i <= number; i++) {
      sum += i;
    }

    return sum;
  }

  public static int sumRecursiveQ1(int number) {
    if (number == 1) return 1;

    int sum = sumRecursiveQ1(number - 1) + number;

    return sum;
  }
}