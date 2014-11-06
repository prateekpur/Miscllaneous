import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ppuri on 10/16/2014.
 */
public class Prob42 {
  static List<String> words = new ArrayList<>();

  public static void main(String args[])  {
    Set<Integer> triangleNumbers = new HashSet<>();
    score("REPRESENTATION");
    loadWords("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\p042_words.txt");
    int maxScore = 0;
    Map<String, Integer> wordScores = new HashMap<>();
    for (String s : words)  {
      int wscore = score(s);
      if (wscore > maxScore) {
        maxScore = wscore;
      }
      wordScores.put(s, wscore);
    }
    int num = 1;
    for (int j = 1; num < maxScore; ++j)  {
      num = j*(j+1)/2;
      if (num<maxScore) {
        triangleNumbers.add(num);
      }
    }
    int countTriangles = 0;
    List<Integer> li = new ArrayList<>();
    li.addAll(wordScores.values());
    li.retainAll(triangleNumbers);
    System.out.println(li.size());
  }

  public static void loadWords(String fileName) {
    try{
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line = br.readLine();
      line = line.replace("\"", "");
      while (line != null) {
        String str[] = line.split(",");
        for (String s : str)  {
          words.add(s);
        }
        line = br.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int score(String s)  {
    // ascii value of A = 34
    int score = 0;
    for (char c : s.toCharArray())  {
      score += c - 64;
    }
    return score;
  }
}
