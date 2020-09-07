package data;

public class Article {
  private String title;
  private String author;
  private Issue reference;

  public Article(String title, String author, Issue reference) {
    this.title = title;
    this.author = author;
    this.reference = reference;
  }

  public String getTitle() { return title; }
  public String getAuthor() { return author; }
  public Issue getIssueRef() { return reference; }

  public String toString() {
    return author + ". " + title + ". " + reference.getJournalRef() + ", " + reference.getVolumeNum() + "(" + reference.getIssueNum() + "), " + reference.getYearPublished();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Article)) return false;
    
    Article o = (Article) obj;
    return (o.title == this.title) && (o.author == this.author);
  }
}