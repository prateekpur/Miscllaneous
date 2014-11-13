import java.util.*;

/**
 * Created by ppuri on 11/12/2014.
 */
public class Prob49 {
  public static void main(String args[])  {
    Map<String, List<Integer>> numberDigits = new HashMap<>();
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\4digit_prime_numbers");
    for (int i : Utils.primes)  {
      String s = getSortedDigits(i);
      List<Integer> li = numberDigits.get(s);
      if (li == null) {
        li = new ArrayList<>();
      }
      li.add(i);
      numberDigits.remove(s);
      numberDigits.put(s, li);
    }
    Map<String, List<Integer>> modifiedNumberDigits = new HashMap<>();
    for (String s : numberDigits.keySet())  {
      //if string hsa 3 numbers in value then add it to modifiedNumberDigits
      if (numberDigits.get(s).size() >= 3)  {
        modifiedNumberDigits.put(s, numberDigits.get(s));
      }
    }
    for (List<Integer> li : modifiedNumberDigits.values())  {
      Collections.sort(li);
      Map<Integer, Set<Integer>> map = new HashMap<>();
      for (int i = 0; i < li.size(); ++i) {
        for (int j = i+1; j < li.size(); ++j) {
          int diff = li.get(i) - li.get(j);
          Set<Integer> s = map.get(diff);
          if (s == null)  {
            s = new HashSet<>();
          } else  {
            if (s.contains(li.get(i)))  {
              String s1 = "";
              for (int k : s) {
                s1 += k;
                s1 += ",";
              }
              s1 += li.get(j);
              System.out.println(s1);
            }
          }
          s.add(li.get(i));
          s.add(li.get(j));
          map.put(diff, s);
        }
      }
    }
  }


  static String getSortedDigits(int num)  {
    String s = new String("");
    int digits[] = new int[4];
    digits[3] = num%10;
    num = num/10;
    digits[2] = num%10;
    num = num/10;
    digits[1] = num%10;
    num = num/10;
    digits[0] = num%10;
    //sorting digits array
    for (int i = 0; i < 3; ++i) {
      for (int j = i+1; j < 4; ++j) {
        if (digits[j] > digits[i])  {
          int tmp = digits[j];
          digits[j] = digits[i];
          digits[i] = tmp;
        }
      }
    }
    s = digits[0] + "" + digits[1] + "" + digits[2] + "" + digits[3];
    return s;
  }
}
