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
    rotateNumber(1234);
  }

  private static List<Integer> getAllRotations(int num) {
    List<Integer> li = new ArrayList<>();
    for (int i = 1; i < getLength(num); ++i)  {

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
      if (digit == 0 || digit == 2 || digit == 4 || digit == 6 || digit == 8 || digit == 5) {
        return 0;
      }
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
