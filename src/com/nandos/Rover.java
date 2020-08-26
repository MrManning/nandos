package com.nandos;

public class Rover {
    public Position position;
    public static int[][] plateau;

    public Rover(int x, int y, String heading) {
        this.position = new Position(x, y, heading);
        plateau[x][y] = 1;
    }

    /**
     * Registers the rovers next move and updates the grid if the command supplied is valid.
     *
     * @param command the instruction for the rover to execute, either Move, Rotate Right or Rotate Left.
     */
    public void updateRover(char command) {
        if( Character.toUpperCase(command) == 'M' ) {
            moveRover();
        } else if( Character.toUpperCase(command) == 'L' ) {
            rotateRover(command);
        } else if( Character.toUpperCase(command) == 'R' ) {
            rotateRover(command);
        } else {
            System.err.println("Error: Invalid move, rover not updated");
        }
    }

    /**
     * Moves the rover one grid point in the direction the rover is facing based on the <code>heading</code>. The grid is updated to keep track of where the rover is positioned.
     */
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

    /**
     * Sets the new rover direction <code>heading</code> after rotation either Left or Right to one of the four possible <code>Rotation</code> enum values <code>N</code>,<code>E</code>,<code>S</code>,<code>W</code>.
     *
     * @param direction the way the rover is to rotate.
     */
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
