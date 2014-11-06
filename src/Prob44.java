import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Prateek on 11/6/2014.
 */
public class Prob44 {
  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    long maxdiff = Integer.MAX_VALUE;
    System.out.println(maxdiff);
    Set<Long> map = new HashSet<>();
    //generate list of pentagon numbers
    for (int i = 1; i < 35570; ++i) {
      long j = i*(3*i-1)/2;
      map.add(j);
    }
    for (long i : map) {
      Iterator<Long> iter = map.iterator();
      while(iter.hasNext()) {
        long j = iter.next();
        if (i == j) {
          continue;
        }
        long diff = 0;
        if (i > j)  {
          diff = i - j;
        } else  {
          diff = j - i;
        }
        if (map.contains(i+j) && map.contains(diff))  {
          if(maxdiff > diff)  {
            maxdiff = diff;
          }
        }
      }
    }
    System.out.println(maxdiff);
    System.out.println(System.currentTimeMillis());
  }

}
