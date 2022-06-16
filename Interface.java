import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/*
 * 
 * This class handles the displaying of the characters attributes
 * Displays messages to the player
 * 
 * */

public class Interface {

    private static String[] message = new String[5];

    public Interface(Pane root) {
    	
        statusBar(root);
        statusArea(root);
    }

    static void newEvent(String message) {
    	
        Interface.getMessage()[3] = Interface.getMessage()[2];
        Interface.getMessage()[2] = Interface.getMessage()[1];
        Interface.getMessage()[1] = Interface.getMessage()[0];
        Interface.getMessage()[0] = message;
    }

    private void statusBar(Pane root) {
    	
        Image icons = new Image("file:assets/gui/status_bar.png");
        Label statusBar = new Label("HP: " + Player.playerHealth + " / " + Player.maxHealth + "\nSTR: " + Player.playerStrength);
        
        statusBar.setGraphic(new ImageView(icons));
        statusBar.setAlignment(Pos.CENTER);
        statusBar.getStyleClass().add("status_bar");
        statusBar.setPadding(new Insets(20, 10, 20, 10));
        statusBar.setLayoutX(275);
        statusBar.setLayoutY(425);
        root.getChildren().add(statusBar);
    }

    private void statusArea(Pane root) {
    	
        Label statusArea = new Label(getMessage()[3] + "\n" + getMessage()[2] + "\n" + getMessage()[1] + "\n" + getMessage()[0]);
        
        statusArea.setAlignment(Pos.CENTER);
        statusArea.setPadding(new Insets(10, 0, 10, 0));
        statusArea.getStyleClass().add("status_area");
        statusArea.setLayoutX(50);
        statusArea.setLayoutY(425);
        root.getChildren().add(statusArea);
    }

	public static String[] getMessage() {
		
		return message;
	}

	public static void setMessage(String[] message) {
		
		Interface.message = message;
	}
}