import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ppuri on 9/24/2014.
 */
public class ComparePrimes {
  public static void main(String args[])  {
    File file = new File("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\Primes_6_million");
      try {
        FileReader fw = new FileReader(file.getAbsoluteFile());
        BufferedReader bw = new BufferedReader(fw);
        Set<Integer> primes_Golden = new HashSet<Integer>(300000);
        String str = bw.readLine();
        while(str != null)  {
          String s[] = str.split(" ");
          for (String s1 : s) {
            if (!s1.isEmpty())  {
              primes_Golden.add(Integer.parseInt(s1));
            }
          }
          str = bw.readLine();
        }
        bw.close();
        file = new File("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers_1");
        long cnt = 0;
        fw = new FileReader(file.getAbsoluteFile());
        bw = new BufferedReader(fw);
        str = bw.readLine();
        while(str!= null) {
          String s[] = str.split(",");
          for (String s1 : s) {
            if (!primes_Golden.remove(Integer.parseInt(s1)))  {
              System.out.println("Missing : "+s1);
            }
            cnt++;
          }
          str = bw.readLine();
        }
        boolean empty = primes_Golden.isEmpty();
        if (!empty) {
          System.out.println("Golden primes missing");
        }
        System.out.println(cnt);
        bw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

  }
}
