import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Prateek on 10/14/2014.
 */
public class Prob35 {
  // multiplication factors for digits places
  final static int[] multiplyFactors = new int[]{1,10,100,1000,10000,100000};
  public static void main(String args[])  {
    int cnt = 0;
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    for (int i : Utils.primes)  {
      List<Integer> li = getAllRotations(i);
      int len = getLength(i);
      boolean equalLength = true;
      for (int j : li)  {
        if (getLength(j) != len)  {
          equalLength = false;
        }
      }
      if(equalLength && Utils.primes.containsAll(li))  {
        ++cnt;
        System.out.println(i);
      }
    }
    System.out.println(cnt);
  }

  private static List<Integer> getAllRotations(int num) {
    List<Integer> li = new ArrayList<>();
    li.add(num);
    int newnum = num;
    for (int i = 1; i < getLength(num); ++i)  {
      newnum = rotateNumber(newnum);
      li.add(newnum);
    }
    return li;
  }

  private static int getLength(int num) {
    if (num >= 100000)  {
      return 6;
    } else if (num >= 10000)  {
      return 5;
    } else if (num >= 1000) {
      return 4;
    } else if (num >= 100)  {
      return 3;
    } else if (num >= 10)  {
      return 2;
    } else  {
      return 1;
    }
  }

  private static int rotateNumber(int num)  {
    int digitsPlace = 0;
    int newnum = 0;
    while(num > 0)  {
      int digit = num%10;
      num = num/10;
      if (num == 0) {
        newnum += digit*multiplyFactors[0];
      } else  {
        newnum += digit*multiplyFactors[++digitsPlace];
      }
    }
    return newnum ;
  }
}
