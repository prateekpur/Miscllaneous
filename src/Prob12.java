import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ppuri on 10/2/2014.
 */
public class Prob12 {
  public static void main(String args[])  {
    File file = new File("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    try {
      FileReader fw = new FileReader(file.getAbsoluteFile());
      BufferedReader bw = new BufferedReader(fw);
      Set<Integer> primes_Golden = new HashSet<Integer>(300000);
      String str = bw.readLine();
      while (str != null) {
        String s[] = str.split(" ");
        for (String s1 : s) {
          if (!s1.isEmpty()) {
            primes_Golden.add(Integer.parseInt(s1));
          }
        }
        str = bw.readLine();
      }
      bw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
