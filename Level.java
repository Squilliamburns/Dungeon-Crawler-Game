import java.util.ArrayList;

/*
 * 
 * This class handles the generation of the different levels and the rooms contained within them
 * 
 * */

public class Level {

    static int roomNumber = 10;
    static int levelNumber = 10;
    static ArrayList<ArrayList<Room>> levelsList = new ArrayList<>();
    private ArrayList<Room> roomsList;

    void newLevel() {
    	
        Interface.newEvent("");
        Interface.newEvent("You have entered a dungeon.");
        Interface.newEvent("Goodluck.");
        Interface.newEvent("");
        addLevels();
    }

    private void addLevels() {
    	
        for (int index = 0; index < levelNumber; index++) {
        	
            addRooms();
            levelsList.add(roomsList);
        }
    }

    private void addRooms() {
    	
        DungeonGenerator structure = new DungeonGenerator();
        
        structure.generate(roomNumber);
        roomsList = new ArrayList<>();
        
        for (int index = 0; index < roomNumber; index++) {
        	
            Room room = new Room(index);
            roomsList.add(room);
        }
    }
}