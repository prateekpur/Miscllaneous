import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Prateek on 11/6/2014.
 */
public class Prob56 {
  public static void main(String args[])  {
    long start = System.currentTimeMillis();
    int maxDigs = 0;
    for (int i = 0; i < 100; ++i) {
      System.out.println(" :::::: "+i);
      BigInteger b = new BigInteger(Integer.toString(i));
      for ( int j = 1; j < 100; ++j)  {
        BigInteger b1 = b.pow(j);
        int s1 = sum(b1.toString());
        if (maxDigs < s1)  {
          maxDigs = s1;
        }
      }
    }
    System.out.println(maxDigs);
    System.out.println(System.currentTimeMillis() - start);
  }

  public static int sum(String s)  {
    int sum = 0;
    char ch[] = s.toCharArray();
    for (char c : ch) {
      sum = sum + Integer.parseInt(Character.toString(c));
    }
    return sum;
  }
}
