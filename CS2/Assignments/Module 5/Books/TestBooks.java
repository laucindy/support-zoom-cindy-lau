public class TestBooks {
  public static void main(String args[]) {
    Bookcase bookcase = new Bookcase();
    addBooks(bookcase);

    System.out.println("\n\n\u001b[44;1mTEST 1: Take and replace books\u001b[0m \033[37m");
    testTakeAndReplaceBooks(bookcase);

    System.out.println("\n\n\u001b[44;1mTEST 2: Add new books to shelf\u001b[0m \033[37m");
    testAddNewBooks(bookcase);

    System.out.println("\n\n\u001b[44;1mTEST 3: Place book onto another shelf\u001b[0m \033[37m");
    testPlaceBookOnAnotherShelf(bookcase);

    System.out.println("\n\n\u001b[44;1mTEST 4: Search for book not on shelf\u001b[0m \033[37m");
    testNonExistentBook(bookcase);

    System.out.println("\n\n\u001b[44;1mTEST 5: Search all bookshelves for book\u001b[0m \033[37m");
    testSearchAllShelves(bookcase);
  }

  /**
   * Test taking and replacing a book from a shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void testTakeAndReplaceBooks(Bookcase bookcase) {
    Book[] topShelf = bookcase.getTopShelf();
    Reader reader = new Reader();

    System.out.println("\033[92m \nAttempting to take out 'The Two Towers'...\033[37m");
    reader.takeBook(new Book("The Two Towers", "J.R.R. Tolkien", 9780008376079L), bookcase, topShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    // try to take a book when another book has already been taken out
    System.out.println("\033[92m \nAttempting to take out 'The Return of the King'...\033[37m");
    reader.takeBook("The Return of the King", bookcase, topShelf);    // outputs an error

    System.out.println("\033[92m \nPutting the 'The Two Towers' back on the top shelf...\033[37m");
    reader.placeBook(bookcase, topShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nAttempting to take out 'The Return of the King'...\033[37m");
    reader.takeBook("The Return of the King", bookcase, topShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nPutting 'The Return of the King' back on the top shelf...\033[37m");
    reader.placeBook(bookcase, topShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

  //  bookcase.printBooksOnShelf(topShelf);
  }

  /**
   * Test adding new books to a shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void testAddNewBooks(Bookcase bookcase) {
    Book[] leftShelf = bookcase.getLeftShelf();
    Book[] bottomShelf = bookcase.getBottomShelf();
    Reader reader = new Reader();

    System.out.println("\033[92m \nAttempting to add 'Fahrenheit 451 to the left bookshelf'...\033[37m");
    reader.placeBook(bookcase, leftShelf, new Book("Fahrenheit 451", "Ray Bradbury", 9780307475312L));

    System.out.println("\033[92m \nAttempting to add 'Fahrenheit 451 to the bottom bookshelf'...\033[37m");
    reader.placeBook(bookcase, bottomShelf, new Book("Fahrenheit 451", "Ray Bradbury", 9780307475312L));

    System.out.println("\nBooks on the bottom shelf:");
    bookcase.printBooksOnShelf(bottomShelf);
  }

  /**
   * Test taking a book from one bookshelf, and placing it on another
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void testPlaceBookOnAnotherShelf(Bookcase bookcase) {
    Book[] topShelf = bookcase.getTopShelf();
    Book[] rightShelf = bookcase.getRightShelf();
    Reader reader = new Reader();

    System.out.println("\033[92m \nOriginal book order for top and right shelves: \033[37m");

    System.out.println("\nTop shelf:");
    bookcase.printBooksOnShelf(topShelf);

    System.out.println("\nRight shelf:");
    bookcase.printBooksOnShelf(rightShelf);

    System.out.println("\033[92m \nAttempting to take out 'The Hobbit' from the right shelf...\033[37m");
    reader.takeBook("The Hobbit", bookcase, rightShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nPutting the 'The Hobbit' back on the top shelf...\033[37m");
    reader.placeBook(bookcase, topShelf);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nNew book order for top and right shelves: \033[37m");

    System.out.println("\nTop shelf:");
    bookcase.printBooksOnShelf(topShelf);

    System.out.println("\nRight shelf:");
    bookcase.printBooksOnShelf(rightShelf);
  }

  /**
   * Attempt to take a book that isn't on a bookshelf. Returns an error message.
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void testNonExistentBook(Bookcase bookcase) {
    Book[] middleShelf = bookcase.getMiddleShelf();
    Reader reader = new Reader();
    Book bookToFind = new Book("The Picture of Dorian Gray", "Oscar Wilde", 9780141442464L);

    System.out.println("\033[92m \nAttempting to take out 'The Picture of Dorian Gray' from the middle shelf...\033[37m");
    reader.takeBook(bookToFind, bookcase, middleShelf);

    System.out.println("\033[92m \nAttempting to take out 'Little Women' from the middle shelf...\033[37m");
    reader.takeBook("Little Women", bookcase, middleShelf);
  }
  
  /**
   * Test searching through all bookshelves for a specific book object, or book title
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void testSearchAllShelves(Bookcase bookcase) {
    Reader reader = new Reader();

    System.out.println("\033[92m \nAttempting to take out 'Pride and Prejudice'...\033[37m");
    reader.takeBook("Pride and Prejudice", bookcase);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nPutting 'Pride and Prejudice' back on the first available shelf spot...\033[37m");
    reader.placeBook(bookcase);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nAttempting to take out 'The Great Gatsby'...\033[37m");
    reader.takeBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 9780199536405L), bookcase);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nPutting 'The Great Gatsby' back on the first available shelf spot...\033[37m");
    reader.placeBook(bookcase);
    System.out.println("Currently reading: " + reader.getCurrentBook());

    System.out.println("\033[92m \nAttempting to take out 'The Odyssey'...\033[37m");
    reader.takeBook("The Odyssey", bookcase);
    System.out.println("Currently reading: " + reader.getCurrentBook());

  //  System.out.println("\033[92m \nCheck new book order...\033[37m");
  //  bookcase.printAllBooks();
  }
  /**
   * Add books to the top, middle, bottom, left and right shelves
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  public static void addBooks(Bookcase bookcase) {
    addBooksToTopShelf(bookcase);
    addBooksToMiddleShelf(bookcase);
    addBooksToBottomShelf(bookcase);
    addBooksToLeftShelf(bookcase);
    addBooksToRightShelf(bookcase);
  }

  /**
   * Helper method for adding books to each shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   * @param shelf - the specific shelf to add books to
   * @param books - an array of books to be added to the shelf
   */
  private static void addBooksToShelf(Bookcase bookcase, Book[] shelf, Book[] books) {
    for (int i = 0; i < books.length; i++) {
      boolean successfullyAdded = bookcase.addBook(books[i], shelf);

      if (!successfullyAdded) {
        System.out.println(books[i].getTitle() + " could not be added to the shelf, as it's already full");
      }
    }
  }

  /**
   * Add books to the top shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  private static void addBooksToTopShelf(Bookcase bookcase) {
    Book[] books = new Book[10];
    books[0] = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 9780008376062L);
    books[1] = new Book("The Two Towers", "J.R.R. Tolkien", 9780008376079L);
    books[2] = new Book("The Return of the King", "J.R.R. Tolkien", 9780008376086L);

    Book[] shelf = bookcase.getTopShelf();
    addBooksToShelf(bookcase, shelf, books);
  }

  /**
   * Add books to the middle shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  private static void addBooksToMiddleShelf(Bookcase bookcase) {
    Book[] books = new Book[10];
    books[0] = new Book("The Wealthy Barber", "David Chilton", 9780761513117L);
    books[1] = new Book("The Wealthy Barber Returns", "David Chilton", 9781721342198L);
    books[2] = new Book("Worry-Free Money", "Shannon Lee Simmons", 9781443454452L);
    books[3] = new Book("Stop Over-Thinking Your Money!", "Preet Banerjee", 9780143183518L);
    books[4] = new Book("Millionaire Teacher", "Andrew Hallam", 9780470830062L);
    books[5] = new Book("Wealthing Like Rabbits", "Robert R. Brown", 9780993842306L);
    books[6] = new Book("The Value of Simple", "John Robertson", 9780987818911L);

    Book[] shelf = bookcase.getMiddleShelf();
    addBooksToShelf(bookcase, shelf, books);
  }

  /**
   * Add books to the bottom shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  private static void addBooksToBottomShelf(Bookcase bookcase) {
    Book[] books = new Book[10];
    books[0] = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 9780330508117L);
    
    Book[] shelf = bookcase.getBottomShelf();
    addBooksToShelf(bookcase, shelf, books);
  }

  /**
   * Add books to the left shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  private static void addBooksToLeftShelf(Bookcase bookcase) {
    Book[] books = new Book[10];
    books[0] = new Book("To Kill a Mockingbird", "Harper Lee", 9780061743528L);
    books[1] = new Book("The Great Gatsby", "F. Scott Fitzgerald", 9780199536405L);
    books[2] = new Book("Pride and Prejudice", "Jane Austen", 9780141040349L);
    books[3] = new Book("Jane Eyre", "Charlotte Bronte", 9780143106159L);
    books[4] = new Book("1984", "George Orwell", 9780451524935L);
    books[5] = new Book("The Catcher in the Rye", "J.D. Salinger", 9780241950425L);
    books[6] = new Book("Lord of the Flies", "William Golding", 9780143129400L);
    books[7] = new Book("Animal Farm", "George Orwell", 9780582330870L);
    books[8] = new Book("Frankenstein", "Mary Shelley", 9780312249489L);
    books[9] = new Book("Of Mice and Men", "John Steinbeck", 9780340928653L);

    Book[] shelf = bookcase.getLeftShelf();
    addBooksToShelf(bookcase, shelf, books);
  }

  /**
   * Add books to the right shelf
   * @param bookcase - a bookcase containing shelves (an array of books) and books
   */
  private static void addBooksToRightShelf(Bookcase bookcase) {
    Book[] books = new Book[10];
    books[0] = new Book("The Hobbit", "J.R.R Tolkien", 9780007525508L);
    
    Book[] shelf = bookcase.getRightShelf();
    addBooksToShelf(bookcase, shelf, books);
  }
}