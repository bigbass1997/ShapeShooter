package tm.info.bigbass1997.shapeshooter.gamestates.levels;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.gamestates.PlayState;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class Level2State extends PlayState{
	
	public Level2State(GameStateManager gsm){
		super(gsm);
		
		enemiesToDeploy = GraphicsMain.sm.getLevelEnemies("data/xml/level_2.xml");
	}
}
