package tm.info.bigbass1997.shapeshooter.gamestates;

import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class PlayState extends GameState{
	
	protected PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update(float delta) {
		//Get User Input
		handleInput(delta);
		
		//Update Player
		player.update(delta);
		
		//Update ProjectileManager
		pm.update(delta);
	}

	@Override
	public void draw() {
		player.draw(sr);
		
		pm.draw(sr);
	}

	@Override
	public void handleInput(float delta) {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));

		if(GameKeys.isDown(GameKeys.SPACE)) pm.shoot();

		if(GameKeys.isPressed(GameKeys.U)) gsm.setState(gsm.UPGRADESTATE);
	}

	@Override
	public void dispose() {
		
	}
}
