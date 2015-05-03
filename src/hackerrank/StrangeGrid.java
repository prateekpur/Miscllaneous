package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prateek on 5/2/2015.
 */
public class StrangeGrid {
  public static void main(String args[]) throws IOException {
    long odd[] = {0,2,4,6,8};
    long even[] = {1,3,5,7,9};
    int row, col;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s[] = br.readLine().split(" ");
    row = Integer.parseInt(s[0]);
    col = Integer.parseInt(s[1]);
    long cnt = 0;
    cnt += 10l * (((int)row - 1) / 2);
    if (row % 2 == 0) {
      cnt += even[col - 1];
    } else  {
      cnt += odd[col - 1];
    }
    System.out.println(cnt);
  }
}