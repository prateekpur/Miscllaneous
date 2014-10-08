import java.io.*;
import java.util.*;

import static java.util.Collections.*;

/**
 * Created by Prateek on 10/7/2014.
 */
public class Prob21 {
  public static void main(String args[])  {
    File file = new File("C:\\prateek\\work\\Miscllaneous\\src\\p022_names.txt");
    BufferedReader bw;
    List<String> li = new ArrayList<>();
    try (FileReader fw = new FileReader(file.getAbsoluteFile())) {
      bw = new BufferedReader(fw);
      String str = bw.readLine();
      while(str != null)  {
        str = str.replace("\"", "");
        String s[] = str.split(",");
        for (String s1 : s) {
          li.add(s1);
        }
        str = bw.readLine();
      }
      bw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    sort(li);
    long sum = 0l;
    for (int i = 0; i < li.size(); ++i) {
      int tmp = (i+1)*getScore(li.get(i));
      sum += (i+1)*getScore(li.get(i));
    }
  }

  // upper case alphabets ascii start with 65 A=65 and Z=90
  public static int getScore(String word) {
    int score = 0;
    for (char c : word.toCharArray()) {
      score += c - 64;
    }
    return score;
  }
  //871198282
}
