package tm.info.bigbass1997.shapeshooter.managers;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.entities.Player;

public class UpgradesManager {
	
	public final int BASIC_GUN = 0;
	public final int SPEEDY_GUN = 1;
	
	public final int PLAYER_SPEED_1 = 100;
	
	private final int upgrades = 3;
	
	public int money;
	
	private ArrayList<Integer> unlocked;
	
	private Player player;
	
	public UpgradesManager(Player player){
		this.player = player;
		
		money = 0;
		
		unlocked = new ArrayList<Integer>(upgrades);
		
		unlocked.add(BASIC_GUN);
	}
	
	public ArrayList<Integer> getUnlocked(){
		return unlocked;
	}
	
	public void addSpeedyGun(){
		unlocked.add(SPEEDY_GUN);
	}
	
	public void upgradePlayerSpeed1(){
		unlocked.add(PLAYER_SPEED_1);
		player.setSpeed(200.0f);
	}
}
