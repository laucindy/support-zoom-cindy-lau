public class Factorial {
  public static void main(String[] args) {
    int n = 6;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 5;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 4;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 3;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 2;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 1;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));

    n = 0;
    System.out.println("The double factorial of " + n + "!! is: " + factorial2(n));
  }

  public static int factorial2(int n) {
    if (n == 1 || n == 0) return 1;

    int factorial2 = factorial2(n - 2) * n;

    return factorial2;
  }
}