import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * Created by Prateek on 5/23/2018.
 */
public class Prob80 {
  static BigDecimal two = new BigDecimal(2.0);
  static BigInteger five = new BigInteger("5");
  static BigInteger ten = new BigInteger("10");
  static BigInteger hundred = new BigInteger("100");

  public static void main(String args[])  {
    int sum = 0;
    int num = 1;
    long totalSum = 0;
    while (num < 100)  {
      if (isSquare(++num))  {
        continue;
      }
      String r = root(new BigInteger(Integer.toString(num)));
      char ch[] = r.substring(0, 100).toCharArray();
      sum = 0;
      for (char c : ch) {
        sum = sum + charToInt(c);
      }
      totalSum += sum;
    }
  }


  static boolean isSquare(int num)  {
    int sq = (int)Math.sqrt((double)num);
    if (num == sq*sq) {
      return true;
    }
    return false;
  }

  static int charToInt(char c)  {
    switch (c)  {
      case '0' : return 0;
      case '1' : return 1;
      case '2' : return 2;
      case '3' : return 3;
      case '4' : return 4;
      case '5' : return 5;
      case '6' : return 6;
      case '7' : return 7;
      case '8' : return 8;
      case '9' : return 9;
    }
    return -1;
  }

  static String root(BigInteger n) {
    BigInteger a = n.multiply(five);
    BigInteger b = new BigInteger("5");
    StringBuilder bld = new StringBuilder("");
    bld.append("1");
    for (int i = 0; i < 99; ++i)  {
      bld.append("0");
    }
    int cnt = 10000;
    while (cnt > 0) {
      BigInteger oldB = b;
      --cnt;
      if (a.compareTo(b) >= 0) {
        a = a.subtract(b);
        b = b.add(ten);
      } else  {
        a = a.multiply(hundred);
        b = b.divide(ten);
        b = b.multiply(hundred);
        b = b.add(five);
      }
    }
    return b.toString();
  }

  static BigDecimal sqrt(BigDecimal t) {
    BigDecimal r = t.divide(two);
    //double r = t/2;
    for ( int i = 0; i < 1000; i++ ) {
      BigDecimal tmp = t.divide(r);
      r = r.add(tmp);
      r = r.divide(two);
      //r = (r+t/r)/2;
    }
    return r;
  }
}
