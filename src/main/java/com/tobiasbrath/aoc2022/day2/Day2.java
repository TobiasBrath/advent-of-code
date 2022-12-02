package com.tobiasbrath.aoc2022.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.tobiasbrath.aoc2022.day2.helpers.Helper.*;

public class Day2 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {

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
        int points = getPointsRPSPart1(xyz) + getPointsWTLPart1(abc, xyz);
        //Print result
        System.out.println("Points: " + points);
    }

    private static void part2() {

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
            //65 = loss, 66 = tie, 67 = win
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
        //calculate points
        int points = getPointsWTLPart2(xyz) + getPointsRPSPart2(abc, xyz);
        //print result
        System.out.println("Points: " + points);
    }
}
