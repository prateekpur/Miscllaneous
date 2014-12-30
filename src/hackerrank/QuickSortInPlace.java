package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prateek on 12/29/2014.
 */
public class QuickSortInPlace {
  public static void main(String args[])  {
    int len;
    int nums[];
    String input = "";
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      len = Integer.parseInt(br.readLine());
      input = br.readLine();
    }catch(IOException io){
      io.printStackTrace();
    }
    String numbers[] = input.split(" ");
    nums = new int[numbers.length];
    for(int i = 0; i < numbers.length; ++i) {
      nums[i] = Integer.parseInt(numbers[i]);
    }
    sort(nums,0,nums.length-1);
  }

  // return false if no swaps were done
  public static void sort(int nums[], int start, int end) {
    if(start == end) {
      return;
    }
    int pivot = nums[end];
    int boundaryPos = start;
    for (int i = start; i < end; ++i) {
      if (nums[i] < pivot)  {
        int swap = nums[boundaryPos];
        nums[boundaryPos] = nums[i];
        nums[i] = swap;
        ++boundaryPos;
      }
    }
    nums[end] = nums[boundaryPos];
    nums[boundaryPos] = pivot;
    StringBuilder bld = new StringBuilder();
    for ( int i : nums) {
      bld.append(i + " ");
    }
    System.out.println(bld.toString());
    if ( start != boundaryPos)  {
      sort(nums, start, boundaryPos - 1);
    }
    if (boundaryPos != end) {
      sort(nums, boundaryPos+1, end);
    }
  }
}
