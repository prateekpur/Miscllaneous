import java.util.*;
import java.util.stream.Stream;

/**
 * Created by neha on 2/19/18.
 */
public class Prob61 {
  static Map<Integer, Set<Integer>> octagonals = getOctagonals();
  static Map<Integer, Set<Integer>> heptagonals = getHeptagonals();
  static Map<Integer, Set<Integer>> hexagonals = getHexagonals();
  static Map<Integer, Set<Integer>> pentagonals = getPentagonals();
  static Map<Integer, Set<Integer>> squares = getSquares();
  static Map<Integer, Set<Integer>> triangles = getTriangles();
  //static boolean octagonFound = false, heptagonFound = false, hexagonFound = false, pentagonFound = false, squareFound = false, triangleFound = false;
  static boolean[] found = new boolean[5], ignore = new boolean[5];
  static boolean ignoreHeptagon = false, ignoreHexagon = false, ignorePentagon = false, ignoreSquare = false, ignoreTriangle = false;

  static Set<Integer> numbersSearched = new HashSet<>();

  enum Shape {TRIANGLE(0), SQUARE(1), PENTAGON(2), HEXAGON(3), OCTAGON(4), HEPTAGON(5);
    final int index;
    Shape(int i)  {
      this.index = i;
    }
  };
  static Shape levelFound;

  public static void main (String args[]) {
    for (int i = 0; i < found.length; ++i)  {
      found[i] = false;
    }
//    Set<Shape> levels1 = new HashSet<>(); levels1.add(Shape.OCTAGON);
//    List<Integer> nums1 = new ArrayList<>(); nums1.add(1281);
//    findNums(1281, levels1, nums1);
    for (Set<Integer> set : octagonals.values())  {
      for (int num : set) {
        Set<Shape> levels = new HashSet<>();
        List<Integer> nums = new ArrayList<>();
        levels.add(Shape.OCTAGON);
        nums.add(num);
        findNums(num, levels, nums);

      }
    }
  }

  static void findNums(int num, Set<Shape> shapes, List<Integer> numsFound)  {
    StringBuilder bld = new StringBuilder("Nums");
    for (int i : numsFound) {
      bld.append(i); bld.append(",");
    }

    if (shapes.size() == 6) {
      //System.out.println("Found : " + numsFound.size());
      if (numsFound.get(0) / 100 == numsFound.get(5) % 100) {
        System.out.println("Finally -------");
        System.out.println(numsFound.get(0) + numsFound.get(1) + numsFound.get(2) + numsFound.get(3) + numsFound.get(4) + numsFound.get(5));
      }
      bld = new StringBuilder("");
      for (int i : numsFound) {
        bld.append(i); bld.append(",");
      }
      return;
    }
    Set<Shape> levelsFound = new HashSet<>() ;
    List<Integer> newnumsFound = new ArrayList<>();
    newnumsFound.addAll(numsFound);
    levelsFound.addAll(shapes);
    Map<Shape, Set<Integer>> map = numFound(num, levelsFound, numsFound);
    for (Shape shape : map.keySet())  {
      Set<Shape> newShapes = new HashSet<>();
      newShapes.addAll(shapes);
      newShapes.add(shape);
      List<Integer> newnumsFoundRecurse = new ArrayList<>();
      newnumsFoundRecurse.addAll(numsFound);
      for (int num1 : map.get(shape)) {
        newnumsFoundRecurse.add(num1);
        findNums(num1, newShapes, newnumsFoundRecurse);
        newnumsFoundRecurse.remove(newnumsFoundRecurse.size() - 1);
      }
    }
  }

  public List<Integer> removeIntFromList(List<Integer> li, int num) {
    List<Integer> newLi = new ArrayList<>();
    for (int i : li)  {
      if (i != num) {
        newLi.add(i);
      }
    }
    return newLi;
  }


  /**
   * find other numbers matching last digit, ignore levels in levelsFound
   * @param num - Number for matching last digit
   * @param levelsFound - levels found so far
   * @param numsFound
   * @return - Map having key=Shape, value = List of matching numbers found
   */
  static Map<Shape, Set<Integer>> numFound(int num, Set<Shape> levelsFound, List<Integer> numsFound) {
    Map<Shape, Set<Integer>> map = new HashMap<>();
    int last2Digs = num % 100;
    if (!levelsFound.contains(Shape.HEPTAGON) && heptagonals.containsKey(last2Digs))  {
      //levelsFound.add(Shape.HEPTAGON);
      levelFound = Shape.HEPTAGON;
      map.put(Shape.HEPTAGON, heptagonals.get(last2Digs));
    }
    if (!levelsFound.contains(Shape.HEXAGON) && hexagonals.containsKey(last2Digs))  {
      //levelsFound.add(Shape.HEXAGON);
      levelFound = Shape.HEXAGON;
      map.put(Shape.HEXAGON, hexagonals.get(last2Digs));
    }
    if (!levelsFound.contains(Shape.PENTAGON) && pentagonals.containsKey(last2Digs))  {
      //levelsFound.add(Shape.PENTAGON);
      levelFound = Shape.PENTAGON;
      map.put(Shape.PENTAGON, pentagonals.get(last2Digs));
    }
    if (!levelsFound.contains(Shape.SQUARE) && squares.containsKey(last2Digs))  {
      //levelsFound.add(Shape.SQUARE);
      levelFound = Shape.SQUARE;
      map.put(Shape.SQUARE, squares.get(last2Digs));
    }
    if (!levelsFound.contains(Shape.TRIANGLE) && triangles.containsKey(last2Digs))  {
      //levelsFound.add(Shape.TRIANGLE);
      found[Shape.TRIANGLE.index] = true;
      levelFound = Shape.TRIANGLE;
      map.put(Shape.TRIANGLE, triangles.get(last2Digs));
    }
    return map;
  }


  //get 4 digit octagonals
  static Map<Integer, Set<Integer>> getOctagonals()  {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    // octagonal numbers start with n=19
    StringBuilder bld = new StringBuilder();
    int cnt = 19;
    int num = cnt * (3*cnt - 2);
    do {
      bld.append(num);
      bld.append(",");
      //System.out.println(num);
      addToMap(map, num);
      cnt ++;
      num = cnt * (3*cnt - 2);
    } while (num <= 9999);
    System.out.println("Octagonals : " + bld.toString());
    return map;
  }

  static Map<Integer, Set<Integer>> getHeptagonals()  {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    StringBuilder bld = new StringBuilder();
    int cnt = 21;
    int num =   cnt * (5*cnt - 3)/2;
    do {
      //System.out.println(num);
      bld.append(num);
      bld.append(",");
      addToMap(map, num);
      cnt++;
      num =   cnt * (5*cnt - 3)/2;
    } while (num <= 9999);
    System.out.println("Heptagon : " + bld.toString());
    return map;
  }

  private static void addToMap(Map<Integer, Set<Integer>> map, int num) {
    int first2Dig = num / 100;
    Set<Integer> set = new HashSet<>();
    set.add(num);
    if (map.containsKey(first2Dig))  {
      set.addAll(map.get(first2Dig));
    }
    map.put(first2Dig, set);
  }

  static Map<Integer, Set<Integer>> getHexagonals() {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    StringBuilder bld = new StringBuilder();
    int cnt = 23;
    int num = cnt * (2*cnt - 1);
    do {
      //System.out.println(num);
      bld.append(num);
      bld.append(",");
      addToMap(map, num);
      cnt++;
      num = cnt * (2*cnt - 1);
    } while (num <= 9999);
    System.out.println("Hexagon : " + bld.toString());
    return map;
  }

  static Map<Integer, Set<Integer>> getPentagonals() {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    Set<Integer> set = new HashSet<>();
    StringBuilder bld = new StringBuilder();
    int cnt = 26;
    int num = cnt * (3*cnt - 1)/2;
    do {
      //System.out.println(num);
      bld.append(num);
      bld.append(",");
      addToMap(map, num);
      cnt++;
      num = cnt * (3*cnt - 1)/2;
    } while (num <= 9999);
    System.out.println("Pentagon :" + bld.toString());
    return map;
  }

  static Map<Integer, Set<Integer>> getSquares()  {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    int cnt = 32;
    int num = cnt * cnt;
    StringBuilder bld = new StringBuilder();
    do {
      //System.out.println(num);
      bld.append(num);
      bld.append(",");
      addToMap(map, num);
      ++cnt;
      num = cnt * cnt;
    } while (num <= 9999);
    System.out.println("Square :" + bld.toString());
    return map;
  }

  static Map<Integer, Set<Integer>> getTriangles() {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    int cnt = 45;
    int num = cnt * (cnt + 1)/2;
    StringBuilder bld = new StringBuilder();
    do {
      //System.out.println(num);
      bld.append(num);
      bld.append(",");
      addToMap(map, num);
      ++cnt;
      num = cnt * (cnt + 1)/2;
    } while (num <= 9999);
    System.out.println("Triangle : " + bld.toString());
    return map;
  }

}


