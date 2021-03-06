package com.nandos.tests;

import com.nandos.Mars;
import com.nandos.Position;
import com.nandos.Rover;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionTest {
    @BeforeAll
    static void init() {
        Mars.plateau = new int[5][5];
    }

    @Test
    void validPosition() {
        assertTrue(Position.validPosition(4,3));
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