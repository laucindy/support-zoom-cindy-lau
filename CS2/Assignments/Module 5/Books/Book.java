public class Book {
  private String title;
  private String author;
  private long isbn;

  public Book(String title, String author, long isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  public String getTitle() { return title; }
  public String getAuthor() { return author; }
  public long getIsbn() { return isbn; }

  public String toString() {
    return title + " (" + author + "), ISBN: " + isbn;
  }

  @Override
  public boolean equals(Object obj) 
  { 
    if(this == obj) return true; 
    if(obj == null || obj.getClass()!= this.getClass()) return false; 
          
    Book book = (Book) obj; 
          
    return ((book.getTitle() == this.title) && (book.getAuthor() == this.author) && (book.getIsbn() == this.isbn)); 
  } 
}