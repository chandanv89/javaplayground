package com.github.chandanv89.puzzles.codegolf;

import java.util.stream.Stream;

/**
 * The interface N.
 */
interface N {
   /**
    * C java . util . stream . stream.
    *
    * @param a the a
    * @return the java . util . stream . stream
    */
   java.util.stream.Stream<String> c(java.util.stream.Stream<String> a);
}

/**
 * puzzles - com.github.chandanv89.puzzles.codegolf.DigitsInTheirLanes  (http://j.mp/2IZpl92)
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
public class DigitsInTheirLanes {


   /**
    * The N.
    */
   static N n = a -> a.map(i -> "-0123456789".replaceAll("[^" + i + "]", "."));

   /**
    * The entry point of application.
    *
    * @param a the input arguments
    */
   public static void main(String[] a) {
      test("1", "729", "4728510", "-3832", "748129321", "89842", "-938744", "0", "11111");
      test("4", "534", "4", "4", "53", "26", "71", "835044", "-3559534", "-1027849356", "-9", "-99", "-3459", "-3459", "-94593", "-1023467859");
      test("112", "379", "-3", "409817", "239087123", "-96", "0", "895127308", "-97140", "923", "-748");
      test("-15", "-14", "-13", "-12", "-11", "10", "-9", "-8", "-7", "-5", "-4", "-3", "-1", "0", "9", "100", "101", "102", "1103", "104", "105", "106", "116", "-12345690");
      test("99", "88", "77", "66", "55", "44", "33", "22", "11", "10", "0", "0", "0", "-941");
   }

   /**
    * Test.
    *
    * @param a the a
    */
   static void test(String... a) {
      for (Object o : n.c(java.util.stream.Stream.of(a)).toArray())
         System.out.println(o);
      System.out.println("--------------------------------------------------");
   }
}

