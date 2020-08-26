package com.nandos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mars {

    public static void main(String[] args) {
        File filename = new File("src/input.txt");
        int line = 0;

        try {
            Scanner sc = new Scanner(filename);
            String[] gridSize = sc.nextLine().split(" ");

            Rover.plateau = new int[Integer.parseInt(gridSize[0]) + 1][Integer.parseInt(gridSize[1]) + 1];

            Rover rover = null;
            while(sc.hasNextLine()) {

                if(line % 2 == 0) {
                    String[] inputLine = sc.nextLine().split(" ");

                    int x = Integer.parseInt(inputLine[0]);
                    int y = Integer.parseInt(inputLine[1]);
                    String heading = inputLine[2];

                    if( Position.validPosition(x, y) && Rotation.validRotation(heading) ) {
                        rover = new Rover(x, y, heading);
                    }
                } else {
                    String instructions = sc.nextLine();
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
        } catch( FileNotFoundException e ) {
            System.err.println("Error: File not found");
        } catch( NumberFormatException e ) {
            System.err.println("Error: Invalid upper-right coordinates");
        }
    }
}
