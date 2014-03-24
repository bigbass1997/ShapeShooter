package tm.info.bigbass1997.shapeshooter.entities.projectiles;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.entities.Player;
import tm.info.bigbass1997.shapeshooter.managers.UpgradesManager;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ProjectileManager {
	
	private int BASIC = 0;
	private int SPEEDY = 1;
	
	private final int kinds = 2;
	
	private Player player;
	private UpgradesManager um;
	
	private ArrayList<Float> nextShots;
	private ArrayList<Float> previousShots;
	private ArrayList<Float> delays; // Value: 10 = 1sec
	
	private ArrayList<Projectile> projectiles;
	
	public ProjectileManager(Player player, UpgradesManager um){
		nextShots = new ArrayList<Float>(kinds);
		previousShots = new ArrayList<Float>(kinds);
		delays = new ArrayList<Float>(kinds);
		projectiles = new ArrayList<Projectile>(100);
		
		float sysTime = (float) (System.nanoTime() / 1000000000L);
		
		//INIT NextShots
		nextShots.add(BASIC, sysTime);
		nextShots.add(SPEEDY, sysTime);
		
		//INIT PreviousShots
		previousShots.add(BASIC, sysTime);
		previousShots.add(SPEEDY, sysTime);
		
		//Delays
		delays.add(BASIC, 10.0f);
		delays.add(SPEEDY, 2.0f);
		
		//INHERIT Player
		this.player = player;
		
		//INHERIT UpgradesManager
		this.um = um;
	}
	
	public void shoot(){
		float sysTime = (int) (System.nanoTime() / 100000000L);
		
		//Update NextShots
		nextShots.set(BASIC, sysTime);
		nextShots.set(SPEEDY, sysTime);
		//Check for Shot\\
		
		if(um.getUnlocked().contains(um.BASIC_GUN)){
			//BASIC Check
			if(nextShots.get(BASIC) + 1 > previousShots.get(BASIC) + delays.get(BASIC)){
				projectiles.add(new ProjectileBasic(player.getX() + player.getXAxisCenter() - 4.0f, player.getY() + player.getHeight() - 4.0f));
				previousShots.set(BASIC, sysTime);
			}
		}

		if(um.getUnlocked().contains(um.SPEEDY_GUN)){
			//SPEEDY Check
			if(nextShots.get(BASIC) + 1 > previousShots.get(SPEEDY) + delays.get(SPEEDY)){
				projectiles.add(new ProjectileSpeedy(player.getX(), player.getY() + 6.0f));
				projectiles.add(new ProjectileSpeedy(player.getX() + player.getWidth() - 3.0f, player.getY() + player.getHeight() - 4.0f));
				previousShots.set(SPEEDY, sysTime);
			}
		}
		
		//OTHER2 Check
	}
	
	public void draw(ShapeRenderer sr){
		for(int i = 0; i < projectiles.size(); i++){
			//System.out.println("Drawing Projectile: " + projectiles.get(i) + " @ #" + i);
			projectiles.get(i).draw(sr);
		}
	}
	
	public void update(float delta){
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update(delta);
			
			if(projectiles.get(i).remove){
				projectiles.remove(i);
			}
		}
	}
}
