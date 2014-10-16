import java.util.*;

/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob39 {
  public static void main(String args[])  {
    // store a,b,c as string
    Set<String> abc = new HashSet<String>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int m = 1; m < 35; m++)  {
      for (int n = 1; n < 35; n++) {
        if (m == n) {
          continue;
        }
        int a = m*m + n*n;
        int b = Math.abs(m*m - n*n);
        int c = 2*m*n;
        if (a+b+c <=1000) {
          if (abc.add(addToSet(a,b,c))) {
            int i = 0;
            Integer tmp = map.get(a+b+c);
            if (tmp == null)  {
              i = 1;
            } else  {
              i = tmp.intValue()+1;
            }
            map.put(a+b+c, i);
            System.out.println("a : "+a + " b : "+b+ " c :"+c);
          }
        }
        int k = 2;
        while (2*m*n*k < 1000)  {
          a = k*(m*m + n*n);
          b = k*Math.abs(m*m - n*n);
          c = k*2*m*n;
          if (a > 1000 || b > 1000 || c > 1000) {
            break;
          }
          if (a+b+c <=1000) {
            if (abc.add(addToSet(a,b,c))) {
              int i = 0;
              Integer tmp = map.get(a+b+c);
              if (tmp == null)  {
                i = 1;
              } else  {
                i = tmp.intValue()+1;
              }
              map.put(a+b+c, i);
              System.out.println("a : "+a + " b : "+b+ " c :"+c);
            }
          }
          ++k;
        }
      }
    }
    int highVal = 0, highKey = 0;
    Iterator iter = map.entrySet().iterator();
    while(iter.hasNext()) {
      Map.Entry<Integer, Integer> en = (Map.Entry<Integer, Integer>) iter.next();
      if(en.getValue() > highVal) {
        highVal = en.getValue() ;
        highKey = en.getKey();
      }
    }
    System.out.println(highKey);
  }

  static String addToSet(int a, int b, int c) {
    String s = "";
    if (a > b && a > c) {
      if (b > c)  {
        s = a+","+b+","+c;
      } else  {
        s = a+","+c+","+b;
      }
    } else if (b > a && b > c)  {
      if (a > c)  {
        s = b+","+a+","+c;
      } else  {
        s = b+","+c+","+a;
      }
    } else  {
      if (a > b)  {
        s = c+","+a+","+b;
      } else  {
        s = c+","+b+","+a;
      }
    }
    return s;
  }
}
