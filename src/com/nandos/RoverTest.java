package com.nandos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void updateRover() {
        Rover rover = new Rover(2,3, "N");
        rover.updateRover("M");
        rover.updateRover("R");
        rover.updateRover("M");

        assertEquals(4, rover.position.getY());
        assertEquals(3, rover.position.getX());
        assertEquals("E", rover.position.getHeading().name());
    }

    @Test
    void invalidUpdateRover() {
        Rover rover = new Rover(4,4, "N");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> rover.updateRover("M"));
        assertEquals("invalid move", exception.getMessage());
    }

    @Test
    void moveRover() {
        Rover rover = new Rover(2,3, "S");
        rover.moveRover();
        assertEquals(2, rover.position.getY());

        rover.rotateRover("R");
        rover.moveRover();
        assertEquals(1, rover.position.getX());

        rover.rotateRover("R");
        rover.moveRover();
        assertEquals(3, rover.position.getY());

        rover.rotateRover("R");
        rover.moveRover();
        assertEquals(2, rover.position.getX());
    }

    @Test
    void rotateRover() {
        Rover rover = new Rover(4, 2, "W");
        rover.rotateRover("L");
        assertEquals("S", rover.position.getHeading().name());
    }
}