import java.io.*;
import java.util.*;

/**
 * Created by Prateek on 9/22/2014.
 */
public class Utils {
  public static Set<Long> primes = new HashSet<Long>();
  public static BitSet primes_bitset = new BitSet(100000000);
  public static List<Integer> listPrimes = new ArrayList<>();

  public static void main(String args[]) throws IOException {
    getPrimes(100000000);
  }

  public static void loadPrimes(String fileName) {
    try{
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line = br.readLine();
      while (line != null) {
        primes.add(Long.parseLong(line));
        line = br.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Set<Integer> getSquares(int num) {
    Set<Integer> li = new HashSet<>();
    for (int i = 1; i < num; ++i )  {
      li.add(2*i*i);
    }
    return li;
  }

  public static void getPrimes(int max) {
    //boolean nums[] = new boolean[max];
    //setting 0 and 1 to be not prime
    primes_bitset.set(0);
    primes_bitset.set(1);
    for (int i = 2; i < max; ++i)  {
      if(!primes_bitset.get(i)){
        for (int j = i*2; j < max; j = j+i) {
          if (!primes_bitset.get(j)) {
            if (j % i == 0) {
              primes_bitset.flip(j);
            }
          }
        }
      }
    }
    //System.out.println(System.currentTimeMillis());
    for (int i = 1; i < max; ++i) {
      if (!primes_bitset.get(i))  {
        listPrimes.add(i);
      }
    }
  }

  // finds length upto 10 digits.
  public static int getLength(int num) {
    if (num > 100000000) {
      return 9;
    } else if (num >= 10000000) {
      return 8;
    } else if (num >= 1000000) {
      return 7;
    } else if (num >= 100000) {
      return 6;
    } else if (num >= 10000) {
      return 5;
    } else if (num >= 1000) {
      return 4;
    } else if (num >= 100) {
      return 3;
    } else if (num >= 10) {
      return 2;
    } else  {
      return 1;
    }
  }
  // finds length upto 10 digits.
  public static int getLength(long num) {
    if (num >= 1000000000) {
      return 10;
    } else  if (num >= 100000000) {
      return 9;
    } else if (num >= 10000000) {
      return 8;
    } else if (num >= 1000000) {
      return 7;
    } else if (num >= 100000) {
      return 6;
    } else if (num >= 10000) {
      return 5;
    } else if (num >= 1000) {
      return 4;
    } else if (num >= 100) {
      return 3;
    } else if (num >= 10) {
      return 2;
    } else  {
      return 1;
    }
  }

  // get digits in the number. does not return 0;
  public static List<Integer> getDigits(int num)  {
    int tensplace[] = new int[] {1,10,100,1000,10000,100000,1000000,10000000};
    List<Integer> li = new ArrayList<>();
    int numLength = getLength(num);
    while (numLength > 1) {
      numLength = getLength(num);
      li.add(num/tensplace[numLength - 1]);
      num %= tensplace[numLength - 1];
      int newnumLength = getLength(num);
      if (newnumLength + 1 < numLength) {
        for (int i = 0; i < numLength - (newnumLength + 1); ++i)  {
          li.add(0);
        }
      }
    }
    return li;
  }

  public static List<Integer> getDigits(long num) {
    String s = "";
    s = s + num;
    List<Integer> li = new ArrayList<>();
    char ch[] = s.toCharArray();
    for (char c : ch) {
      switch (c) {
        case '0':
          li.add(0);
          break;
        case '1':
          li.add(1);
          break;
        case '2':
          li.add(2);
          break;
        case '3':
          li.add(3);
          break;
        case '4':
          li.add(4);
          break;
        case '5':
          li.add(5);
          break;
        case '6':
          li.add(6);
          break;
        case '7':
          li.add(7);
          break;
        case '8':
          li.add(8);
          break;
        case '9':
          li.add(9);
          break;
      }
    }
    return li;
  }


  public static boolean getNextPerm(int digits[]) {
    //check if number is already descending
    boolean desc = true;
    for (int i = 0; i < digits.length - 2; ++i) {
      if (digits[i] < digits[i+1])  {
        desc = false;
        break;
      }
    }
    if (desc) {
      return false;
    }
    // find the digit less than next digit
    int lessPostition = -1;
    for (int i = digits.length - 2; i >=0; i--) {
      if (digits[i] < digits[i+1])  {
        lessPostition = i;
        break;
      }
    }
    // finding lowest digit higher than the digit at lessPosition
    int highPos = lessPostition+1;
    for (int j = lessPostition+1; j < digits.length; j++)  {
      if (digits[j] < digits[highPos] && digits[j] > digits[lessPostition])  {
        highPos = j;
      }
    }
    //swap high position with low position
    int tmp = digits[lessPostition];
    digits[lessPostition] = digits[highPos];
    digits[highPos] = tmp;
    // sort numbers between highPos and lessPosition
    for (int i = lessPostition+1; i <= highPos; ++i) {
      int lowestdigit = i;
      for (int j = i; j <= highPos; ++j) {
        if (digits[j] < digits[lowestdigit]) {
          lowestdigit = j;
        }
      }
      if (lowestdigit != i) {
        int tmp1 = digits[i];
        digits[i] = digits[lowestdigit];
        digits[lowestdigit] = tmp1;
      }
    }
    return true;
  }
}