package com.github.chandanv89.puzzles.sieveOfEratosthenes;

import com.github.chandanv89.puzzles.sieveOfEratosthenes.algorithm.PrimeGen;

import java.util.Calendar;

/**
 * The type App.
 */
public class App {
   private static int N = 1000000;

   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args) {
      PrimeGen primeGen = new PrimeGen();

      long start = Calendar.getInstance().getTimeInMillis();
      int[] primes = primeGen.generatePrimes(N, PrimeGenerationAlgorithm.SIEVE_OF_ERATOSTHENES);
      long end = Calendar.getInstance().getTimeInMillis();

      printPrimes(primes);

      System.out.println("\n\nGenerate prime numbers < " + N + " in " + (end - start) + "ms");
   }

   private static void printPrimes(int[] list) {
      int j = 0;
      String format = "%" + ((N + "").length() + 1) + "d";
      for (int i : list)
         if (i != 0) {
            System.out.printf(format, i);
            j++;
            if (j > 30) {
               j = 0;
               System.out.println();
            }
         }
   }
}
