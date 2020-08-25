package com.nandos;

public enum Rotation {
    N, E, S, W;

    Rotation(){}
    public static Rotation[] rotation = values();

    public Rotation rotateRight() {
        return rotation[(ordinal() + 1) % rotation.length];
    }

    public Rotation rotateLeft() {
        return rotation[(ordinal() - 1 + rotation.length) % rotation.length];
    }

    public static boolean validRotation(String name) {
        for(Rotation item : rotation) {
            if(item.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
