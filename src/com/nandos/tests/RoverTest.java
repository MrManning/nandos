package com.nandos.tests;

import com.nandos.Mars;
import com.nandos.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverTest {
    @BeforeEach
    void init() {
        Mars.plateau = new int[5][5];
    }

    @Test
    void updateRover() {
        Rover rover = new Rover(2,3, "N");
        rover.updateRover('M');
        rover.updateRover('R');
        rover.updateRover('M');

        assertEquals(4, rover.position.getY());
        assertEquals(3, rover.position.getX());
        assertEquals("E", rover.position.getHeading().name());
    }

    @Test
    void invalidUpdateRover() {
        Rover rover = new Rover(4,4, "N");
        rover.updateRover('M');
        assertEquals(4, rover.position.getY());
    }

    @Test
    void moveRover() {
        Rover rover = new Rover(2,3, "S");
        rover.moveRover();
        assertEquals(2, rover.position.getY());

        rover.rotateRover('R');
        rover.moveRover();
        assertEquals(1, rover.position.getX());

        rover.rotateRover('R');
        rover.moveRover();
        rover.moveRover();
        assertEquals(4, rover.position.getY());
    }

    @Test
    void rotateRover() {
        Rover rover = new Rover(4, 2, "W");
        rover.rotateRover('L');
        assertEquals("S", rover.position.getHeading().name());
    }

    @Test
    void moveRoverRight() {
        Rover rover = new Rover(1, 2, "S");
        rover.rotateRover('L');
        rover.moveRover();
        rover.moveRover();
        assertEquals(3, rover.position.getX());
    }

    @Test
    void multipleRovers() {
        Rover rover1 = new Rover(1, 2, "E");
        Rover rover2 = new Rover(1, 3, "S");

        rover2.moveRover();
        rover1.moveRover();

        assertEquals(2, rover1.position.getX());
        assertEquals(3, rover2.position.getY());
    }
}