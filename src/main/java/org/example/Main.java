package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter th file:");
        String file=scanner.nextLine();
        try {
            ArrayFileStatistic fileStatistic=new ArrayFileStatistic(new BufferedReader(new InputStreamReader(new FileInputStream(file))));
            System.out.println("Max: " + fileStatistic.getMaxNumber());
            System.out.println("Min: " + fileStatistic.getMinNumber());
            System.out.println("Average: " + fileStatistic.getAverage());
            System.out.println("Median: " + fileStatistic.getMediana());
            System.out.println("Longest Increasing Sequence: " + fileStatistic.findLongestIncreasingSequence());
            System.out.println("Longest Decreasing Sequence: " + fileStatistic.findLongestDecreasingSequence());

        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }


    }
}