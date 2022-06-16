/*
 * 
 * This class handles the placement of doors in each room
 * 
 * */

public class Door {

    int x, y, positionX, positionY, location, wall;

    Door(int doorFrom, int doorLocation, int wall, int placeDoor, int height, int width) {

        this.location = doorLocation;
        this.wall = wall;

        // North
        if (wall == 0) {
        	
            x = placeDoor;
            y = 0;
            positionX = x;
            positionY = y + 1;
        }
        // South
        if (wall == 1) {
        	
            x = placeDoor;
            y = height - 1;
            positionX = x;
            positionY = y - 1;
        }
        // East
        if (wall == 2) {
        	
            x = width - 1;
            y = placeDoor;
            positionX = x - 1;
            positionY = y;
        }
        // West
        if (wall == 3) {
        	
            x = 0;
            y = placeDoor;
            positionX = x + 1;
            positionY = y;
        }
    }
}