package com.nandos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mars {
    public static int[][] plateau;

    public static void main(String[] args) {
        Mars mars = new Mars();
        Scanner sc = mars.openFile();

        if( mars.plateauInitialised(sc) ) {
            mars.navigateMars(sc);
        }

        sc.close();
    }

    private Scanner openFile() {
        Scanner sc = new Scanner(System.in);
        boolean isValidFile = false;

        while(!isValidFile) {
            try {
                System.out.print("Enter input file: ");

                String filename = sc.next();
                File file = new File(filename);
                sc = new Scanner(file);

                isValidFile = true;
            } catch(FileNotFoundException e) {
                System.out.println("File does not exist");
            }
        }

        return sc;
    }

    private boolean plateauInitialised(Scanner sc) {
        try {
            String[] gridSize = sc.nextLine().split(" ");

            // Increased size for x and y to ensure the upper-right coordinate exists
            plateau = new int[Integer.parseInt(gridSize[0]) + 1][Integer.parseInt(gridSize[1]) + 1];
            return true;
        } catch( NumberFormatException e ) {
            System.out.println("Error: Invalid upper-right coordinates!");
            return false;
        }
    }

    private void navigateMars(Scanner sc) {
        int lineCount = 0;
        Rover rover = null;

        while( sc.hasNextLine() ) {

            // If the line number is even it's the declaration of a new rover
            // If the line number is odd it's the set of instructions
            if( lineCount % 2 == 0 ) {
                rover = this.createRover(sc, rover);
            } else {
                this.executeInstructions(sc, rover);
                System.out.println(rover.position);
            }

            if( rover != null ) {
                lineCount++;
            } else {
                lineCount += 2;
                sc.nextLine();
            }
        }
    }

    private Rover createRover(Scanner sc, Rover rover) {
        String[] inputLine = sc.nextLine().split(" ");

        try {
            int x = Integer.parseInt(inputLine[0]);
            int y = Integer.parseInt(inputLine[1]);
            String heading = inputLine[2];

            // Only create a new rover if the input values are valid
            if( Position.validPosition(x, y) && Rotation.validRotation(heading) ) {
                return new Rover(x, y, heading);
            } else {
                System.out.println("Error: Invalid rover coordinates!");
            }
        } catch( NumberFormatException e ) {
            System.out.println("Error: Unparseable input " + e.getLocalizedMessage().toLowerCase());
        }

        return rover;
    }

    private void executeInstructions(Scanner sc, Rover rover) {
        String instructions = sc.nextLine();
        boolean roverIsNotNull = rover != null;

        // Loop string of instructions updating rover in each loop
        for( int i = 0; i < instructions.length(); i++ ) {
            if( roverIsNotNull ) {
                rover.updateRover(instructions.charAt(i));
            }
        }
    }
}
