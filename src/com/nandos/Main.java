package com.nandos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File filename = new File("src/input.txt");
        int line = 0;

        try {
            Scanner sc = new Scanner(filename);
            String[] gridSize = sc.nextLine().split(" ");

            Rover.upGrid = new int[Integer.parseInt(gridSize[0])][Integer.parseInt(gridSize[1])];

            Rover rover = null;
            while(sc.hasNextLine()) {

                if(line % 2 == 0) {
                    String[] inputLine = sc.nextLine().split(" ");

                    int x = Integer.parseInt(inputLine[0]);
                    int y = Integer.parseInt(inputLine[1]);
                    String heading = inputLine[2];

                    if(Movement.validPosition(x, y) && Rotation.validRotation(heading) ) {
                        rover = new Rover(x, y, heading);
                    }
                } else {
                    String instructions = sc.nextLine();
                    for( int i = 0; i < instructions.length(); i++ ) {
                        if( rover != null ) {
                            rover.updateRover(instructions.charAt(i));
                        }
                    }
                }

                line++;
            }
        } catch( FileNotFoundException e ) {
            System.out.println("Error: File not found");
        } catch( NumberFormatException e ) {
            System.out.println("Error: Invalid upper-right coordinates");
        }
    }
}
