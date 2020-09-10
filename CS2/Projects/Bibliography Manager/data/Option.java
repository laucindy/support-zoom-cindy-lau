package data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Option {
  private String text;
  private String secondaryText;
  private Method method;
  private ArrayList<Option> followUpQuestions = new ArrayList<Option>();

  public Option(String text) {
    this(text, null, null);
  }

  public Option(String text, Method method) {
    this(text, method, null);
  }

  public Option(String text, Method method, String secondaryText) {
    this.text = text;
    this.method = method;
    this.secondaryText = secondaryText;
  }

  public String getText() { return text; }
  public String getSecondaryText() { return secondaryText; }
  public String getMethodName() { return (method == null) ? null : method.getName(); }

  public void addFollowUpQuestion(Option q) {
    followUpQuestions.add(q);
  }

  public Option getFollowUpQuestionAt(int index) {
    return followUpQuestions.get(index);
  }

  public int getNumFollowUpQuestions() {
    return followUpQuestions.size();
  }

  /**
   * Execute a function
   * @param <T> - a generic type, as this function can currently return either an ArrayList, a String, or null
   * @param db - an instance of the BibliographyDatabase class
   * @param data - the data to pass in to a function. Can be null
   * @return
   */
  public <T> T executeFunction(BibliographyDatabase db, String data) {
    T returnedContents = null;

    try {
      returnedContents = (T) method.invoke(db, data);
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return (T) returnedContents;
  }
}