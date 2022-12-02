package com.tobiasbrath.aoc2022.day2.helpers;

import java.util.ArrayList;

public class Helper {
    //loop through array and assign points for every usage of rock, paper, scissors
    public static int getPointsRPSPart1(ArrayList<Integer> x) {
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
    public static int getPointsWTLPart1(ArrayList<Integer> abc, ArrayList<Integer> xyz) {
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

    //calculate points for using xyz (losses/ties/wins)
    public static int getPointsWTLPart2(ArrayList<Integer> round) {
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
    public static int getPointsRPSPart2(ArrayList<Integer> elfHand, ArrayList<Integer> outcome) {
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
                if (elf == 66) {
                    points += 1;
                }
                //scissors
                if (elf == 67) {
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
