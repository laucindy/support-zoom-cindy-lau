package data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class BibliographyDatabase {
  private ArrayList<Journal> journals = new ArrayList<Journal>();

  public BibliographyDatabase(ArrayList<Journal> newJournals) {
    journals.addAll(newJournals);
  }

  // JOURNAL FUNCTIONS

  public void addJournal(String title) {
    Journal j = new Journal(title);
    addJournal(j);
  }

  public void addJournal(Journal j) {
    journals.add(j);
  }

  // remove a specific journal object
  public void removeJournal(Journal j) {
    journals.remove(j);
  }

  // remove a journal at a specified index
  public void removeJournal(int index) {
    journals.remove(index);
  }

  public Journal getJournalAt(int index) {
    return journals.get(index);
  }

  public int getNumJournals() {
    return journals.size();
  }

  public void addListOfJournals(ArrayList<Journal> newList) {
    journals.addAll(newList);
  }

  // ISSUE FUNCTIONS

  public void addIssue(Issue i) {
    Journal journalRef = i.getJournalRef();
    journalRef.addIssue(i);
  }

  public void removeIssue(Issue i) {
    Journal journalRef = i.getJournalRef();

    for (int x = 0; x < getNumJournals(); x++) {
      Journal currentJournal = journals.get(x);

      if (!currentJournal.equals(journalRef)) continue;

      System.out.println("removing issue: " + i);
      currentJournal.removeIssue(i);
    }
  }

  // ARTICLE FUNCTIONS

  public void addArticle(Article a) {
    Issue issueRef = a.getIssueRef();
    Journal journalRef = issueRef.getJournalRef();

    outerloop:
    for (int x = 0; x < getNumJournals(); x++) {
      Journal journal = getJournalAt(x);

      if (!journal.equals(journalRef)) continue;

      for (int y = 0; y < journal.getNumIssues(); y++) {
        Issue issue = journal.getIssueAt(y);

        if (issue.equals(issueRef)) {
          issue.addArticle(a);
          break outerloop;
        }
      }

    }
  }

  public void removeArticle(Article a) {
    Issue issueRef = a.getIssueRef();
    Journal journalRef = issueRef.getJournalRef();

    outerloop:
    for (int x = 0; x < getNumJournals(); x++) {
      Journal currentJournal = getJournalAt(x);

      if (!currentJournal.equals(journalRef)) continue;

      for (int y = 0; y < currentJournal.getNumIssues(); y++) {
        Issue issue = currentJournal.getIssueAt(y);

        if (!issue.equals(issueRef)) continue;

        for (int z = 0; z < issue.getNumArticles(); z++) {
          Article article = issue.getArticleAt(z);

          if (article.equals(a)) {
            issue.removeArticle(a);
            break outerloop;
          }
        }
      }
    }
  }

  // FUNCTIONS WHEN SELECTING OPTIONS

  /**
   * Find all articles by a given year, and return a list containing them
   * @param data - the year to find articles for. Can be either a string, or an int
   * @return an ArrayList containing Article objects
   */
  public ArrayList<Article> findArticlesByYear(String data) {
    ArrayList<Article> articlesFromYear = new ArrayList<Article>();
    int year;

    try {
      year = Integer.parseInt(data);
      articlesFromYear = findArticlesByYear(year);
    } catch(NumberFormatException e) {
      e.printStackTrace();
    }

    return articlesFromYear;
  }

  public ArrayList<Article> findArticlesByYear(int year) {
    ArrayList<Article> articlesFromYear = new ArrayList<Article>();

    for (int i = 0; i < getNumJournals(); i++) {
      Journal journal = getJournalAt(i);

      for (int j = 0; j < journal.getNumIssues(); j++) {
        Issue issue = journal.getIssueAt(j);

        if (issue.getYearPublished() == year) {

          for (int k = 0; k < issue.getNumArticles(); k++) {
            articlesFromYear.add(issue.getArticleAt(k));
          }
        }
      }
    }

    return articlesFromYear;
  }

  /**
   * Get all issues currently in the database, and return it
   * @param data - data to pass in (currently not being used, it's needed in the `method.invoke()` function - can be null)
   * @return - an ArrayList containing Issue objects
   */
  public ArrayList<Issue> getAllIssues(String data) {
    ArrayList<Issue> allIssues = new ArrayList<Issue>();

    for (int i = 0; i < getNumJournals(); i++) {
      Journal journal = getJournalAt(i);

      for (int j = 0; j < journal.getNumIssues(); j++) {
        Issue issue = journal.getIssueAt(j);

        allIssues.add(issue);
      }
    }

    return allIssues;
  }

  /**
   * Add an article to an issue
   * @param data - needs to be in the format of `indexSelected;title;author`, in order to be parsed correctly
   */
  public void addArticleToIssue(String data) {
    ArrayList<Issue> allIssues = getAllIssues("");
    String[] splitData = data.split(";");
    int index = Integer.parseInt(splitData[0]) - 1;

    // out of bounds, early return
    if (index >= (allIssues.size() - 1)) return;

    Issue foundIssue = null;
    Article newArticle = new Article(splitData[1], splitData[2], allIssues.get(index));

    if (index > allIssues.size()) return;

    for (int i = 0; i < getNumJournals(); i++) {
      Journal journal = getJournalAt(i);

      for (int j = 0; j < journal.getNumIssues(); j++) {
        Issue issue = journal.getIssueAt(j);

        if (issue == allIssues.get(index)) {
          foundIssue = issue;
          break;
        }
      }

      if (foundIssue != null) {
        break;
      }
    }


    if (foundIssue != null) {
      foundIssue.addArticle(newArticle);
    }
  }

  /**
   * Get the most published author in the database
   * @param data - currently not being used (used in the `method.invoke()` function)
   * @return - a string indicating who the most published author is
   * 
   * NOTE: `authorCount` currently isn't used - could be extended in the future to make use of the information
   */
  public String getMostPublishedAuthor(String data) {
    HashMap<String, MutableInt> authorCount = new HashMap<String, MutableInt>();
    int highestCount = 0;
    String mostPublishedAuthor = "";

    for (int i = 0; i < getNumJournals(); i++) {
      Journal journal = getJournalAt(i);

      for (int j = 0; j < journal.getNumIssues(); j++) {
        Issue issue = journal.getIssueAt(j);


          for (int k = 0; k < issue.getNumArticles(); k++) {
            Article a = issue.getArticleAt(k);
            String author = a.getAuthor();

            MutableInt count = authorCount.get(author);

            // check if key has been created
            if (count == null) {
              authorCount.put(author, new MutableInt());
            } else {
              count.increment();
            }

            MutableInt newCount = authorCount.get(author);
            int currentCount = newCount.getValue();

            if (currentCount > highestCount) {
              highestCount = currentCount;
              mostPublishedAuthor = author;
            }
          }
        
      }
    }

    // for debugging
  //  authorCount.forEach((k, v) -> System.out.println(k + ": " + v));

    return "The most published author is " + mostPublishedAuthor + ".";
  }

  /**
   * Start the BibliographyUI sequence
   */
  public String start() {
    String text = "Welcome to the Bibliography Database!";
    return text;
  }

  /**
   * End the Bibliography UI sequence
   */
  public String end() {
    String text = "Bye!";
    return text;
  }

  /**
   * Initialize options
   * An `Option` can take in a string to show, and/or a method to execute after the option has been selected, and the string shown, and/or another string after the method call that will show after the method is run
   */
  public Options initializeOptions() {
    Options options = new Options("You may perform the following operations:", "Please enter your choice:");

    Option option1 = new Option("Find articles from a given year");
    Method method1 = addMethodCall("findArticlesByYear");
    option1.addFollowUpQuestion(new Option("What year are you interested in?", method1, "\nHere are the articles from %s:"));
    options.addOption(option1);

    Method method2 = addMethodCall("getAllIssues");
    Method method3 = addMethodCall("addArticleToIssue");

    Option option2 = new Option("Add an article to an issue", method2, "Here are the available issues:");
    option2.addFollowUpQuestion(new Option("What issue would you like to add to?"));
    option2.addFollowUpQuestion(new Option("Please specify the article title:"));
    option2.addFollowUpQuestion(new Option("Please specify the article author:", method3));
    options.addOption(option2);

    Method method4 = addMethodCall("getMostPublishedAuthor");
    options.addOption(new Option("Find the most-published author", method4));

    options.addOption(new Option("Exit"));

    return options;
  }

  /** 
   * Check whether the option selected is within range 
   * */
  public boolean optionInRange(int index, Options options) {
    if (index > (options.getNumOptions() - 1)) {
      return false;
    }

    return true;
  }

  /**
   * Select an option
   */
  public void selectOption(int index, Options options) {
    options.getOptionAt(index);
  }

  /**
   * Add a method call, and return the method
   * @param methodName - name of the method to run
   * @return - the method (can be null)
   */
  private Method addMethodCall(String methodName) {
    Method method = null;

    try {
      method = this.getClass().getMethod(methodName, String.class);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    }

    return method;
  }
}
