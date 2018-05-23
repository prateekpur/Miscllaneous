import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Prateek on 2/3/2016.
 */
public class Prob67 {
  public static void main(String args[])  {
    long arr[][] = new long[100][];
    try{
      BufferedReader br = new BufferedReader(new FileReader("/Users/neha/IdeaProjects/euler/Miscllaneous/src/p067_triangle.txt"));
      String line = br.readLine();
      int i = 0;
      while (line != null) {
        String st[] = line.split(" ");
        arr[i] = new long[st.length];
        for (int j = 0; j < st.length; ++j) {
          arr[i][j] = Long.parseLong(st[j]);
        }
        line = br.readLine();
        ++i;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i = 98; i >= 0; --i)  {
      for (int j = 0; j < arr[i].length; ++j)  {
        arr[i][j] = arr[i][j] + Long.max(arr[i+1][j],arr[i+1][j+1]);
      }
    }
  }
}
