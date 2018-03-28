package com.github.chandanv89.puzzles.sieveOfEratosthenes;

import com.github.chandanv89.puzzles.sieveOfEratosthenes.algorithm.PrimeGen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * puzzles - com.github.chandanv89.puzzles.sieveOfEratosthenes.TestSieveOfEratosthenes
 * Copyright (C) 2018 chandanv89
 * <p>
 * Created: Tue 27 Mar 2018
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
public class TestSieveOfEratosthenes {
   private PrimeGen primeGen;
   private int N;

   private void printPrimes(int[] list) {
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

   /**
    * Init.
    */
   @Before
   public void init() {
      primeGen = new PrimeGen();
      N = 100;
   }

   /**
    * Test prime gen.
    */
   @Test
   public void testPrimeGen() {
      N = 1000;
      int[] primes = primeGen.generatePrimes(N, PrimeGenerationAlgorithm.SIEVE_OF_ERATOSTHENES);

      printPrimes(primes);
      System.out.println();

      //assertEquals(4, primes.length);
   }
}
