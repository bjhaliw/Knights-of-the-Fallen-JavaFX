package model;

public class Enemy {

	private int health, experience, mana, money;
	private int strength, dexterity, constitution, intelligence, charisma, wisdom;
	private String name;
	private boolean isDead;
	
	
	
	public Enemy(int health, int experience, int mana, int money, int strength, int dexterity, int constitution,
			int intelligence, int charisma, int wisdom, String name) {
		super();
		this.health = health;
		this.experience = experience;
		this.mana = mana;
		this.money = money;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.wisdom = wisdom;
		this.name = name;
		this.isDead = false;
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getmoney() {
		return money;
	}
	public void setmoney(int money) {
		this.money = money;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public String toString() {
		String output = "";
		
		output += "Name: " + this.name + "\n";
		output += "Experience: " + this.experience + "\n";
		output += "Health: " + this.health + "\n";
		output += "Mana: " + this.mana + "\n";
		output += "Strength: " + this.strength + "\n";
		output += "Dexterity: " + this.dexterity + "\n";
		output += "Constitution: " + this.constitution + "\n";
		output += "Intelligence: " + this.intelligence + "\n";
		output += "Wisdom: " + this.wisdom + "\n";
		output += "Charisma: " + this.charisma + "\n";
		output += "Money: " + this.money + "\n";
		
		
		return output;
	}


	public void setIsDead(boolean value) {
		this.isDead = value;
	}

	public boolean checkIfDead() {
		return isDead;
	}
	
	
}
