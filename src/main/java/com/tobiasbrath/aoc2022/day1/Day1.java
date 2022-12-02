package com.tobiasbrath.aoc2022.day1;

import java.io.*;
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

        //System.out.println(cals.get(cals.size() - 1));
       /* //count number of zeros to find out how many elves there are.
        int zeroCounter = 0;
        for (Integer cal : cals) {
            if (cal == 0) {
                zeroCounter++;
            }
        }

        //make array because I haven't figured out how to do += to an arraylist
        int[] calArray = new int[zeroCounter + 1];

        int elf = 0;

        //add the calories together, changing spot in the array every time a zero (new elf) comes up
        for (int i = 0; i < cals.size() - 1; i++) {
            if (cals.get(i) == 0)  //kan va bättre att använda -1 ifall t ex 0 används i .txt
            {
                elf++;
            }
            calArray[elf] += cals.get(i);
        }

        ArrayList<Integer> fatties = new ArrayList<>();

        int maxCal = 0;

        //loop through the calArray and assign it to an arrayList
        for (int i = 0; i < elf; i++) {
            fatties.add(calArray[i]);
        }

        //sort arraylist
        fatties.sort(Comparator.naturalOrder());

        int x = fatties.size() - 1;

        int maxCal3 = fatties.get(x) + fatties.get(x - 1) + fatties.get(x - 2);

        //print results
        System.out.println("Max calories is: " + fatties.get(x));
        System.out.println("The combined calories of the three largest numbers is: " + maxCal3); */
    }

    /* static void writeOutput(int[] parts) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
            writer.write("Writing to a file, fish.");
            writer.write("\nHere is another line.");
            //writing from an array
            for (int fish: parts) {
                writer.write("\n" + fish);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Writing to file did not work.");
        }
    } */

   /* static void readInput() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("day1.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Reading from file didn't work");
        }
    } */
}