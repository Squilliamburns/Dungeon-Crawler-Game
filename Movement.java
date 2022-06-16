import javafx.scene.input.KeyCode;
import java.util.ListIterator;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * 
 * This class handles the user input for the player and the following enemy movementen
 * 
 * */

public class Movement {

    private Scene scene;
    private Controller assets;
    private Stage stage;

    Movement(Scene scene, Controller assets, Stage stage) {
    	
        this.scene = scene;
        this.assets = assets;
        this.stage = stage;
        keyHandler();
    }

    private void keyHandler() {
        Player player = new Player();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
            
                player.decreaseY();
                System.out.println("Key press detected: Move Up");
                scene.setRoot(assets.draw());
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.LEFT) {

                player.decreaseX();
                System.out.println("Key press detected: Move Left");
                scene.setRoot(assets.draw());
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.DOWN) {

                player.increaseY();
                System.out.println("Key press detected: Move Down");
                scene.setRoot(assets.draw());
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.RIGHT) {

                player.increaseX();
                System.out.println("Key press detected: Move Right");
                scene.setRoot(assets.draw());
                stage.setScene(scene);
            } 
            if (Player.actionMade) {
            	
                enemyMove();
                Player.actionMade = false;
                Player.isAttacking = false;
            }
        });
    }

    private void enemyMove() {
    	
        ListIterator<Enemy> iterator = Level.levelsList.get(Player.currentLevel).get(Player.currentRoom).enemies_list.listIterator();
        
        while (iterator.hasNext()) {
        	
            Enemy enemies = iterator.next();
            if (enemies.room.index == Player.currentRoom) {
            	
                enemies.move();
                if (!enemies.isAlive()) {
                	
                    iterator.remove();
                    scene.setRoot(assets.draw());
                    stage.setScene(scene);
                }
                
                scene.setRoot(assets.draw());
                stage.setScene(scene);
            }
        }
    }
}