import java.util.HashMap;
import java.util.Map;

/**
 * Created by ppuri on 10/8/2014.
 */
public class Prob26 {
  public static void main(String args[])  {
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    int maxLength = 0, maxNum = 3;
    for(int i : Utils.primes) {
      if (i > 1000) {
        System.out.println(maxLength);
        return;
      }
      if (i == 2) {
        continue;
      }
      for (int j = i; j <1000; j = j+i) {
        int tmp = getCycleLength(j);
        if (tmp > maxLength)  {
          maxLength = tmp;
          maxNum = j;
        }
      }
    }

  }

  private static int getCycleLength(int n) {
    Map<Integer,Integer> stateToIter = new HashMap<Integer,Integer>();
    int state = 1;
    int iter = 0;
    while (!stateToIter.containsKey(state)) {
      stateToIter.put(state, iter);
      state = state * 10 % n;
      iter++;
    }
    return iter - stateToIter.get(state);
  }

  public static int cycleLength(String decimal) {
    int len = 0;
    return len;
  }
}
