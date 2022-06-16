/*
 * 
 * This class initializes the player in the starting room and handles the players attributes
 * Additionally it keeps track of the players position
 * 
 * */

public class Player {

    static int playerXPos, playerYPos;
    static int lastTile = 0;
    static int currentRoom = 0;
    static int currentLevel = 0;
    static int maxHealth = 200;
    static int playerHealth = 200;
    static int playerStrength = 15;
    static int nextLevel = 100;
    static int level = 1;
    static boolean isDead = false;
    static boolean isAttacking = false;
    static boolean actionMade = false;

    void createPlayer() {
    	
        Room room = Level.levelsList.get(0).get(0);
        lastTile = room.sizes[room.width / 2][room.height / 2];
        playerXPos = room.width / 2;
        playerYPos = room.height / 2;
        room.sizes[playerXPos][playerYPos] = 47;
        room.visited = true;
    }

    // Go down
    void increaseY() {
    	
        nextStep(playerXPos, playerYPos + 1);
    }

    // Go up
    void decreaseY() {
    	
        nextStep(playerXPos, playerYPos - 1);
    }

    // Go right
    void increaseX() {
    	
        nextStep(playerXPos + 1, playerYPos);
    }

    // Go left
    void decreaseX() {
    	
        nextStep(playerXPos - 1, playerYPos);
    }

    private void nextStep(int stepX, int stepY) {

        Room room = Level.levelsList.get(currentLevel).get(currentRoom);

        if (room.sizes[stepX][stepY] == 20)
        	
            nextRoom(stepX, stepY);
        else if (room.sizes[stepX][stepY] == 29)
        	
            nextLevel();
        else if (room.sizes[stepX][stepY] == 30)
        	
            prevLevel();
        else if (room.sizes[stepX][stepY] < 70 || room.sizes[stepX][stepY] > 99) {

            room.sizes[playerXPos][playerYPos] = lastTile;
            lastTile = room.sizes[stepX][stepY];
            if (stepX == playerXPos - 1)
                room.sizes[stepX][stepY] = 44;
            if (stepX == playerXPos + 1)
                room.sizes[stepX][stepY] = 45;
            if (stepY == playerYPos - 1)
                room.sizes[stepX][stepY] = 46;
            if (stepY == playerYPos + 1)
                room.sizes[stepX][stepY] = 47;

            playerXPos = stepX;
            playerYPos = stepY; 
        	actionMade = true;
        } else if (room.sizes[stepX][stepY] >= 70 || room.sizes[stepX][stepY] <= 80) {
        	
            for (Enemy enemy : room.enemies_list) {
            	
                if (enemy.room.index == currentRoom) {
                	
                    if ((stepX) == enemy.enemyXPos && stepY == enemy.enemyYPos) {
                    	
                        Battle.playerAttack(enemy);
                        actionMade = true;
                    }
                }
            }
        }
    }

    private void nextRoom(int x, int y) {

        Room previousRoom = Level.levelsList.get(currentLevel).get(currentRoom);
        for (Door door : previousRoom.doors) {
        	
            if (door.x == x && door.y == y) {
            	
                previousRoom.sizes[playerXPos][playerYPos] = lastTile;
                int previousLocation = currentRoom;
                currentRoom = door.location;
                Room newRoom = Level.levelsList.get(currentLevel).get(currentRoom);
                if (previousLocation == currentRoom)
                	
                    Interface.newEvent("You are back in the same room");
                else if (newRoom.visited)
                	
                    Interface.newEvent("You were already here.");
                else
                	
                    Interface.newEvent("You have never been here.");
                	newRoom.visited = true;
                
                for (Door newdoor : Level.levelsList.get(currentLevel).get(currentRoom).doors) {
                	
                    if (newdoor.location == previousLocation) {
                    	
                        Room newroom = Level.levelsList.get(currentLevel).get(currentRoom);
                        lastTile = newroom.sizes[newdoor.positionX][newdoor.positionY];
                        if (newdoor.wall == 0)
                        	
                            newroom.sizes[newdoor.positionX][newdoor.positionY] = 47;
                        if (newdoor.wall == 1)
                        	
                            newroom.sizes[newdoor.positionX][newdoor.positionY] = 46;
                        if (newdoor.wall == 2)
                        	
                            newroom.sizes[newdoor.positionX][newdoor.positionY] = 44;
                        if (newdoor.wall == 3)
                        	
                            newroom.sizes[newdoor.positionX][newdoor.positionY] = 45;
	                        playerXPos = newdoor.positionX;
	                        playerYPos = newdoor.positionY;
                    }
                }
            }
        }
    }

    private void nextLevel() {
    	
        if (currentLevel < Level.levelNumber - 1) {
        	
            Level.levelsList.get(currentLevel).get(currentRoom).sizes[playerXPos][playerYPos] = lastTile;
            currentLevel += 1;
            currentRoom = 0;
            lastTile = 30;
            Room room = Level.levelsList.get(currentLevel).get(currentRoom);
            playerXPos = room.width / 2;
            playerYPos = room.height / 2;
            room.sizes[playerXPos][playerYPos] = 47;
            Interface.newEvent("You are now level " + (currentLevel + 1));
        } else
        	
            Interface.newEvent("Dead end.");
    }

    private void prevLevel() {
    	
        if (currentLevel > 0) {
        	
            Level.levelsList.get(currentLevel).get(currentRoom).sizes[playerXPos][playerYPos] = lastTile;
            currentLevel -= 1;
            currentRoom = Level.roomNumber - 1;
            lastTile = 29;
            Room room = Level.levelsList.get(currentLevel).get(currentRoom);
            playerXPos = room.width / 2;
            playerYPos = room.height / 2;
            room.sizes[playerXPos][playerYPos] = 47;
            Interface.newEvent("You have already been here.");
        } else
        	
            Interface.newEvent("You can't go back.");
    }

    static void modifyHealth(int points) {
    	
        playerHealth += points;
        if (playerHealth > maxHealth)
        	
            playerHealth = maxHealth;
        if (playerHealth <= 0) {
        	
            playerHealth = 0;
            System.out.println("Player died.");
            isDead = true;
        }
    }
}