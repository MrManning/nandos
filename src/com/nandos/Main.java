package com.nandos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File filename = new File("src/input.txt");

        try {
            Scanner sc = new Scanner(filename);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch( FileNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
