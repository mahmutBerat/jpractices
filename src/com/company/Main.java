package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("com/company/input.txt");

        Scanner scanner = new Scanner(input);
        int[] matrix = new int[2];
        matrix[0] = scanner.nextInt();
        matrix[1] = scanner.nextInt();

        Rover rover_1 = parseRoverInfo(scanner);
        rover_1.setMatrix(matrix[0], matrix[1]);

        Rover rover_2 = parseRoverInfo(scanner);
        rover_2.setMatrix(matrix[0], matrix[1]);

        System.out.println(rover_1.moveOnMatrix());
        System.out.println(rover_2.moveOnMatrix());
    }

    private static Rover parseRoverInfo(Scanner scanner) {
        int[] roverPosition = new int[2];
        roverPosition[0] = scanner.nextInt();
        roverPosition[1] = scanner.nextInt();
        String roverDirection = scanner.next();
        String instructions = scanner.next();

        //this initialization part can also be in factory method in next versions
        return new Rover(roverPosition[0], roverPosition[1], roverDirection, instructions);
    }
}
