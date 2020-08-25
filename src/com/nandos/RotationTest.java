package com.nandos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationTest {
    Rotation currentRotation;

    @BeforeEach
    void init() {
        currentRotation = Rotation.N;
    }

    @Test
    void rotateRight() {
        Rotation currentRotation = Rotation.N;
        currentRotation = currentRotation.rotateRight();
        currentRotation = currentRotation.rotateRight();
        currentRotation = currentRotation.rotateRight();

        assertEquals(Rotation.W, currentRotation);
    }

    @Test
    void rotateLeft() {
        currentRotation = currentRotation.rotateLeft();
        currentRotation = currentRotation.rotateLeft();

        assertEquals(Rotation.S, currentRotation);
    }

    @Test
    void rotateBothDirections() {
        currentRotation = currentRotation.rotateRight();
        currentRotation = currentRotation.rotateRight();
        currentRotation = currentRotation.rotateLeft();
        currentRotation = currentRotation.rotateRight();
        currentRotation = currentRotation.rotateLeft();
        currentRotation = currentRotation.rotateLeft();

        assertEquals(Rotation.N, currentRotation);
    }
}