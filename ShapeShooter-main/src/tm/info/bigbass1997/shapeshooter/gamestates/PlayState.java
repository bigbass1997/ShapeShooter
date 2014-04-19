package tm.info.bigbass1997.shapeshooter.gamestates;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.enemies.ElementEnemy;
import tm.info.bigbass1997.shapeshooter.gamestates.levels.LevelSelectState;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class PlayState extends GameState{
	
	protected ArrayList<ElementEnemy> enemiesToDeploy;
	
	public int sysTime;
	public int gameTime;
	
	private int startTime;
	
	protected PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		//Example of how to "deploy" an enemy.
		//em.deployEnemy(em.RECTANGLE, 20, GraphicsMain.sHeight, em);
		
		gameTime = 0;
		startTime = (int) ((System.nanoTime() / 1000000000));
	}

	@Override
	public void update(float delta) {
		sysTime = (int) ((System.nanoTime() / 1000000000));
		gameTime = sysTime - startTime;
		
		//Get User Input
		handleInput(delta);
		
		//Update Player
		gsm.player.update(delta);
		
		//Update ProjectileManager
		pm.update(delta);
		
		/*for(int i = 0; i < gsm.um.getUnlocked().size(); i++){
			System.out.println(gsm.um.getUnlocked().get(i));
		}*/
		
		em.update(delta, pm);
		
		if(enemiesToDeploy != null){
			for(int i = 0; i < enemiesToDeploy.size(); i++){
				ElementEnemy enemy = enemiesToDeploy.get(i);
				if(gameTime >= enemy.releaseTime && !enemy.deployed){
					em.deployEnemy(enemy.type, enemy.x, GraphicsMain.sHeight + 50.0f, em);
					enemy.deployed = true;
				}
				
				if(enemiesToDeploy.get(i).deployed) enemiesToDeploy.remove(i);
			}
		}
		
		if(enemiesToDeploy.isEmpty() && em.getEnemies().isEmpty()){
			gsm.setState(gsm.LEVELSELECTSTATE);
			LevelSelectState.unlockNextLevel();
		}
	}

	@Override
	public void draw() {
		gsm.player.draw(sr);
		
		pm.draw(sr);
		
		dm.String("$" + gsm.um.money, 5, GraphicsMain.sHeight - 5, fm.fs1);
		
		em.draw(sr);
	}

	@Override
	public void handleInput(float delta) {
		gsm.player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		gsm.player.setRight(GameKeys.isDown(GameKeys.RIGHT));

		if(GameKeys.isDown(GameKeys.SPACE)) pm.shoot();

		if(GameKeys.isPressed(GameKeys.U)) gsm.setState(gsm.UPGRADESTATE);
	}
}
