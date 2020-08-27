public class Tape
{
  public static void main(String[] args) {
    ScotchTape[] tapes = new ScotchTape[] { 
      new ScotchTape("clear", 3, 22), 
      new ScotchTape("green", 1, 15), 
      new ScotchTape("blue", 2, 19)
    };

    printTapeArray(tapes);

    stickTape(tapes[0], 0.5f);
    stickTape(tapes[1], 0.3f);
    stickTape(tapes[2], 0.9f);

    System.out.println("\n");
    printTapeArray(tapes);
  }

  public static void printTapeArray(ScotchTape[] tapeArray) {
    for (int i = 0; i < tapeArray.length; i++) {
      System.out.println(tapeArray[i].colour + " (" + tapeArray[i].length + " cm, " + tapeArray[i].weight + " oz)");
    }
  }

  public static void stickTape(ScotchTape tape, float percentToUse) {
    tape.weight -= (int) (tape.weight * percentToUse);
    tape.length -= (int) (tape.length * percentToUse);
  }
}