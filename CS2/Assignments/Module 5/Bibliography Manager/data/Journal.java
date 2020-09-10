package data;

import java.util.ArrayList;

public class Journal {
  private String title;
  private ArrayList<Issue> issues = new ArrayList<Issue>();

  public Journal(String title) {
    this.title = title;
  }

  public String getTitle() { return title; }

  public void addIssue(int yearPublished, int volumeNum, int issueNum, Journal journal) {
    Issue i = new Issue(yearPublished, volumeNum, issueNum, journal);
    addIssue(i);
  }

  public void addIssue(Issue i) {
    issues.add(i);
  }

  public void removeIssue(int index) {
    issues.remove(index);
  }

  public void removeIssue(Issue i) {
    issues.remove(i);
  }

  public Issue getIssueAt(int index) {
    return issues.get(index);
  }

  public int getNumIssues() {
    return issues.size();
  }

  public String toString() {
    return this.title;
  }

  /**
   * Creates sample data for testing
   * Creates 2 journals, each with 2 issues, and each issue contains 2 articles
   * @return - an ArrayList, each entry is a Journal object
   */
  public static ArrayList<Journal> getSampleJournals() {
    ArrayList<Journal> journals = new ArrayList<Journal>();

    Journal j1 = new Journal("Journal of Computer Science");
    Journal j2 = new Journal("Journal of Programming");

    Issue i1 = new Issue(2006, 3, 1, j1);
    Issue i2 = new Issue(2010, 5, 2, j1);
    Issue i3 = new Issue (2010, 6, 5, j2);
    Issue i4 = new Issue(2011, 7, 2, j2);

    Article a1 = new Article("All About Java", "Jane Doe", i1);
    Article a2 = new Article("All About C++", "John Smith", i1);
    Article a3 = new Article("All About C#", "Jane Doe", i2);
    Article a4 = new Article("All About Ruby", "Jane Doe", i2);
    Article a5 = new Article("Combined DWT-DCT Digital Image Watermarking", "Ali Al-Haj", i3);
    Article a6 = new Article("Data Mining: A Preprocessing Engine", "Luai A. Shalabi", i3);
    Article a7 = new Article("A Mobile Robot Path Planning Using Genetic Algorithm in Static Environment", "Ismail AL-Taharwa", i4);
    Article a8 = new Article("Cohesion Metrics for Ontology Design and Application", "Haining Yao", i4);

    i1.addArticle(a1);
    i1.addArticle(a2);

    i2.addArticle(a3);
    i2.addArticle(a4);

    j1.addIssue(i1);
    j1.addIssue(i2);

    i3.addArticle(a5);
    i3.addArticle(a6);

    i4.addArticle(a7);
    i4.addArticle(a8);

    j2.addIssue(i3);
    j2.addIssue(i4);

    journals.add(j1);
    journals.add(j2);
    
    return journals;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Journal)) return false;

    Journal o = (Journal) obj;
    return (o.title == this.title) && o.issues.equals(this.issues);
  }
}
