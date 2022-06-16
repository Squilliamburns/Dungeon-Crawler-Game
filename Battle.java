import java.util.Random;

/*
 * 
 * This class handles the damage dealt to the player and the enemies and iterates the health points for the player
 * 
 * */

public class Battle {

    private static Random generator = new Random();

    static void enemyAttack(Enemy enemy) {

        int strength = generator.nextInt(enemy.enemyStrength + 5 * Player.currentLevel);
        int damage = strength;

        Interface.newEvent(enemy.type + " attacks for : " + damage);
        System.out.println(enemy.type + " attacks for : " + damage);
        Player.modifyHealth(-damage);
    }

    static void playerAttack(Enemy enemy) {

        enemy.isAttacked = true;
        int strength = generator.nextInt(Player.playerStrength);
        int damage = strength;
       
        Interface.newEvent("Player attacks for : " + damage);
        System.out.println("Player attacks for : " + damage);
        enemy.enemyHealth -= (damage);
        
        if (enemy.enemyHealth < 0)
            enemy.enemyHealth = 0;
    }
}