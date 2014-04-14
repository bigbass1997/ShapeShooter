package tm.info.bigbass1997.shapeshooter.gamestates;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class Level1State extends PlayState{
	
	public Level1State(GameStateManager gsm){
		super(gsm);
		
		enemiesToDeploy = GraphicsMain.sm.getLevelEnemies("data/xml/level_1.xml");
	}
}
