package controller;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.Enemy;
import model.Player;
import model.PlayerLevels;

public class BattleController {

	PlayerLevels levels;
	Player player;
	Enemy enemy;
	Random randomGen;
	
	public BattleController(Player player, Enemy enemy, PlayerLevels levels) {
		this.player = player;
		this.enemy = enemy;
		this.levels = levels;
		this.randomGen = new Random();
	}
	
	public String battle() {
		String output = "";
		Scanner scanner = new Scanner(System.in);
		int selection = Integer.MAX_VALUE;
		
		//output += "You encounter an enemy!\n";
		System.out.println("You encounter an enemy!");
		
		while(this.player.checkIfDead() == false && this.enemy.checkIfDead() == false && selection != 4) {
			//output += "1. Standard Attack\n2. Magic\n3. Items\n4. Run";
			System.out.println("Player Health: " + player.getHealth() + " Enemy Health: " + enemy.getHealth());
			System.out.println("1. Standard Attack\n2. Magic\n3. Items\n4. Run");
			System.out.print("Enter Selection: ");
			
			try {
				selection = scanner.nextInt();
				switch(selection) {
				case 1:
					//output += playerStandardAttack();

					System.out.println(playerStandardAttack());
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Numbers only");
			}
			
			System.out.println();
		}
		
		
		scanner.close();
		return output;
		
	}
	
	public String playerStandardAttack() {
		String output = "";
		int damage = 0;
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		
		if (player.checkIfDead() == true) {
			System.out.println("You are already dead");
			return output;
		}
		
		if (enemy.checkIfDead() == true) {
			System.out.println("The enemy is already dead");
			return output;
		}
		
		output += "You swing your axe at the enemy.\n";
		damage = player.getStrength() + random;
		
		if (damage < 0) {
			damage = 0;
		}
		
		output += "You deal " + damage + " damage.\n";
		enemy.setHealth(enemy.getHealth() - damage);
		
		if (enemy.checkIfDead() == true) {
			output += "You have slain the enemy!\n";
			output += enemySlain();
		} else {
			
			output += enemyStandardAttack();
		}
		
		return output;
	}
	
	public String enemyStandardAttack() {
		String output = "";
		int damage = 0;
		int random = randomGen.nextInt(101);
		
		if ((random + enemy.getDexterity() <= 25)) {
			output += "The werewolf swipes you with its claws!\n";
		} else if ((random + enemy.getDexterity()) > 25 && (random + enemy.getDexterity()) <= 50) {
			output += "The werewolf charges towards you and grasps you in its jaws!\n";
		} else if ((random + enemy.getDexterity()) > 50 && (random + enemy.getDexterity()) <= 75) {
			output += "The werewolf lets out an ear piercing howl!\n";
		} else {
			output += "The werewolf grapples with you and throws you into a nearby tree!\n";
		}
		
		damage = enemy.getStrength() + ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		
		if (damage < 0) {
			damage = 0;
		}
		
		output += "You have been dealt " + damage + " damage!\n";
		player.setHealth(player.getHealth() - damage);
		
		if (player.getHealth() <= 0) {
			output += "The enemy has bested you, and you have died.\n";
		}
		
		return output;
	}
	
	public String playerSlain() {
		String output = "";
		
		return output;
	}
	
	public String enemySlain() {
		String output = "";
		int playerXp = this.player.getExperience() + this.enemy.getExperience();
		int playerMoney = this.player.getMoney() + this.enemy.getmoney();
		
		output += "You have been awarded " + this.enemy.getExperience() + " experience points\n";
		this.player.setExperience(playerXp);	
		output += this.levels.checkIfLevelUp();
		
		this.player.setMoney(playerMoney);
		output += "You found " + this.enemy.getmoney() + " gold pieces.\n";
		
		return output;
	}
	

}
