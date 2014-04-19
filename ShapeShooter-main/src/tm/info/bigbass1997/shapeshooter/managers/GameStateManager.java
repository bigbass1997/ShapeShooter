package tm.info.bigbass1997.shapeshooter.managers;

import tm.info.bigbass1997.shapeshooter.entities.Player;
import tm.info.bigbass1997.shapeshooter.gamestates.*;
import tm.info.bigbass1997.shapeshooter.gamestates.levels.Level1State;
import tm.info.bigbass1997.shapeshooter.gamestates.levels.Level2State;
import tm.info.bigbass1997.shapeshooter.gamestates.levels.LevelSelectState;

public class GameStateManager {
	
	private GameState gameState;
	private GameState lastGameState;
	
	public UpgradesManager um;
	public Player player;
	
	private int currentState;
	private int lastState;
	
	public final int MENUSTATE = 0;
	public final int LEVELSELECTSTATE = 1;
	public final int UPGRADESTATE = 2;

	public final int 
			LEVEL1STATE = 101, LEVEL2STATE = 102,LEVEL3STATE = 103, LEVEL4STATE = 104, LEVEL5STATE = 105,
			LEVEL6STATE = 106, LEVEL7STATE = 107, LEVEL8STATE = 108, LEVEL9STATE = 109, LEVEL10STATE = 110;
	
	public GameStateManager(){
		setState(LEVELSELECTSTATE);
		lastState = 0;
		
		player = new Player();
		um = new UpgradesManager(player);
	}
	
	public void setState(int state){
		if(gameState != null){
			System.out.println("GSM gameState Disposing");
			gameState.dispose();
		}
		lastState = currentState;
		lastGameState = gameState;
		if(state == MENUSTATE){
			gameState = new MenuState(this);
		}
		if(state == LEVEL1STATE){
			gameState = new Level1State(this);
		}
		if(state == LEVEL2STATE){
			gameState = new Level2State(this);
		}
		if(state == LEVELSELECTSTATE){
			gameState = new LevelSelectState(this);
		}
		if(state == UPGRADESTATE){
			gameState = new UpgradeState(this);
		}
		currentState = state;
		
		/*System.out.println("LastGameState: " + lastGameState);
		System.out.println("LastState Set: " + lastState);
		System.out.println("CurrentState Set: " + currentState);*/
	}
	
	public int getCurrentState(){
		return currentState;
	}
	
	public int getLastState(){
		return lastState;
	}
	
	public void returnToLastState(){
		gameState.dispose();
		gameState = lastGameState;
	}
	
	public void update(float delta){
		gameState.update(delta);
	}
	
	public void draw(){
		gameState.draw();
	}
}
