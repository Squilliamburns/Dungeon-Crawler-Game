/*
 * 
 * This class handles the enemies attributes and movement algorithm and health
 * Additionally contains the extended classes for the different varieties of enemies
 * 
 * */

public class Enemy {

    boolean isAttacked = false;
    String type = "";
    Room room;
    int enemyXPos, enemyYPos = 0;
    private int prevXPos, prevYPos;
    int enemyType;
    int enemyStrength;
    int enemyHealth;
    int lastTile;

    boolean isAlive() {
    	
        if (this.enemyHealth == 0) {
        	
            room.sizes[prevXPos][prevYPos] = lastTile;
            Interface.newEvent(type + " died.");
            return false;
        }
        if (isAttacked)
        	
            Controller.battle(this.enemyXPos, this.enemyYPos);
	        isAttacked = false;
	        return true;
    }

    void move() {

        prevXPos = enemyXPos;
        prevYPos = enemyYPos;
        room.sizes[enemyXPos][enemyYPos] = lastTile;

        if (Math.sqrt((enemyXPos - Player.playerXPos) * (enemyXPos - Player.playerXPos) + (enemyYPos - Player.playerYPos) * (enemyYPos - Player.playerYPos)) < 6) {
        	
            if (enemyXPos > Player.playerXPos) {
            	
                if (enemyYPos > Player.playerYPos) {
                	
                    enemyXPos--;
                    enemyYPos--;
                } else if (enemyYPos < Player.playerYPos) {
                	
                    enemyXPos--;
                    enemyYPos++;
                } else {
                	
                    enemyXPos--;
                }
            } else if (enemyXPos < Player.playerXPos) {
            	
                if (enemyYPos > Player.playerYPos) {
                	
                    enemyXPos++;
                    enemyYPos--;
                } else if (enemyYPos < Player.playerYPos) {
                	
                    enemyXPos++;
                    enemyYPos++;
                } else {
                	
                    enemyXPos++;
                }
            } else {
            	
                if (enemyYPos > Player.playerYPos) {
                	
                    enemyYPos--;
                } else if (enemyYPos < Player.playerYPos) {
                	
                    enemyYPos++;
                }
            }
        }

        if (room.sizes[enemyXPos][enemyYPos] >= 10 && room.sizes[enemyXPos][enemyYPos] < 20) {
        	
            lastTile = room.sizes[enemyXPos][enemyYPos];
            room.sizes[enemyXPos][enemyYPos] = enemyType;
        } else {
        	
            if (room.sizes[enemyXPos][enemyYPos] >= 44 && room.sizes[enemyXPos][enemyYPos] <= 47) {
            	
                Battle.enemyAttack(this);
            }
            enemyXPos = prevXPos;
            enemyYPos = prevYPos;
            room.sizes[enemyXPos][enemyYPos] = enemyType;
        }
    }
}

class Zombie extends Enemy {

    Zombie(Room room, int positionX, int positionY) {

        this.enemyXPos = positionX;
        this.enemyYPos = positionY;
        this.room = room;
        type = "Zombie";
        enemyType = 70;
        enemyHealth = 25;
        enemyStrength = 10;
        lastTile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 70;
    }
}

class Skeleton extends Enemy {

    Skeleton(Room room, int positionX, int positionY) {

        this.enemyXPos = positionX;
        this.enemyYPos = positionY;
        this.room = room;
        type = "Skeleton";
        enemyType = 71;
        enemyHealth = 25;
        enemyStrength = 10;
        lastTile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 71;
    }
}

class Minotaur extends Enemy {

    Minotaur(Room room, int positionX, int positionY) {

        this.enemyXPos = positionX;
        this.enemyYPos = positionY;
        this.room = room;
        type = "Minotaur";
        enemyType = 72;
        enemyHealth = 50;
        enemyStrength = 20;
        lastTile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 72;
    }
}

class Orc extends Enemy {

    Orc(Room room, int positionX, int positionY) {

        this.enemyXPos = positionX;
        this.enemyYPos = positionY;
        this.room = room;
        type = "Orc";
        enemyType = 73;
        enemyHealth = 5;
        enemyStrength = 5;
        lastTile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 73;
    }
}