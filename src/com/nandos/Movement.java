package com.nandos;

public class Movement {
    private int x;
    private int y;
    private Rotation heading;

    public Movement(int x, int y, String heading) {
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

    public static boolean validPosition(int x, int y){
        int xLength = Rover.upGrid.length;
        int yLength = Rover.upGrid[0].length;

        boolean inBounds = x >= 0 && x <= xLength - 1
                && y >= 0 && y <= yLength - 1;
        return inBounds && Rover.upGrid[x][y] == 0;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + heading;
    }
}
