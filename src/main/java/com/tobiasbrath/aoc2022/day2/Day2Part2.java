package com.tobiasbrath.aoc2022.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2Part2 {
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
            //65 = loss, 66 = tie, 67 = win
            while ((line = reader.read()) != -1)
            {
                if (line > 64 && line < 68) {
                    abc.add(line);
                }
                if (line > 87 && line < 91) {
                    xyz.add(line - 23);
                }
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Reading from file didn't work");
        }
        //calculate points
        int points = getPointsWTL(xyz) + getPointsRPS(abc, xyz);
        //print result
        System.out.println("Points: " + points);
    }

    //calculate points for using xyz (losses/ties/wins)
    static int getPointsWTL(ArrayList<Integer> round) {
        int points = 0;
        for (Integer outcome : round) {
            if (outcome == 65) {
                points += 0;   //unnecessary but just to show what it is (a loss)
            } else if (outcome == 66) {
                points += 3;  //draw
            } else {
                points += 6;  //win
            }
        }
        return points;
    }

    //calculate points for win/tie/loss
    static int getPointsRPS(ArrayList<Integer> elfHand, ArrayList<Integer> outcome) {
        int points = 0;
        for (int round = 0; round < outcome.size(); round++) {
            int elf = elfHand.get(round);
            int me = outcome.get(round);

            //points for losses
            if (me == 65) {
                //rock
                if (elf == 65) {
                    points += 3;
                }
                //paper
                if (elf ==66) {
                    points += 1;
                }
                //scissors
                if (elf ==67) {
                    points += 2;
                }
            }

            //points for ties
            if (me == 66) {
                //rock
                if (elf == 65) {
                    points += 1;
                }
                //paper
                if (elf == 66) {
                    points += 2;
                }
                //scissors
                if (elf == 67) {
                    points += 3;
                }
            }

            //points for wins
            if (me == 67) {
                //rock
                if (elf == 65) {
                    points += 2;
                }
                //paper
                if (elf == 66) {
                    points += 3;
                }
                //scissors
                if (elf == 67) {
                    points += 1;
                }
            }
        }
        return points;
    }
}