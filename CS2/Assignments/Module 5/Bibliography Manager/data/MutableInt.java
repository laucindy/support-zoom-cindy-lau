package data;

/**
 * Used in the most published author function (in BibliographyDatabase.java)
 * Keeps track of the author : published articles count, and increments the count
 */
public class MutableInt {
  int value = 1;

  public int getValue() { return value; }

  public void increment() {
    ++value;
  }

  public String toString() {
    return Integer.toString(value);
  }
}
