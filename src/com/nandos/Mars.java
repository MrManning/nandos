package com.nandos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mars {

    public static void main(String[] args) {
        int line = 0;
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

        try {
            String[] gridSize = sc.nextLine().split(" ");

            // Increased size for x and y to ensure the upper-right coordinate exists
            Rover.plateau = new int[Integer.parseInt(gridSize[0]) + 1][Integer.parseInt(gridSize[1]) + 1];

            Rover rover = null;
            while(sc.hasNextLine()) {

                // If the line number is even it's the declaration of a new rover
                // If the line number is odd it's the set of instructions
                if(line % 2 == 0) {
                    String[] inputLine = sc.nextLine().split(" ");

                    int x = Integer.parseInt(inputLine[0]);
                    int y = Integer.parseInt(inputLine[1]);
                    String heading = inputLine[2];

                    // Only create a new rover if the input values are valid
                    if( Position.validPosition(x, y) && Rotation.validRotation(heading) ) {
                        rover = new Rover(x, y, heading);
                    }
                } else {
                    String instructions = sc.nextLine();

                    // Loop string of instructions updating rover in each loop
                    for( int i = 0; i < instructions.length(); i++ ) {
                        if( rover != null ) {
                            rover.updateRover(instructions.charAt(i));
                        }
                    }
                    if( rover != null ) {
                        System.out.println(rover.position);
                    }
                }

                line++;
            }
            sc.close();
        } catch( NumberFormatException e ) {
            System.err.println("Error: Invalid upper-right coordinates");
        }
    }
}
