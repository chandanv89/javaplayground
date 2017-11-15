package com.cdn.javaPlaygrund.sieveOfEratosthenes.algorithm;

import com.cdn.javaPlaygrund.sieveOfEratosthenes.PrimeGenerationAlgorithm;

import static java.lang.Math.sqrt;
import static java.util.Arrays.fill;

public class PrimeGen {

    public int[] generatePrime(int n, PrimeGenerationAlgorithm algorithm) {
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

        int[] primes = new int[N*N];
        for (int i = 2, j = 0; i <= n; i++)
            if (primeTable[i]) primes[j++] = i;

        return primes;
    }
}
