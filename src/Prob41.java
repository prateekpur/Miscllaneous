import java.io.IOException;
import java.util.List;

/**
 * Created by ppuri on 10/16/2014.
 */
public class Prob41 {
  public static void main (String args[]) throws IOException {
    System.out.println(System.currentTimeMillis());
    Utils.getPrimes(100000000);
    for (int i : Utils.listPrimes)  {
      if (isPandigital(i))  {
        System.out.println(i);
      }
    }
    System.out.println(System.currentTimeMillis());
  }

  private static boolean isPandigital(int num)  {
    int len = Utils.getLength(num);
    List<Integer> digs = Utils.getDigits(num);
    boolean digits[] = new boolean[len];
    for (int i = 0; i < len; ++i) {
      digits[i] = false;
    }
    for (int i : digs)  {
      if (i > len)  {
        return false;
      }
      digits[i-1] = true;
    }
    boolean result = true;
    for (boolean b : digits)  {
      result = result && b;
    }
    return result;
  }
}