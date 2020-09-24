package data;

import java.util.ArrayList;

public class Issue {
  private int yearPublished;
  private int volumeNum;
  private int issueNum;
  private ArrayList<Article> articles = new ArrayList<Article>();
  private Journal reference;

  public Issue(int yearPublished, int volumeNum, int issueNum, Journal reference) {
    this.yearPublished = yearPublished;
    this.volumeNum = volumeNum;
    this.issueNum = issueNum;
    this.reference = reference;
  }

  public int getYearPublished() { return yearPublished; }
  public int getVolumeNum() { return volumeNum; }
  public int getIssueNum() { return issueNum; }
  public Journal getJournalRef() { return reference; }

  public void addArticle(String title, String author, Issue issue) {
    Article a = new Article(title, author, issue);
    addArticle(a);
  }

  public void addArticle(Article a) {
    articles.add(a);
  }

  public void removeArticle(int index) {
    articles.remove(index);
  }

  public void removeArticle(Article a) {
    articles.remove(a);
  }

  public Article getArticleAt(int index) {
    return articles.get(index);
  }

  public int getNumArticles() {
    return articles.size();
  }

  public String toString() {
    return "Volume " + volumeNum + ", Issue " + issueNum + " (" + yearPublished + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Issue)) return false;

    Issue o = (Issue) obj;
    return (o.yearPublished == this.yearPublished) && (o.volumeNum == this.volumeNum) && (o.issueNum == this.issueNum) && (o.articles.equals(this.articles));
  }
}
