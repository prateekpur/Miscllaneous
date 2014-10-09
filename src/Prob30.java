import java.util.HashSet;
import java.util.Set;

/**
 * Created by ppuri on 10/9/2014.
 */
public class Prob30 {
  static int[] powers = new int[]{0,1,32,243,1024,3125,7776,16807,32768,59049};

  public static void main(String args[])  {
    long sum = 0;
    for (int i = 2; i <= 1000000; ++i) {
      if (i == getDigitPowerSums(i))  {
        //System.out.println(i);
        sum += i;
      }
    }
    System.out.println(sum);
  }

  private static int getDigitPowerSums(int num) {
    int len = 0;
    while (num > 0) {
      int lastDigit = num%10;
      len += powers[lastDigit];
      num /= 10;
    }
    return len;
  }
}
