package com.nandos;

public class Movement {
    private int x;
    private int y;
    private Rotation heading;
    private int degrees;

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

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + heading;
    }
}
