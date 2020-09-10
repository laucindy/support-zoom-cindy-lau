package data;

/**
 * Used in the most published author function (in BibliographyDatabase.java)
 * Keeps track of the author : published articles count, and increments the count
 * 
 * https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
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
