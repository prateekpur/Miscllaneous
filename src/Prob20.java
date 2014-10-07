import java.math.BigInteger;

/**
 * Created by ppuri on 10/7/2014.
 */
public class Prob20 {
  public static void main(String args[])  {
    BigInteger b = new BigInteger("100");
    for (int i = 99; i >1; --i) {
      String s = Integer.toString(i);
      b = b.multiply(new BigInteger(s));
    }
    BigInteger sum = new BigInteger("0");
    String s = b.toString();
    for (char ch : s.toCharArray()) {
      switch (ch) {
        case '0' : {
          sum = sum.add(new BigInteger("0"));
          break;
        }
        case '1' : {
          sum = sum.add(new BigInteger("1"));
          break;
        }
        case '2' : {
          sum = sum.add(new BigInteger("2"));
          break;
        }
        case '3' : {
          sum = sum.add(new BigInteger("3"));
          break;
        }
        case '4' : {
          sum = sum.add(new BigInteger("4"));
          break;
        }
        case '5' : {
          sum = sum.add(new BigInteger("5"));
          break;
        }
        case '6' : {
          sum = sum.add(new BigInteger("6"));
          break;
        }
        case '7' : {
          sum = sum.add(new BigInteger("7"));
          break;
        }
        case '8' : {
          sum = sum.add(new BigInteger("8"));
          break;
        }
        case '9' : {
          sum = sum.add(new BigInteger("9"));
          break;
        }
      }
    }
  }
}
