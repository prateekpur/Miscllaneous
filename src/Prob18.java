/**
 * Created by Prateek on 2/3/2016.
 */
public class Prob18 {
  public static void main(String args[])  {
    long arr[][] = new long[15][];
    arr[14] = new long[]{04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23};
    arr[13] = new long[]{63,66,04,68,89,53,67,30,73,16,69,87,40,31};
    arr[12] = new long[]{91,71,52,38,17,14,91,43,58,50,27,29,48};
    arr[11] = new long[]{70,11,33,28,77,73,17,78,39,68,17,57};
    arr[10] = new long[]{53,71,44,65,25,43,91,52,97,51,14};
    arr[9] = new long[]{41,48,72,33,47,32,37,16,94,29};
    arr[8] = new long[]{41,41,26,56,83,40,80,70,33};
    arr[7] = new long[]{99,65,04,28,06,16,70,92};
    arr[6] = new long[]{88,02,77,73,07,63,67};
    arr[5] = new long[]{19,01,23,75,03,34};
    arr[4] = new long[]{20,04,82,47,65};
    arr[3] = new long[]{18,35,87,10};
    arr[2] = new long[]{17,47,82};
    arr[1] = new long[]{95,64};
    arr[0] = new long[]{75};
    for (int i = 13; i >= 0; --i)  {
      for (int j = 0; j < arr[i].length; ++j)  {
        arr[i][j] = arr[i][j] + Long.max(arr[i+1][j],arr[i+1][j+1]);
      }
    }
  }
}
