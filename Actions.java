import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/*
 * 
 * This class handles the death of the player and displays the death image in the GUI
 * 
 * */

public class Actions {

    Actions(Pane root) {
    	
        death(root);
    }

    private void death(Pane root) {

        if (Player.isDead) {
        	
            Image deathScreen = new Image("file:assets/gui/dead_screen.png");
            ImageView imageView = new ImageView();
            imageView.setFitHeight(Controller.tileSize * 11);
            imageView.setFitWidth(Controller.tileSize * 11);
            imageView.setImage(deathScreen);
            imageView.setX(50);
            imageView.setY(50);
            root.getChildren().add(imageView);
        }
    }
}
