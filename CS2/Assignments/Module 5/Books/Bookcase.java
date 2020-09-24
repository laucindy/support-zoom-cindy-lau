public class Bookcase {
  private int MAX_LENGTH = 10;
  private Book[] topShelf = new Book[MAX_LENGTH];
  private Book[] middleShelf = new Book[MAX_LENGTH];
  private Book[] bottomShelf = new Book[MAX_LENGTH];
  private Book[] leftShelf = new Book[MAX_LENGTH];
  private Book[] rightShelf = new Book[MAX_LENGTH];

  private Book[][] shelves = { topShelf, middleShelf, bottomShelf, leftShelf, rightShelf };

  public Book[] getTopShelf() { return topShelf; }
  public Book[] getMiddleShelf() { return middleShelf; }
  public Book[] getBottomShelf() { return bottomShelf; }
  public Book[] getLeftShelf() { return leftShelf; }
  public Book[] getRightShelf() { return rightShelf; }
  public Book[][] getShelves() { return shelves; }

  /**
   * Adds a book back to the first available spot on any shelf
   * @param book - the book to add
   * @return true if book was successfully added back to the shelf, false otherwise
   */
  public boolean addBook(Book book) {
    for (int i = 0; i < shelves.length; i++) {
      for (int j = 0; j < shelves[i].length; j++) {
        if (shelves[i][j] == null) {
          shelves[i][j] = book;
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Adds a book to a specific shelf
   * @param book - the book to add
   * @param shelf - either the top, middle, bottom, left or right shelf
   * @return true if book was successfully added back to the shelf, false otherwise
   */
  public boolean addBook(Book book, Book[] shelf) {
    int i = 0;
    while ((i < shelf.length) && (shelf[i] != null)) {
      i++;
    }

    if (i < shelf.length) {
      // add book to shelf
      shelf[i] = book;
      return true;
    } else {
      // shelf is full
      return false;
    }
  }

  /**
   * Searches through all shelves to find the book to remove
   * @param bookToRemove
   * @return a reference to the book that has been removed from the shelf, or null if the book wasn't found
   */
  public Book removeBook(Book bookToRemove) {
    Book foundBook = null;
    int i = 0;

    while ((foundBook == null) && (i < shelves.length)) {
      foundBook = removeBook(bookToRemove, shelves[i]);
      i++;
    }

    return foundBook;
  }

  /**
   * Remove a book from a specific shelf
   * @param bookToRemove - the book to remove from the shelf
   * @param shelf - either the top, middle, bottom, left or right shelf
   * @return a reference to the book that has been removed from the shelf, or null if the book wasn't found
   */
  public Book removeBook(Book bookToRemove, Book[] shelf) {
    for (int i = 0; i < shelf.length; i++) {
      if (shelf[i] == null) continue;
      
      Book book = shelf[i];

      if (book.equals(bookToRemove)) {
        shelf[i] = null;    // remove book from shelf
        return book;
      }
    }

    return null;
  }

  /**
   * Remove a book from a specific shelf, based on the book title only
   * @param titleToRemove - the book to remove from the shelf, by book title
   * @param shelf - either the top, middle, bottom, left or right shelf
   * @return a reference to the book that has been removed from the shelf, or null if the book wasn't found
   */
  public Book removeBook(String titleToRemove, Book[] shelf) {
    // loop through books on a shelf, and return the book
    for (int i = 0; i < shelf.length; i++) {
      if (shelf[i] == null) continue;

      Book book = shelf[i];

      if (book.getTitle() == titleToRemove) {
        shelf[i] = null;    // remove book from shelf
        return book;
      }
    }

    return null;
  }

  /**
   * Searches through all shelves to find the book to remove (searches for only a book title match)
   * @param bookToRemove
   * @return a reference to the book that has been removed from the shelf, or null if the book wasn't found
   */
  public Book removeBook(String titleToRemove) {
    Book foundBook = null;
    int i = 0;

    while ((foundBook == null) && (i < shelves.length)) {
      foundBook = removeBook(titleToRemove, shelves[i]);
      i++;
    }

    return foundBook;
  }

  /**
   * Prints the books that are on a specific shelf
   * @param shelf - either the top, middle, bottom, left or right shelf
   */
  public void printBooksOnShelf(Book[] shelf) {
    for (int i = 0; i < shelf.length; i++) {
      System.out.println("shelf[" + i + "]: " + shelf[i]);
    }
  }

  public void printAllBooks() {
    for (int i = 0; i < shelves.length; i++) {
      for (int j = 0; j < shelves[i].length; j++) {
        System.out.println("shelves[" + i + "][" + j + "]: " + shelves[i][j]);
      }
    }
  }
}
