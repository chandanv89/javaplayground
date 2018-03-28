package com.github.chandanv89.puzzles.sieveOfEratosthenes.algorithm;

import com.github.chandanv89.puzzles.sieveOfEratosthenes.PrimeGenerationAlgorithm;

import static java.lang.Math.sqrt;
import static java.util.Arrays.fill;

/**
 * The type Prime gen.
 */
public class PrimeGen {

   /**
    * Generate prime int [ ].
    *
    * @param n         the n
    * @param algorithm the algorithm
    * @return the int [ ]
    */
   public int[] generatePrimes(int n, PrimeGenerationAlgorithm algorithm) {
      if (n < 2) return new int[]{};
      if (n == 2) return new int[]{2};

      if (algorithm.equals(PrimeGenerationAlgorithm.SIEVE_OF_ERATOSTHENES))
         return sieveOfEratosthenes(n);

      return new int[]{};
   }

   private int[] sieveOfEratosthenes(int n) {
      boolean[] primeTable = new boolean[n + 1];
      fill(primeTable, true);

      int N = (int) sqrt(n);
      for (int i = 2; i <= N; i++) {
         if (primeTable[i])
            for (int j = i * 2; j <= n; j += i) {
               primeTable[j] = false;
            }
      }

      int[] primes = new int[N * N];
      for (int i = 2, j = 0; i <= n; i++)
         if (primeTable[i]) primes[j++] = i;

      return primes;
   }
}
