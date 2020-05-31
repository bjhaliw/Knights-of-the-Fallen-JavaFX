package model;

import java.util.Random;

import controller.BattleController;
import controller.CreateEnemyController;

public class Driver {

	public static void main(String[] args) {
		Random random = new Random();

		
		int strength, dexterity, constitution, intelligence, wisdom, charisma;
		String name = "Brenton";
		
		strength = random.nextInt(10) + 10;
		dexterity  = random.nextInt(10) + 10;
		constitution = random.nextInt(10) + 10;
		intelligence = random.nextInt(10) + 10;
		wisdom = random.nextInt(10) + 10;
		charisma = random.nextInt(10) + 10;
		
		Player player = new Player(strength, constitution, dexterity, intelligence, wisdom, charisma, name);
		PlayerLevels playerLevels = new PlayerLevels(player);
		CreateEnemyController enemyCreate = new CreateEnemyController(player);
		Enemy enemy = enemyCreate.createEnemy();
		
		System.out.println(player.toString());
		
		System.out.println("Enemy:");
		System.out.println(enemy.toString());
		
		
		BattleController battleController = new BattleController(player, enemy, playerLevels);
		
		player.setExperience(100);
		while(player.checkIfDead() == false && enemy.checkIfDead() == false) {
			System.out.println(battleController.battle());
		}
		
		System.out.println();
		System.out.println(player.toString());

		
		//for (int i = 1; i < playerLevels.getMap().size(); i++) {
		//	System.out.println(playerLevels.getMap().get(i));
		//}

	}

}
