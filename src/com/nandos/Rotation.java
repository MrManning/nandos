package com.nandos;

public enum Rotation {
    N, E, S, W;

    Rotation(){}
    public Rotation[] rotation = values();

    public Rotation rotateRight() {
        return rotation[(ordinal() + 1) % rotation.length];
    }

    public Rotation rotateLeft() {
        return rotation[(ordinal() + 1) % rotation.length];
    }
}
