package com.github.chandanv89.lynda.codeclinic.lakePendOreille;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * puzzles - com.github.chandanv89.lynda.codeclinic.lakePendOreille.Solution
 * Copyright (C) 2018 chandanv89
 * <p>
 * Created: Tue 01 May 2018
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
public class Solution {
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException {
      String[] s = {"", "", ""};

      Scanner in = new Scanner(System.in);

      System.out.println("Enter a year (2006-2014)");
      s[0] = in.nextLine();
      System.out.println("Enter a month (01-12)");
      s[1] = in.nextLine();
      System.out.println("Enter a day (01-31)");
      s[2] = in.nextLine();
      in.close();
      ArrayList<Double> windGust = getData("Wind_Gust", s);
      ArrayList<Double> airTemp = getData("Air_Temp", s);
      ArrayList<Double> pressure = getData("Barometric_Press", s);
      System.out.println("Wind Gust:  mean " + mean(windGust) + ", median "
              + median(windGust));
      System.out.println("Air Temp:  mean " + mean(airTemp) + ", median "
              + median(airTemp));
      System.out.println("Pressure:  mean " + mean(pressure) + ", median "
              + median(pressure));
   }

   private static ArrayList<Double> getData(String type, String[] s)
           throws NumberFormatException, IOException {
      String url = "http://lpo.dt.navy.mil/data/DM/" + s[0] + "/"
              + s[0] + "_" + s[1] + "_" + s[2] + "/" + type;
      System.out.println("URL: " + url);
      URL dataSource = new URL(url);
      BufferedReader data = new BufferedReader(new InputStreamReader(
              dataSource.openStream()));
      ArrayList<Double> windData = new ArrayList<>();
      String inputLine;
      while ((inputLine = data.readLine()) != null)
         windData.add(Double.parseDouble(inputLine.substring(20)));
      data.close();
      return windData;
   }

   private static double mean(ArrayList<Double> a) {
      double sum = 0;
      for (double i : a) {
         sum += i;
      }
      return sum / a.size();
   }

   private static double median(ArrayList<Double> a) {
      Collections.sort(a);
      if (a.size() / 2 * 2 == a.size()) {
         return (a.get(a.size() / 2) + a.get(a.size() / 2 - 1)) / 2;
      } else {
         return a.get(a.size() / 2);
      }
   }
}
