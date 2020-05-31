package model;

public class Player {

	private int health, money, mana, experience, level, skillPoints;
	private int strength, constitution, dexterity, intelligence, wisdom, charisma;
	private String name;
	private boolean isDead;
	PlayerLevels playerLevels;

	public Player(int strength, int constitution, int dexterity, int intelligence, int wisdom, int charisma,
			String name) {
		super();
		this.strength = strength;
		this.constitution = constitution;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.name = name;
		
		this.level = 1;
		this.health = this.constitution * 2;
		this.mana = this.intelligence * 2;
		this.experience = 0;
		this.money = this.charisma * 5;
		this.isDead = false;
		this.skillPoints = 30;
		
		playerLevels = new PlayerLevels(this);
	}
	
	public void levelUp() {
		this.level += 1;
		this.skillPoints += 2;
	}
	
	public void setIsDead(boolean value) {
		this.isDead = value;
	}

	public boolean checkIfDead() {
		return isDead;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		
		if (this.health <= 0) {
			this.health = 0;
			this.isDead = true;
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		String output = "";
		
		output += "Name: " + this.name + "\n";
		output += "Level: " + this.level + "\n";
		output += "Experience: " + this.experience + "/" + playerLevels.getMap().get(this.level) + "\n";
		output += "Health: " + this.health + "\n";
		output += "Mana: " + this.mana + "\n";
		output += "Strength: " + this.strength + "\n";
		output += "Dexterity: " + this.dexterity + "\n";
		output += "Constitution: " + this.constitution + "\n";
		output += "Intelligence: " + this.intelligence + "\n";
		output += "Wisdom: " + this.wisdom + "\n";
		output += "Charisma: " + this.charisma + "\n";
		output += "Money: " + this.money + "\n";
		output += "Skill Points: " + this.skillPoints + "\n";
		
		return output;
		
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}
	
}
