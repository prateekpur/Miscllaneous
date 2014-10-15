import java.io.*;
import java.util.*;

/**
 * Created by Prateek on 9/22/2014.
 */
public class Utils {
  public static Set<Integer> primes = new HashSet<Integer>();
  public static BitSet primes_bitset = new BitSet(100000000);

  public static void main(String args[]) throws IOException {
    getPrimes();
  }

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

  public static void getPrimes() throws IOException {
    int max = 100000000;
    boolean nums[] = new boolean[max];
    System.out.println(System.currentTimeMillis());
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
    System.out.println(System.currentTimeMillis());
    System.out.println();
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//        new FileOutputStream("C:\\\\Prateek\\\\Project_Euler\\\\Miscllaneous\\\\src\\\\prime_numbers_1"), "utf-8"));
//    for (int i = 1; i < nums.length; ++i)   {
//      if (!nums[i])    {
//        //bw.write(Integer.toString(i) + "\n");
//        primes.add(i);
//      }
//    }

        //"C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers_1");

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

  // get digits in the number
  public static List<Integer> getDigits(int num)  {
    int tensplace[] = new int[] {1,10,100,1000,10000,100000,1000000,10000000};
    List<Integer> li = new ArrayList<>();
    int numLength = getLength(num);
    while (num > 0) {
      numLength = getLength(num);
      li.add(num/tensplace[numLength - 1]);
      num %= tensplace[numLength - 1];
    }
    return li;
  }

}