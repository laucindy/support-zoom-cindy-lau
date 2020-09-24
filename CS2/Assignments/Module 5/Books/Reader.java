public class Reader {
  private Book currentBook;

  public Reader() {
    this.currentBook = null;
  }

  public Book getCurrentBook() { return currentBook; }

  /**
   * Search through all shelves for the given book title
   * @param title - the title of the book to search for on the shelf
   * @param bookcase - a bookcase with shelves and books
   */
  public void takeBook(String title, Bookcase bookcase) {
    takeBook(title, bookcase, null);
  }

  /**
   * Take a book from a specific bookshelf, searching by the book title only
   * @param title - the title of the book to search for on the shelf
   * @param bookcase - a bookcase with shelves and books
   * @param shelf - either the top, middle, bottom, left or right shelf
   */
  public void takeBook(String title, Bookcase bookcase, Book[] shelf) {
    if (currentBook != null) {
      System.out.println("You are already reading a book! Return it first before taking '" + title + "'.");
      return;
    }

    if (shelf == null) {
      currentBook = bookcase.removeBook(title);
    } else {
      currentBook = bookcase.removeBook(title, shelf);
    }

    if (currentBook == null) {
      System.out.println("Could not find book with title '" + title + "'. Please try another book.");
    }
  }

  /**
   * Search through all shelves for the given book
   * @param book - the book object to search for on the shelf
   * @param bookcase - a bookcase with shelves and books
   */
  public void takeBook(Book book, Bookcase bookcase) {
    takeBook(book, bookcase, null);
  }

  /**
   * Take a book from a bookshelf, searching by the book object
   * @param book - the book object to search for on the shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   * @param shelf - either the top, middle, bottom, left or right shelf
   */
  public void takeBook(Book book, Bookcase bookcase, Book[] shelf) {
    if (currentBook != null) {
      System.out.println("You are already reading a book! Return it first before taking '" + book.getTitle() + "'.");
      return;
    }

    if (shelf == null) {
      currentBook = bookcase.removeBook(book);
    } else {
      currentBook = bookcase.removeBook(book, shelf);
    }

    if (currentBook == null) {
      System.out.println("Could not find book with title '" + book.getTitle() + "'. Please try another book.");
    }
  }

  /**
   * Place current book that the reader has taken out back into first available spot on any shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public void placeBook(Bookcase bookcase) {
    if (currentBook == null) return;

    if (bookcase.addBook(currentBook)) {
      currentBook = null;
    } else {
      System.out.println(currentBook.getTitle() + "could not be added to the shelf, as it's already full");
    }
  }

  /**
   * Place current book that the reader has taken out back onto a specific bookshelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   * @param shelf - either the top, middle, bottom, left or right shelf
   */
  public void placeBook(Bookcase bookcase, Book[] shelf) {
    if (currentBook == null) return;

    placeBook(bookcase, shelf, currentBook);
    currentBook = null;
  }

  /**
   * Place a specific book onto a bookshelf (eg, for adding a new book to the shelf)
   * Print error message if the book could not be added to the shelf (eg, out of space)
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   * @param shelf - either the top, middle, bottom, left or right shelf
   * @param book - the book to place onto the shelf
   */
  public void placeBook(Bookcase bookcase, Book[] shelf, Book book) {
    boolean successfullyAdded = bookcase.addBook(book, shelf);

    if (!successfullyAdded) {
      System.out.println(book.getTitle() + " could not be added to the shelf, as it's already full");
    }
  }
}
