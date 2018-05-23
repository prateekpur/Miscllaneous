import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob60 {
  public static void main(String args[])  {
    final int range = Integer.MAX_VALUE / 1000 ;
    final int primeRange = 1000;
    //BitSet primes = Utils.getPrimesBitset(primeRange);
    BitSet allprimes = Utils.getPrimesBitset(range);
    // map will have prime numbers and List of other primes that can form pair
    long start = System.currentTimeMillis();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < primeRange; ++i) {
      if (!allprimes.get(i)) {
        map.put(i, new ArrayList<>());
      }
    }
    int cnt = 0, totalcnt = 0;
    List<Integer> l = new ArrayList<>();
    for (int i : map.keySet())  {
      ++totalcnt;
      if (totalcnt % 100 == 0)  {
        System.out.println(i + ":" + totalcnt);
      }
      final int curr = i;
      l = map.keySet().stream().parallel().filter(j -> Long.parseLong(curr + "" + j) < range && !allprimes.get(Integer.parseInt(curr + "" + j))
          && Long.parseLong(j + "" + curr)  < range && !allprimes.get(Integer.parseInt(j + "" + curr))).collect(Collectors.toList());
      map.put(i, l);
    }
    for (int i : map.keySet())  {
      Set<Integer> s1 = new HashSet<>();
      Set<Integer> s2 = new HashSet<>();
      Set<Integer> s3 = new HashSet<>();
      s1.addAll(map.get(i));
      for (int j : s1)  {
        if ( i == j)  {
          continue;
        }
        s2.clear();
        s2.addAll(map.get(j));
        s2.retainAll(s1);
        for (int k : s2)  {
          if (k ==i || k ==j) {
            continue;
          }
          s3.clear();
          s3.addAll(map.get(k));
          s3.retainAll(s2);
          StringBuilder strbld = new StringBuilder();
          for (int m : s3)  {
            strbld.append(m);
            strbld.append(",");
          }
          if (s3.size() > 2)  {
            System.out.println(":" + i + ":" + j + ":" + k + ":" + strbld.toString());
          }
        }
      }
    }
    System.out.println(map.size());
    System.out.println("Time taken :" + (System.currentTimeMillis() - start));

  }
}
