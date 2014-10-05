import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prateek on 10/4/2014.
 */
public class Prob13 {
  public static void main(String args[]) throws IOException {
    File f= new File("C:\\prateek\\work\\Miscllaneous\\src\\input_str");
    BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
    List<String> li = new ArrayList<String>();
    String s = br.readLine();
    while(s != null)  {
      li.add(s);
      s = br.readLine();
    }
    BigInteger b = new BigInteger("0");
    for (String str : li) {
      b = b.add(new BigInteger(str));
    }
    System.out.println(b);
  }
}



