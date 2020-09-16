public class Fibonacci {
  public static void main(String[] args) {
    int n = 10;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 9;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 8;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 7;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 6;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 5;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 4;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 3;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 1;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));

    n = 0;
    System.out.println("The Fibonnaci number of " + n + " is: " + Fib(n));
  }

  public static int Fib(int n) {
    if (n == 0 || n == 1) return n;

    int fibonacciNumber = Fib(n-1) + Fib(n-2);

    return fibonacciNumber;
  }
}
