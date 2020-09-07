package data;

import java.util.ArrayList;

public class Options {
  private String introText;
  private String outroText;
  private ArrayList<Option> options = new ArrayList<Option>();

  public Options(String introText, String outroText) {
    this.introText = introText;
    this.outroText = outroText;
  }

  public String getIntroText() { return introText; }
  public String getOutroText() { return outroText; }

  public void addOption(String text) {
    Option o = new Option(text);
    addOption(o);
  }

  public void addOption(Option o) {
    options.add(o);
  }

  public Option getOptionAt(int index) {
    return options.get(index);
  }

  public int getNumOptions() {
    return options.size();
  }
}
