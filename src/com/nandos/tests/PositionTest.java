package com.nandos.tests;

import com.nandos.Position;
import com.nandos.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @BeforeAll
    static void init() {
        Rover.plateau = new int[5][5];
    }

    @Test
    void validPosition() {
        Assertions.assertTrue(Position.validPosition(4,3));
    }

    @Test
    void invalidPosition() {
        assertFalse(Position.validPosition(5, 3));
    }

    @Test
    void invalidToValidPosition() {
        Rover rover = new Rover(2, 3, "W");
        assertFalse(Position.validPosition(2, 3));
        rover.moveRover();
        assertTrue(Position.validPosition(2, 3));
    }
}