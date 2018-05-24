import java.util.*;

/**
 * Created by Prateek on 5/22/2018.
 */
public class Prob75 {
  static BitSet allprimes = Utils.getPrimesBitset(1500000);
  public static void main(String args[])  {
    long start = System.currentTimeMillis();
    Map<Integer, Integer> totalLength = new HashMap<>();
    int limit = 1500000;
    long m , n;
    for (m = 2; m < Math.sqrt(limit); ++m)  {
      for (n = 1; n < m; ++n) {
        if (m%2 != 0 && n%2 != 0) {
          continue;
        }
        if (!isCoPrime(m, n)) {
          continue;
        }
        int k = 1;
        long a = m*m + n*n;
        long b = m*m - n*n;
        long c = 2*m*n;
        long len = a+b+c;
        if (len > limit)  {
          continue;
        }
        if (totalLength.containsKey((int)len))  {
          totalLength.put((int)len, 2);
        } else  {
          totalLength.put((int)len, 1);
        }
        //totalLength.put((int)len, 1);
/*
        while ( len*k <= limit)  {
          //System.out.println(a + ":" + b + ":" + c + ":" + k + ":" + len);
          //totalLength.putIfAbsent((int)len, 1);
          int length = (int)len * k;
          if (!totalLength.containsKey(length))  {
            totalLength.put(length, 1);
          } else  {
            totalLength.put(length, 2);
          }
          ++k;
        }
*/
      }
    }
    int count = 0;
    short allNums[] = new short[1500001];

    for (Map.Entry<Integer, Integer> entry : totalLength.entrySet()) {
      for (int i = 1; i <= limit / entry.getKey(); ++i)  {
        allNums[i * entry.getKey()]+= entry.getValue();
      }
    }
    count = 0;
    for (short i : allNums) {
      if (i == 1) {
        count++;
      }
    }
    System.out.println("Count : " + count);
    System.out.println(System.currentTimeMillis() - start);
  }

  public static boolean isCoPrime(long m, long n)  {
    if (m%2 == 0 && n%2 == 0) {
      return false;
    }
    for (int i = 3; i < m; i += 2) {
      if (!allprimes.get(i))  {
        if (m % i == 0 && n%i == 0) {
          return false;
        }
      }
    }
    return true;
  }
}
