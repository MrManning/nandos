package com.nandos;

public class Position {
    private int x;
    private int y;
    private Rotation heading;

    public Position(int x, int y, String heading) {
        this.x = x;
        this.y = y;
        this.heading = Rotation.valueOf(heading.trim().toUpperCase());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rotation getHeading() {
        return heading;
    }

    public void setHeading(Rotation heading) {
        this.heading = heading;
    }

    /**
     * @param x coordinate for the x axis
     * @param y coordinate for the y axis
     * @return <code>true</code> if the coordinates are within the plateau and don't collide with another rover.
     */
    public static boolean validPosition(int x, int y){
        int xLength = Rover.plateau.length;
        int yLength = Rover.plateau[0].length;

        boolean inBounds = x >= 0 && x <= xLength - 1
                && y >= 0 && y <= yLength - 1;
        return inBounds && Rover.plateau[x][y] == 0;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + heading;
    }
}
