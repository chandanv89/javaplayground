package com.cdn.javaPlaygrund.sieveOfEratosthenes.algorithm;

import com.cdn.javaPlaygrund.sieveOfEratosthenes.PrimeGenerationAlgorithm;

import static java.lang.Math.sqrt;

public class PrimeGen {

    public int[] generatePrime(int to){//, PrimeGenerationAlgorithm algorithm) {
        //if (from < 2) return new int[]{from};

        if(to<3) return new int[]{to};

        boolean[] primeTable = new boolean[to];
        for (int i = 0; i < to; i++) {
            primeTable[i] = true;
        }

        int n = (int) sqrt(to);
        for(int i=2; i<=n; i++){
            for(int j=i*2; j<to; j++){
                if(primeTable[j]) primeTable[j]=false;
            }
        }
    }
}
