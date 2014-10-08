import java.util.*;

/**
 * Created by Prateek on 9/25/2014.
 */
public class DnaFrequency {
  public static void main (String args[]) {
    String genomeSequence = "ACCAAGCCGATCTTAAACCTACCCTTGCTACCCTTGCTACCCTTGCACATGTTATCTTAAACATCTTAAACCACATGTTCACATGTTACCAAGCCGATCTTAAACACCAAGCCGATCTTAAACACCAAGCCGCTACCCTTGACCAAGCCGAATCCAGATCACATGTTAATCCAGATATCTTAAACATCTTAAACCACATGTTAATCCAGATATCTTAAACAATCCAGATAATCCAGATATCTTAAACACCAAGCCGAATCCAGATCACATGTTCTACCCTTGCTACCCTTGATCTTAAACATCTTAAACCACATGTTATCTTAAACATCTTAAACAATCCAGATCTACCCTTGAATCCAGATACCAAGCCGCACATGTTAATCCAGATCACATGTTACCAAGCCGATCTTAAACACCAAGCCGCTACCCTTGCACATGTTCACATGTTCTACCCTTGCTACCCTTGATCTTAAACATCTTAAACAATCCAGATAATCCAGATACCAAGCCGATCTTAAACCTACCCTTGATCTTAAACATCTTAAACCTACCCTTGCTACCCTTGCACATGTTACCAAGCCGACCAAGCCGATCTTAAACATCTTAAACAATCCAGATATCTTAAACATCTTAAACATCTTAAACATCTTAAACCTACCCTTGATCTTAAACCTACCCTTGACCAAGCCGCTACCCTTGCTACCCTTGCACATGTTCACATGTTCACATGTTATCTTAAACAATCCAGATATCTTAAACAATCCAGATACCAAGCCGATCTTAAACCACATGTTATCTTAAACACCAAGCCGCACATGTTACCAAGCCGATCTTAAACCTACCCTTGCACATGTTATCTTAAACACCAAGCCGAATCCAGATCTACCCTTGCACATGTTATCTTAAACCACATGTTATCTTAAACACCAAGCCGCTACCCTTGCTACCCTTGAATCCAGAT";
    final int lenK = 14;
    String subStrings[] = new String[genomeSequence.length()-lenK+1];
    int score[] = new int[genomeSequence.length()-lenK+1];
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i <= genomeSequence.length()-lenK; ++i) {
      String sub = genomeSequence.substring(i, i+lenK);
      subStrings[i] = sub;
      if (map.containsKey(sub)) {
        // incrementing the count if present
        int cnt = map.get(sub)+1;
        map.put(sub, cnt);
      } else  {
        map.put(sub, 1);
      }
    }
    int max = 0;
    Set<String> maxSubs = new HashSet<String>();
    for (int i = 0; i < score.length-1; ++i)  {
      score[i] = map.get(subStrings[i]);
      if (score[i] > max) {
        max = score[i];
        maxSubs.clear();
        maxSubs.add(subStrings[i]);
      } else if (score[i] == max) {
        maxSubs.add(subStrings[i]);
      }
    }
    for (String s : maxSubs)  {
      System.out.println(s);
    }
  }



  public static int getFrequency()  {
    String genomeSequency = "CTGTAATGTAAGTGTAATGTAAATAAATGTAAAATGTAAACAATGTAACGCTAATTCAATGTAACTAATGTAACAAATGTAAAATGTAAAA" +
        "ATGTAAACGAATAATGTAAGAATGTAAAGCAATGTAAAATGTAAGTGCAGCGCGTAATGTAATAATGTAAAATGTAAAAATGTAATGTGAGATCGATAATGTAAAATGTAA" +
        "ATACTAATGTAATAGACCTTCAAATGTAAAATGTAAAATGTAAGAGCAATGTAAGAATGTAACTGAATGTAAAGCAATGTAAAATGTAAACGGTTAATGTAATCCAAAATG" +
        "TAAGGAATGTAACAATGTAAGCTAATGTAATAAATGTAACGAATGTAACCCGAATGTAATCCTAATGTAAAAAATGTAACTGAAATGTAATAATGTAAGTCGAATGTAACA" +
        "ATGTAAAATGTAAGACAATGTAAGAATGTAATTTAATGTAATCAATGTAAAATGTAATATCTAATGTAACACGTTAATGTAAGTAAATGTAACGGGAATGTAATACATAAT" +
        "GTAAAATGTAAGCGCTGGAATGTAAACTGAACTAATGTAAAATGTAAGGCTCTATCCCGAATGTAAAATGTAAGAATGTAACAATGTAATAGTGCAATGTAAAGGAATGTA" +
        "ACAATGTAAACTATCTCAATGTAAGGCAATGTAAGTTCTAATGTAAAATGTAATAATGTAAAATGTAAAATGTAAAATGTAATTCAGACGGCTTTAATGTAAGAATGTAAA" +
        "GCCAATGTAAAAATGTAAAAATGTAAAATGTAAAAATGTAAAATGTAAAGAATGTAAGGAAAATGTAATTAATGTAACTTCGTTTAATGTAACAAAATGTAAAATGTAAAA" +
        "AGAATGTAAGAAATGTAAGATAGAATGTAAAAATGTAAAATGTAAAATGTAATAAGGAATGTAAGACTGGTCTCCCAATGTAACAATGTAA";
    String dnaA = "AATGTAAAA";
    int cnt = 0;
    for (int i = 0; i <= genomeSequency.length()-dnaA.length(); ++i) {
      String sub = genomeSequency.substring(i, i+dnaA.length());
      System.out.println(sub);
      if (sub.equalsIgnoreCase(dnaA)) {
        ++cnt;
      }
    }
    return cnt;
  }
}
