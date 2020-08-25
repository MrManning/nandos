package com.nandos;

public class Rover {
    public Movement position;
    public static int[][] upGrid;

    public Rover(int x, int y, String heading) {
        this.position = new Movement(x, y, heading);
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
        int x = position.getX();
        int y = position.getY();

        switch( position.getHeading().name() ) {
            case "N":
                if( Movement.validPosition(x, y + 1)) {
                    Rover.upGrid[x][y] = 0;
                    position.setY(y + 1);
                    Rover.upGrid[x][y] = 1;
                }
                break;
            case "E":
                if( Movement.validPosition(x + 1, y) ) {
                    Rover.upGrid[x][y] = 0;
                    position.setX(x + 1);
                    Rover.upGrid[x][y] = 1;
                }
                break;
            case "S":
                if( Movement.validPosition(x, y - 1) ) {
                    Rover.upGrid[x][y] = 0;
                    position.setY(y - 1);
                    Rover.upGrid[x][y] = 1;
                }
                break;
            case "W":
                if( Movement.validPosition(x - 1, y) ) {
                    Rover.upGrid[x][y] = 0;
                    position.setX(x - 1);
                    Rover.upGrid[x][y] = 1;
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
