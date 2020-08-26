package com.nandos;

public enum Rotation {
    N, E, S, W;

    Rotation(){}
    public static Rotation[] rotation = values();

    /**
     * Returns the rotation of the rover by using the current <code>enum</code> position and cycling through the enums ensuring that after reaching the start or end the next rotation would be the opposite end. For example, if <code>ordinal()</code> is 3 which is <code>W</code> after calling <code>rotateRight() ordinal()</code> will be 0 which is <code>N</code>
     *
     * @return the rovers new heading
     */
    public Rotation rotateRight() {
        return rotation[(ordinal() + 1) % rotation.length];
    }

    public Rotation rotateLeft() {
        return rotation[(ordinal() - 1 + rotation.length) % rotation.length];
    }

    /**
     * Returns a boolean value that if the <code>name</code> provided is not a valid <code>enum</code> then the rotation cannot be made.
     *
     * @param name the string to check against enums
     * @return     <code>true</code> if <code>name</code> is a valid <code>enum</code>
     */
    public static boolean validRotation(String name) {
        for(Rotation item : rotation) {
            if(item.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
