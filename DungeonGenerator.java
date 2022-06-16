import java.util.Random;

/*
 * 
 * This class generates the dungeon that the rooms and levels will be constrained to
 * 
 * */

public class DungeonGenerator {

    static boolean[][] dungeon;

    void generate(int vertex) {

        Random generator = new Random();
        dungeon = new boolean[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
        	
            for (int j = 0; j < vertex; j++) {
            	
                dungeon[j][i] = false;
                if (i > 0 && j > 0) {
                	
                    dungeon[i][i - 1] = true;
                    dungeon[j - 1][j] = true;
                }
            }
        }

        for (int i = 0; i < vertex; i++) {
        	
            if (i == 0 || i == (vertex - 1)) {
            	
                for (int index = 0; index < 2; index++) {
                	
                    if (generator.nextInt(2) == 0) {
                    	
                        int vertexFinal = generator.nextInt(vertex);
                        dungeon[i][vertexFinal] = true;
                        dungeon[vertexFinal][i] = true;
                    }
                }
            } else {
            	
                if (generator.nextInt(2) == 0) {
                	
                    int vertexFinal = generator.nextInt(vertex);
                    dungeon[i][vertexFinal] = true;
                    dungeon[vertexFinal][i] = true;
                }
            }
        }
    }
}