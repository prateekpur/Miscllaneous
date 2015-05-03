package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prateek on 12/29/2014.
 */
public class ContiguousSum {
  public static void main(String args[])  {
    int numtests = 0;
    int len;
    int max[];
    String input = "";
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      numtests = Integer.parseInt(br.readLine().trim());
      for (int i = 0; i < numtests; ++i)  {
        len = Integer.parseInt(br.readLine().trim());
        input = br.readLine();
        max = getMax(input);
        System.out.println(max[0] + " " + max[1]);
      }
    }catch(IOException io){
      io.printStackTrace();
    }
  }

  public static int[] getMax(String input)  {
    int max[] = new int[2];
    int pos = 0;
    String numbers[] = input.split(" ");
    int nums[] = new int[numbers.length];
    for (int i = 0; i < numbers.length; ++i)  {
      nums[i] = Integer.parseInt(numbers[i].trim());
    }
    int low = lowestIfAllNegative(nums);
    if(low != 0)  {
      max[0] = low;
      max[1] = low;
      return max;
    }
    final int startingCurVal = 0;
    int curVal = 0;
    int curStartIndex = 0;
    int bestVal = startingCurVal, bestStart = -1, bestEnd = -1;
    for (int i = 0; i < nums.length; ++i) {
      if(i == 0) {
        curStartIndex = i;
      }
      curVal = curVal + nums[i];
      if(curVal >= startingCurVal)  {
        curStartIndex = i;
      } else  {
        curVal = 0;
      }
      if (curVal >= bestVal) {
        bestVal = curVal;
        bestStart = curStartIndex;
        bestEnd = i;
      }
      if(nums[i] > 0) {
        pos = pos + nums[i];
      }
    }
    max[0] = bestVal;
    max[1] = pos;
    return max;
  }

  /**
   *
   * @param nums
   * @return 0 if array has some +ve number, otherwise return lowest element
   *
   */
  public static int lowestIfAllNegative(int nums[])  {
    int low = nums[0];
    if (low > 0)  {
      return 0;
    }
    for (int i : nums)  {
      if(i > 0) {
        return 0;
      }
      if (i > low)  {
        low = i;
      }
    }
    return low;
  }
}
