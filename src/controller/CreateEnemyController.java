package controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import model.Enemy;
import model.Player;
import model.Werewolf;

public class CreateEnemyController {

	private Player player;
	private static final int WEREWOLF = 1;
	private static final int IMP = 2;
	private static final int MUGGER = 3;
	private static final int WITCH = 4;
	Random randomGen;
	
	public CreateEnemyController(Player player) {
		this.player = player;
		randomGen = new Random();
	}
	
	public Enemy createEnemy() {
		Enemy enemy = null;
		int randomGold, randomExperience, randomHealth;
		int randomStrength, randomDexterity, randomConstitution;
		int randomMana, randomIntelligence, charisma, wisdom;
		int randomEnemyType;
		
		randomGold = generateRandomGold();
		randomExperience = generateRandomExperience();
		randomHealth = generateRandomHealth();
		randomStrength = generateRandomStrength();
		randomDexterity = generateRandomDexterity();
		randomConstitution = generateRandomConstitution();
		randomIntelligence = generateRandomIntelligence();
		randomMana = generateRandomMana();
		randomEnemyType = generateRandomEnemyType();
		charisma = generateRandomCharisma();
		wisdom = generateRandomWisdom();
		
		enemy = new Enemy(randomHealth, randomExperience, randomMana, randomGold, randomStrength, randomDexterity, randomConstitution, randomIntelligence, charisma, wisdom, "Bob");
	
		return enemy;
	}
	
	private int generateRandomWisdom() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		
		int value = this.player.getWisdom() + random;

		if (value < 0) {
			value = 1;
		}
		
		return value;
		
	}
	
	
	private int generateRandomCharisma() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		
		int value = this.player.getCharisma() + random;

		if (value < 0) {
			value = 1;
		}
		
		return value;
		
	}
	
	private int generateRandomGold() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		
		int value = this.player.getCharisma() + random;

		if (value < 0) {
			value = 1;
		}
		
		return value;
	}
	
	private int generateRandomExperience() {
		int random = ThreadLocalRandom.current().nextInt(1, 12 + 1);
		int experience = 0;
		
		experience = player.getLevel() + random;
		
		return experience;
	}
	
	private int generateRandomHealth() {
		int random = this.randomGen.nextInt(15);
		int health = 0;
		
		health = player.getConstitution() * player.getLevel() + random;
		
		return health;
	}
	
	private int generateRandomStrength() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		int strength = 0;
		
		strength = player.getStrength() + random;
		
		if (strength < 0) {
			strength = 1;
		}
		
		return strength;
	}
	
	private int generateRandomIntelligence() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		int intelligence = 0;
		
		intelligence = player.getLevel() + random;
		
		if (intelligence < 0) {
			intelligence = 1;
		}
		
		return intelligence;
	}
	
	private int generateRandomConstitution() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		int constitution = 0;
		
		constitution = player.getConstitution() + random;
		
		if (constitution < 0) {
			constitution = 1;
		}
		
		return constitution;
	}
	
	private int generateRandomDexterity() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		int dexterity= 0;
		
		dexterity = player.getDexterity() + random; 
		
		if (dexterity < 0) {
			dexterity = 1;
		}
		
		return dexterity;
	}
	
	private int generateRandomMana() {
		int random = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
		int mana = 0;
		
		mana = player.getIntelligence() + random;
		
		if (mana < 0) {
			mana = 1;
		}
		
		return mana;
	}
	
	private int generateRandomEnemyType() {
		int random = this.randomGen.nextInt(100);;
		int enemyType = 0;
		
		if (random <= 33) {
			enemyType = WEREWOLF;
		} else if (random > 33 && random <= 66) {
			enemyType = IMP;
		} else {
			enemyType = MUGGER;
		}
		
		return enemyType;
	}
}
