import java.util.BitSet;
import java.util.logging.Logger;

public class Prob58 {
    static Logger logger = Logger.getLogger( Prob58.class.getName() );

    public static void main(String args[]) {
        BitSet primes = Utils.getPrimesBitset(Integer.MAX_VALUE);
        long cntprimes = 0, total = 1;
        long st = System.currentTimeMillis();
        getEdges(1115);
        for (int i = 3; i < 40000; i = i+2)    {
            int j[] = getEdges(i);
            total += 4;
            if (!primes.get(j[0]))  {
                ++cntprimes;
            }
            if (!primes.get(j[1]))  {
                ++cntprimes;
            }
            if (!primes.get(j[2]))  {
                ++cntprimes;
            }
            if (!primes.get(j[3]))  {
                ++cntprimes;
            }
            if ((float)cntprimes/total < 0.1)   {
                System.out.println("" + i + " " + j[0] + " " + j[1] + " " + j[2] + " " + j[3] + " : " + cntprimes + " " + total + " " + (float)cntprimes/total);
                System.out.println(System.currentTimeMillis() - st);
                System.exit(0);
            }
        }
    }

    /**
     * Returns edegs of diagonal at level
     * @param level
     * @return
     */
    static int[] getEdges(int level)    {
        // last edge is level^2
        int edges[] = new int[4];
        edges[0] = level * level;
        edges[1] = edges[0] - level + 1;
        edges[2] = edges[1] - level + 1;
        edges[3] = edges[2] - level + 1;
        return edges;
    }
}
