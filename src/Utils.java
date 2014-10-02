import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prateek on 9/22/2014.
 */
public class Utils {
  public static List<Integer> primes = new ArrayList<Integer>();

  public static void loadPrimes(String fileName) {
    try{
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line = br.readLine();
      while (line != null) {
        primes.add(Integer.parseInt(line));
        line = br.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/*
Code to generate primes
    boolean nums[] = new boolean[775147];
    for (int i = 2; i < 775147; ++i)  {
      if (!nums[i]) {
        //System.out.println(i);
        for (int j = i+1; j < 775147; ++j) {
          if (!nums[j]) {
            if (j % i == 0) {
              nums[j] = true;
            }
          }
        }
      }
    }
    System.out.println(System.currentTimeMillis());
    System.out.println();
    int cnt = 0;
    for (int i = 1; i < nums.length; ++i)   {
        if (!nums[i])    {
          System.out.print(i + " ,");
          cnt++;
          if (cnt%15 == 0)    {
            System.out.println("");
          }
        }
    }

 */
