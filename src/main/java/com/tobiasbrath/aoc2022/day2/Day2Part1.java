package com.tobiasbrath.aoc2022.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2Part1 {
    public static void main(String[] args) {

        //create ArrayList to put ints from file into
        ArrayList<Integer> abc = new ArrayList<>();
        ArrayList<Integer> xyz = new ArrayList<>();

        //read files from .txt with abc & xyz
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day2.txt"));
            int line;
            //loop through file, put abc in first list, xyz in second list.
            // minus -23 on the input into xyz so it gets the same ascii value as abc
            //65 = rock, 66 = paper, 67 = scissors
            while ((line = reader.read()) != -1) {
                if (line > 64 && line < 68) {
                    abc.add(line);
                }
                if (line > 87 && line < 91) {
                    xyz.add(line - 23);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Reading from file didn't work");
        }

        //Calculate points
        int points = getPointsRPS(xyz) + getPointsWTL(abc, xyz);
        //Print result
        System.out.println("Points: " + points);
    }

    //loop through array and assign points for every usage of rock, paper, scissors
    static int getPointsRPS(ArrayList<Integer> x) {
        int points = 0;
        for (Integer integer : x) {
            if (integer == 65) {
                points += 1;
            } else if (integer == 66) {
                points += 2;
            } else {
                points += 3;
            }
        }
        return points;
    }

    //calculate points for win/tie/loss
    static int getPointsWTL(ArrayList<Integer> abc, ArrayList<Integer> xyz) {
        int points = 0;

        for (int i = 0; i < abc.size(); i++) {
            //put values into new int because im too lazy to write abc.get() & xyz.get() all the time
            int elf = abc.get(i);
            int me = xyz.get(i);
            //points for wins
            //rock vs scissor
            if (me == 65 && elf == 67) {
                points += 6;
            }
            //paper vs rock
            if (me == 66 && elf == 65) {
                points += 6;
            }
            //scissor vs paper
            if (me == 67 && elf == 66) {
                points += 6;
            }
            //tie
            if (me == elf) {
                points += 3;
            }
        }
        return points;
    }
}