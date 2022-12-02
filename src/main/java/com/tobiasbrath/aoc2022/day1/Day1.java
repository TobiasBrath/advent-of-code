package com.tobiasbrath.aoc2022.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("Scanning input from file.");

        //create ArrayList to put ints from file into
        ArrayList<Integer> cals = new ArrayList<>();

        //read files from .txt with calorie numbers
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day1.txt"));
            String line;
            int sToI;
            int currentValue = 0;
            //loop through file, parse every line to an int and store it in an arraylist.
            while ((line = reader.readLine()) != null) {
                try {
                    sToI = Integer.parseInt(line);
                    currentValue += sToI;
                    //cals.add(sToI);
                    // if the line is blank, and we get an error, instead add 0 to the arraylist to mark a space
                } catch (NumberFormatException e) {  //brukar inte använda catch för att göra saker
                    cals.add(currentValue);
                    currentValue = 0;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Reading from file didn't work");
        }

        cals.sort(Comparator.naturalOrder());

        System.out.println(cals.get(cals.size() - 1));
        System.out.println(cals.get(cals.size() - 1) + cals.get(cals.size() - 2) + cals.get(cals.size() - 3));

    }
}