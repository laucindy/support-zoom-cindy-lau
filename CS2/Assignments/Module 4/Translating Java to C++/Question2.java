// original Java code, translate to C++
public class Question2
{
  public static float getAverageScore(int[] scoreArray)
  {
    float total = 0;
    for (int i=0; i < scoreArray.length; i++)
    {
      total += scoreArray[i];
    }
    return total / scoreArray.length;
  }
 
  public static void main(String[] args)
  {
    int[] scores = new int[10];
 
    for (int i=0; i < scores.length; i +=2 )
    {
      scores[i] = i;
    }
 
    System.out.println("Average score: " + getAverageScore(scores));
  }
}