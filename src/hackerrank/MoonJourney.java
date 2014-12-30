package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prateek on 12/29/2014.
 * Problem url : https://www.hackerrank.com/challenges/journey-to-the-moon
 */
public class MoonJourney {
  public static void main(String args[])  {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = new String[0];
    int countryId = 0;
    // astroNauts[] stores country id for each astronaut
    int astroNauts[] = new int[0];
    //countries stores number of astronauts in each country. Index is id of each country
    int countries[] = new int[0];
    try {
      temp = bfr.readLine().split(" ");
      int N = Integer.parseInt(temp[0]);
      int I = Integer.parseInt(temp[1]);
      astroNauts = new int[N];
      countries = new int[I];
      //initializing array elements to be -1
      for (int i = 0; i < N; ++i)  {
        astroNauts[i] = -1;
      }
      for(int i = 0; i < I; i++){
        temp = bfr.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        if(astroNauts[a] == -1 && astroNauts[b] == -1)  {
          astroNauts[a] = countryId;
          astroNauts[b] = countryId;
          countries[countryId] = countries[countryId] + 2;
          ++countryId;
        } else if (astroNauts[a] == -1) {
          astroNauts[a] = astroNauts[b];
          int tmpId = astroNauts[a];
          countries[tmpId] = countries[tmpId] + 1;
        } else if (astroNauts[b] == -1)  {
          astroNauts[b] = astroNauts[a];
          int tmpId = astroNauts[b];
          countries[tmpId] = countries[tmpId] + 1;
        } else  {
          // this covers condition of both astronauts having a countryId != -1
          // convert all astronauts with country same as "a" to be in country of "b"
          int countryAstronautA = astroNauts[a];
          countries[countryAstronautA] = 0;
          for (int j = 0; j < N; ++j) {
            if (astroNauts[j] == countryAstronautA) {
              astroNauts[j] = astroNauts[b];
              countries[astroNauts[b]]++;
            }
          }
        }
        // Store a and b in an appropriate data structure of your choice
      }


      long combinations = 0;
      combinations = (long)N * ((long)N - 1l) / 2l;
      //reducing combinations in each country
      for (int i : countries) {
        int countryCombinations = i * (i-1) / 2 ;
        combinations = combinations - (long)countryCombinations;
      }
      System.out.println(combinations);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

/*
input :
100000 2
1 2
3 4

out : 4999949998
 */