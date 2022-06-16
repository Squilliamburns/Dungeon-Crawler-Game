import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import java.util.Objects;

/*
 * 
 * This class acts as the controller for the entire game and loads the images files for display in the GUI
 * 
 * */

public class Controller {

    private Image woodenDoors, stairsDown, stairsUp;
    private Image wallBlock, columnBlock, bookShelf;
    private Image floorBlock, grass, woodenFloor;
    private Image playerLeft, playerRight, playerUp, playerDown;
    private Image enemyZombie, enemySkeleton, enemyMinotaur, enemyOrc;
    
    static final int tileSize = 32;

    void load() throws Exception {

        wallBlock = new Image("file:assets/wall/brick.png");
        columnBlock = new Image("file:assets/wall/column.png");
        bookShelf = new Image("file:assets/wall/bookshelf.png");
        floorBlock = new Image("file:assets/floor/floor_block.png");
        woodenFloor = new Image("file:assets/floor/wood_floor.png");
        grass = new Image("file:assets/floor/grass.png");
        woodenDoors = new Image("file:assets/action/doors.png");
        stairsDown = new Image("file:assets/action/stair_down.png");
        stairsUp = new Image("file:assets/action/stair_up.png");
        playerLeft = new Image("file:assets/player/player_l.png");
        playerRight = new Image("file:assets/player/player_r.png");
        playerUp = new Image("file:assets/player/player_u.png");
        playerDown = new Image("file:assets/player/player_d.png");
        enemyZombie = new Image("file:assets/enemy/zombie.png");
        enemySkeleton = new Image("file:assets/enemy/skeleton.png");
        enemyMinotaur = new Image("file:assets/enemy/minotaur.png");
        enemyOrc = new Image("file:assets/enemy/orc.png");
    }

    Pane draw() {

        Pane root = new Pane();
        Room room = Level.levelsList.get(Player.currentLevel).get(Player.currentRoom);

        int xBegin, yBegin, xEnd, yEnd;
        xBegin = Player.playerXPos - 5;
        yBegin = Player.playerYPos - 5;
        xEnd = Player.playerXPos + 6;
        yEnd = Player.playerYPos + 6;
        
        if (Player.playerXPos < 5) {
        	
            xBegin = 0;
            xEnd += (5 - Player.playerXPos);
        }
        if (Player.playerYPos < 5) {
        	
            yBegin = 0;
            yEnd += (5 - Player.playerYPos);
        }
        if (Player.playerXPos > (room.width - 6)) {
        	
            xEnd = room.width;
            xBegin += (room.width - Player.playerXPos - 6);
        }
        if (Player.playerYPos > (room.height - 6)) {
        	
            yEnd = room.height;
            yBegin += (room.height - Player.playerYPos - 6);
        }

        for (int xTile = xBegin, xIndex = 0; xTile < xEnd; xTile++, xIndex++) {
        	
            for (int yTile = yBegin, yIndex = 0; yTile < yEnd; yTile++, yIndex++) {
            	
                ImageView imageView = new ImageView();
                imageView.setFitHeight(tileSize);
                imageView.setFitWidth(tileSize);

                // Wall tiles
                if (room.sizes[xTile][yTile] >= 80 && room.sizes[xTile][yTile] <= 99) {
                	
                    if (room.sizes[xTile][yTile] == 81)
                        imageView.setImage(bookShelf);
                    if (room.sizes[xTile][yTile] == 87)
                        imageView.setImage(columnBlock);
                    if (room.sizes[xTile][yTile] == 88)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 89)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 90)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 91)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 92)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 93)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 94)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 95)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 96)
                        imageView.setImage(wallBlock);
                    if (room.sizes[xTile][yTile] == 97)
                        imageView.setImage(wallBlock);
                    
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                }
                // Floor tiles
                if (room.sizes[xTile][yTile] >= 10 && room.sizes[xTile][yTile] < 20) {
                	
                    if (room.sizes[xTile][yTile] == 10)
                        imageView.setImage(floorBlock);
                    if (room.sizes[xTile][yTile] == 11)
                        imageView.setImage(floorBlock);
                    if (room.sizes[xTile][yTile] == 12)
                        imageView.setImage(floorBlock);
                    if (room.sizes[xTile][yTile] == 13)
                        imageView.setImage(floorBlock);
                    if (room.sizes[xTile][yTile] == 14)
                        imageView.setImage(woodenFloor);
                    if (room.sizes[xTile][yTile] == 15)
                        imageView.setImage(grass);
                    if (room.sizes[xTile][yTile] == 16)
                        imageView.setImage(grass);
                    if (room.sizes[xTile][yTile] == 17)
                        imageView.setImage(grass);
                    
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                }
                // Door tiles
                if (room.sizes[xTile][yTile] >= 20 && room.sizes[xTile][yTile] <= 30) {
                	
                    if (room.sizes[xTile][yTile] == 20)
                        imageView.setImage(woodenDoors);
                    if (room.sizes[xTile][yTile] == 25)
                        imageView.setImage(woodenFloor);
                    if (room.sizes[xTile][yTile] == 29)
                        imageView.setImage(stairsDown);
                    if (room.sizes[xTile][yTile] == 30)
                        imageView.setImage(stairsUp);
                    
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                }
                
                // Character tiles
                if (room.sizes[xTile][yTile] >= 44 && room.sizes[xTile][yTile] <= 47) {
                	
                    imageView = new ImageView();
                    imageView.setImage(background(Player.lastTile, "character"));
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                    imageView = new ImageView();
                    imageView.setFitHeight(tileSize);
                    imageView.setFitWidth(tileSize);
                    if (room.sizes[xTile][yTile] == 44)
                        imageView.setImage(playerLeft);
                    if (room.sizes[xTile][yTile] == 45)
                        imageView.setImage(playerRight);
                    if (room.sizes[xTile][yTile] == 46)
                        imageView.setImage(playerUp);
                    if (room.sizes[xTile][yTile] == 47)
                        imageView.setImage(playerDown);
                    
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                }
                // Enemy Tiles
                if (room.sizes[xTile][yTile] >= 70 && room.sizes[xTile][yTile] < 80) {
                	
                    imageView = new ImageView();
                    imageView.setImage(background(checkEnemyTile(xTile, yTile, room.index), "enemy"));
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                    imageView = new ImageView();
                    imageView.setFitHeight(tileSize);
                    imageView.setFitWidth(tileSize);
                    if (room.sizes[xTile][yTile] == 70)
                        imageView.setImage(enemyZombie);
                    if (room.sizes[xTile][yTile] == 71)
                        imageView.setImage(enemySkeleton);
                    if (room.sizes[xTile][yTile] == 72)
                        imageView.setImage(enemyMinotaur);
                    if (room.sizes[xTile][yTile] == 73)
                        imageView.setImage(enemyOrc);
                    
                    imageView.setX(xIndex * tileSize + 50);
                    imageView.setY(yIndex * tileSize + 50);
                    root.getChildren().add(imageView);
                }
            }
        }
        ImageView imageView = new ImageView();
        imageView.setFitHeight(tileSize * 11);
        imageView.setFitWidth(tileSize * 11);
        imageView.setX(50);
        imageView.setY(50);
        root.getChildren().add(imageView);

        new Interface(root);
        new Actions(root);
        return root;
    }

    private int checkEnemyTile(int posX, int posY, int index) {
    	
        int lastTile = 0;
        for (Enemy enemy : Level.levelsList.get(Player.currentLevel).get(index).enemies_list) {
        	
            if (enemy.room.index == index) {
            	
                if (posX == enemy.enemyXPos && posY == enemy.enemyYPos)
                    lastTile = enemy.lastTile;
            }
        }
        return lastTile;
    }

    static void battle(int posX, int posY) {
   
        Player.isAttacking = true;
    }

    private Image background(int lastTile, String type) {
    	
        if (lastTile == 10)
            return floorBlock;
        if (lastTile == 11)
            return floorBlock;
        if (lastTile == 12)
            return floorBlock;
        if (lastTile == 13)
            return floorBlock;
        if (lastTile == 14)
            return woodenFloor;
        if (lastTile == 15) {
        	
            if (Objects.equals(type, "character")) {
            	
                Player.lastTile = 16;
                return grass;
            } else if (Objects.equals(type, "enemy"))
                return grass;
        }
        if (lastTile == 16)
            return grass;
        if (lastTile == 17)
            return grass;
        if (lastTile == 29)
            return stairsDown;
        if (lastTile == 30)
            return stairsUp;
        else
            return floorBlock;
    }
}