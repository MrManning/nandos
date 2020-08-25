package com.nandos;

public class Rover {
    public Position position;
    public static int[][] plateau;

    public Rover(int x, int y, String heading) {
        this.position = new Position(x, y, heading);
        plateau[x][y] = 1;
    }

    public void updateRover(char command) {
        if( Character.toUpperCase(command) == 'M' ) {
            moveRover();
        } else if( Character.toUpperCase(command) == 'L' ) {
            rotateRover(command);
        } else if( Character.toUpperCase(command) == 'R' ) {
            rotateRover(command);
        } else {
            throw new IllegalArgumentException("invalid move");
        }
    }

    public void moveRover() {
        switch( position.getHeading().name() ) {
            case "N":
                if( Position.validPosition(position.getX(), position.getY() + 1)) {
                    Rover.plateau[position.getX()][position.getY()] = 0;
                    position.setY(position.getY() + 1);
                    Rover.plateau[position.getX()][position.getY()] = 1;
                }
                break;
            case "E":
                if( Position.validPosition(position.getX() + 1, position.getY())) {
                    Rover.plateau[position.getX()][position.getY()] = 0;
                    position.setX(position.getX() + 1);
                    Rover.plateau[position.getX()][position.getY()] = 1;
                }
                break;
            case "S":
                if( Position.validPosition(position.getX(), position.getY() - 1)) {
                    Rover.plateau[position.getX()][position.getY()] = 0;
                    position.setY(position.getY() - 1);
                    Rover.plateau[position.getX()][position.getY()] = 1;
                }
                break;
            case "W":
                if( Position.validPosition(position.getX() - 1, position.getY())) {
                    Rover.plateau[position.getX()][position.getY()] = 0;
                    position.setX(position.getX() - 1);
                    Rover.plateau[position.getX()][position.getY()] = 1;
                }
                break;
            default: break;
        }


    }

    public void rotateRover(char direction) {
        Rotation updatedHeading;
        if( Character.toUpperCase(direction) == 'L' ) {
            updatedHeading = position.getHeading().rotateLeft();
        } else {
            updatedHeading = position.getHeading().rotateRight();
        }
        position.setHeading(updatedHeading);
    }
}
