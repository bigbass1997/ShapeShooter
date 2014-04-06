package tm.info.bigbass1997.shapeshooter.managers;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.entities.Player;

public class UpgradesManager {
	
	public final int BASIC_GUN_T1 = 0;
	public final int SPEEDY_GUN_T1 = 1;
	public final int PLAYER_SPEED_T1 = 2;
	
	public final int COST_BASIC_GUN_T1 = 0;
	public final int COST_SPEEDY_GUN_T1 = 500;
	public final int COST_PLAYER_SPEED_T1 = 200;
	
	private final int upgrades = 3;
	
	public int money;
	
	private ArrayList<Integer> unlocked;
	
	private Player player;
	
	public UpgradesManager(Player player){
		this.player = player;
		
		money = 700;
		
		unlocked = new ArrayList<Integer>(upgrades);
		
		unlocked.add(BASIC_GUN_T1);
	}
	
	public ArrayList<Integer> getUnlocked(){
		return unlocked;
	}
	
	public void upgradeSpeedyGunT1(){
		unlocked.add(SPEEDY_GUN_T1);
		money -= COST_SPEEDY_GUN_T1;
	}
	
	public void upgradePlayerSpeedT1(){
		unlocked.add(PLAYER_SPEED_T1);
		player.setSpeed(200.0f);
		money -= COST_PLAYER_SPEED_T1;
	}
}
