package ui;

import data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliographyUI {

  private BibliographyDatabase db;

  BibliographyUI(BibliographyDatabase db) {
    this.db = db;
  }

  void run() {
    System.out.println("\n" + db.start() + "\n");
    Options options = db.initializeOptions();
    Scanner input = new Scanner(System.in);

    int selectedNumber = 0;
    int mainOptionsSize = options.getNumOptions();

    do {
      getMainMenuOptions(options);

      // wait for user input
      selectedNumber = input.nextInt();
      int optionIndex = selectedNumber - 1;

      if (!db.optionInRange(optionIndex, options)) {
        System.out.println("Sorry, that is not a valid choice\n");
        continue;
      }

      System.out.println("");

      Option selectedOption = options.getOptionAt(optionIndex);

      showSelectedOptionInfo(selectedOption, null, true);
      
      // show follow up questions (if any)
      String userData = "";
      for (int i = 0; i < selectedOption.getNumFollowUpQuestions(); i++) {
        Option followUpQuestion = selectedOption.getFollowUpQuestionAt(i);
        
        System.out.println(followUpQuestion.getText());

        input = new Scanner(System.in);
        userData += input.nextLine();

        if (selectedOption.getNumFollowUpQuestions() > 1) userData += ";";

        showSelectedOptionInfo(followUpQuestion, userData, false);
      }

    } while (selectedNumber != mainOptionsSize);

    System.out.println(db.end());

    input.close();

  //  printJournals(db);
  }

  public static void main(String[] args) {
    BibliographyDatabase db = new BibliographyDatabase(Journal.getSampleJournals());
    BibliographyUI ui = new BibliographyUI(db);

  //  ui.testRun();
    ui.run();
  }

  /**
   * Get the main menu options
   * @param options - options to show
   */
  public void getMainMenuOptions(Options options) {
    System.out.println(options.getIntroText());

      for (int i = 0; i < options.getNumOptions(); i++) {
        System.out.println((i + 1) + ") " + options.getOptionAt(i).getText());
      }

      System.out.println("\n" + options.getOutroText());
  }

  /**
   * Show information related to the selected option
   * @param selectedOption - the option selected
   * @param data (optional) - used for adjusting the text to display. Can be null
   * @param showAsOptions (optional) - whether to show any follow up options as a selectable option or not
   */
  public void showSelectedOptionInfo(Option selectedOption) {
    showSelectedOptionInfo(selectedOption, null, false);
  }

  public void showSelectedOptionInfo(Option selectedOption, String data, boolean showAsOptions) {
    if (selectedOption.getSecondaryText() != null) {
      String formattedString = String.format(selectedOption.getSecondaryText(), data);
      System.out.println(formattedString);
    }

    if (selectedOption.getMethodName() != null) {
      Object obj = selectedOption.executeFunction(db, data);

      if (obj != null) {
        String typeName = obj.getClass().getTypeName();
        determineObjType(obj, typeName, showAsOptions);
      }

      System.out.println("");
    }
  }

  /**
   * Print journals, issues and articles
   * @param db - an instance of the BibliographyDatabase class
   */
  public static void printJournals(BibliographyDatabase db) {
    for (int i = 0; i < db.getNumJournals(); i++) {
      Journal journal = db.getJournalAt(i);
      System.out.println(journal);

      for (int j = 0; j < journal.getNumIssues(); j++) {
        Issue issue = journal.getIssueAt(j);
        System.out.println("\t" + issue);

        for (int k = 0; k < issue.getNumArticles(); k++) {
          Article article = issue.getArticleAt(k);
          System.out.println("\t\t" + article);
        }
      }
      System.out.println("\n");
    }
  }

  /**
   * Determines what to cast the passed in object to, based on the typename
   * If the cast type is to an ArrayList, then each item in the list will also be displayed
   * @param obj - object returned from a `method.invoke()` call in the Option class (`executeFunction(...)`)
   * @param typeName - obj's type name, as a string
   * @param showAsOptions - if the cast type is an ArrayList, then determine whether to show these as selectable options (ie. append a number before it)
   */
  private void determineObjType(Object obj, String typeName, boolean showAsOptions) {
    if (typeName == "java.util.ArrayList") {
      ArrayList<Article> articles = (ArrayList<Article>) obj;

      // display articles
      for (int j = 0; j < articles.size(); j++) {
        if (showAsOptions) {
          System.out.println("\t" + (j + 1) + ") " + articles.get(j));
        } else {
          System.out.println("\t" + articles.get(j));
        } 
      }
      
    } else if (typeName == "java.lang.String") {
      System.out.println(obj.toString());
    }
  }

  /**
   * Test adding and removing Journals, Issues and Articles, test `equals` override and
   * test adding a list of journals to the Bibliography Database
   */
  void testRun() {
    testAddAndRemove();
    testAddListOfJournals();
  }

  /**
   * Test adding and removing Journals, Issues and Articles, and test the `equals` override
   */
  private void testAddAndRemove() {
    Journal j1 = new Journal("Journal of Medicine");
    Issue i1 = new Issue(2019, 10, 3, j1);
    Issue i2 = new Issue(2020, 2, 5, j1);
    Article a1 = new Article("All About Medicine", "Jane Doe", i1);

    // initialize variables for a duplicate copy of j1
    Journal j2 = new Journal("Journal of Medicine");
    Issue i3 = new Issue(2019, 10, 3, j2);
    Issue i4 = new Issue(2020, 2, 5, j2);
    Article a2 = new Article("All About Medicine", "Jane Doe", i3);

    db.addJournal(j1);

    db.addIssue(i1);
    db.addIssue(i2);

    db.addArticle(a1);

    // create a duplicate of j1, with all its references. Don't add to the database
    i3.addArticle(a2);
    j2.addIssue(i3);
    j2.addIssue(i4);
    
    System.out.println("j1.equals(j2): " + j1.equals(j2));    // should return true

    // test remove, using the duplicate variables. Test that the original journal (j1) in the database is the one
    // being removed. Since these are a direct copy, they will need to be tested one at a time

  //  db.removeArticle(a2);
  //  db.removeIssue(i3);
    db.removeJournal(j2);

    printJournals(db);
  }

  /**
   * Test adding a newly created list of journals to the existing list of journals (in BibliographyDatabase)
   */
  private void testAddListOfJournals() {
    ArrayList<Journal> list = new ArrayList<Journal>();
    Journal j1 = new Journal("Journal of Medicine");
    Journal j2 = new Journal("Journal of Biology");

    Issue i1 = new Issue(2019, 10, 3, j1);
    Issue i2 = new Issue(2020, 2, 5, j1);
    Issue i3 = new Issue(2019, 4, 6, j2);
    Issue i4 = new Issue(2020, 5, 8, j2);

    Article a1 = new Article("All About Medicine", "Jane Doe", i1);
    Article a2 = new Article("All About Biology", "Jane Doe", i3);

    list.add(j1);
    list.add(j2);

    db.addListOfJournals(list);

    db.addIssue(i1);
    db.addIssue(i2);
    db.addIssue(i3);
    db.addIssue(i4);

    db.addArticle(a1);
    db.addArticle(a2);

    printJournals(db);
  }
}
