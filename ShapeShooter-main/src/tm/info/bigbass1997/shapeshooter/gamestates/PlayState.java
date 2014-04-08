package tm.info.bigbass1997.shapeshooter.gamestates;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class PlayState extends GameState{
	
	protected PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		em.deployEnemy(em.SQUARE, 20, GraphicsMain.sHeight);
	}

	@Override
	public void update(float delta) {
		//Get User Input
		handleInput(delta);
		
		//Update Player
		gsm.player.update(delta);
		
		//Update ProjectileManager
		pm.update(delta);
		
		/*for(int i = 0; i < gsm.um.getUnlocked().size(); i++){
			System.out.println(gsm.um.getUnlocked().get(i));
		}*/
		
		em.update(delta);
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

	@Override
	public void dispose() {
		
	}
}
