import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ppuri on 9/23/2014.
 */
public class Prob10 {
  public static void main(String args[])  {
    final int upperLimit = 2000000;
    boolean nums[] = new boolean[upperLimit+1];
    System.out.println("---" + System.currentTimeMillis());
    for (int i = 2; i < upperLimit; ++i)  {
      if (i%(upperLimit/25) == 0)  {
        System.out.println(i);
      }
      if (!nums[i]) {
        //System.out.println("Prime : " + i);
        for (int j = 2; j <= upperLimit/i; ++j) {
          if (!nums[j*i]) {
            nums[j*i] = true;
          }
        }
      }
    }
    System.out.println();

    File file = new File("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers2");

    // if file doesnt exists, then create it
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      int cnt = 0, lineCnt = 0;
      for (int i = 1; i < nums.length; ++i)   {
        if (!nums[i])    {
          cnt += i;
          bw.write(i + ",");
        }
      }
      bw.close();
      System.out.println("Count : " + cnt);
    } catch (IOException e) {
      e.printStackTrace();
    }


    System.out.println("Done :");

    System.out.println("---" + System.currentTimeMillis());

  }
}
