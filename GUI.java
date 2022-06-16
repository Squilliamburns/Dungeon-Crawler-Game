import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author William Burns
 *
 */

/*
 * 
 * This class initializes the game and the GUI and writes the console output to a .txt file
 * 
 * */

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        gameStart(primaryStage);
        primaryStage.setTitle("Dungeon Crawler");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void writeFile() throws IOException {
    	
    	java.io.File file = new java.io.File("game_log.txt");
		java.io.FileWriter gameLog = new java.io.FileWriter(file);
    	
    	try {

			gameLog.write(Interface.getMessage()[0]);
			System.out.println("Successfully wrote to the file.");
			
    	} catch (IOException e) {
    		
    		System.out.println("An error occurred.");
    		e.printStackTrace();
	    }
    	
    	if (Player.isDead == true) {
    		
    		gameLog.close();
    	}
    }
    
    private void gameStart(Stage primaryStage) throws Exception {
    
        Level level = new Level();
        level.newLevel();
        Player player = new Player();
        player.createPlayer();
        Controller assets = new Controller();
        assets.load();
        Scene scene = new Scene(assets.draw(), 450, 550);
        scene.getStylesheets().add("./stylesheet.css");
        new Movement(scene, assets, primaryStage);
        primaryStage.setScene(scene);   
    }
}