package model;

import java.util.HashMap;

public class PlayerLevels {

	HashMap<Integer, Integer> map;
	Player player;
	
	public PlayerLevels(Player player) {
		this.player = player;
		this.map = createHashMap();
	}
	
	public String checkIfLevelUp() {
		boolean levelUp = false;
		String output = "";
		int i = this.player.getLevel(), counter = 0;
		int playerXp = this.player.getExperience();
	

		for (; i <= map.size() - 1; i++) {
			if (playerXp >= map.get(i)) {
				this.player.levelUp();
				playerXp -= map.get(i);
				levelUp = true;
				counter++;			
			} 
		}
		
		if (playerXp < 0) {
			playerXp = 0;
		}
		
		this.player.setExperience(playerXp);
		
		if (levelUp == true) {
			output += "You have leveled up! You went up " + counter + " total levels and are now level " + this.player.getLevel() + ".\n";
		}
		
		return output;
	}
	

	public HashMap<Integer, Integer> createHashMap() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int xp = 10;
		
		for (int i = 0; i <= 100; i++) {
			map.put(i + 1, xp);
			xp +=  4 *(i + 1);
		}
		
		return map;
	}
	
	public HashMap<Integer, Integer> getMap() {
		return this.map;
	}
	
}
