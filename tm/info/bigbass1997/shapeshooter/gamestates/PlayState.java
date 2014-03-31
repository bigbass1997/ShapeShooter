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
<<<<<<< HEAD
		gsm.player.update(delta);
		
		//Update ProjectileManager
		pm.update(delta);
		
		for(int i = 0; i < gsm.um.getUnlocked().size(); i++){
			System.out.println(gsm.um.getUnlocked().get(i));
		}
=======
		player.update(delta);
		
		//Update ProjectileManager
		pm.update(delta);
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
	}

	@Override
	public void draw() {
<<<<<<< HEAD
		gsm.player.draw(sr);
=======
		player.draw(sr);
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
		
		pm.draw(sr);
	}

	@Override
	public void handleInput(float delta) {
<<<<<<< HEAD
		gsm.player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		gsm.player.setRight(GameKeys.isDown(GameKeys.RIGHT));
=======
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106

		if(GameKeys.isDown(GameKeys.SPACE)) pm.shoot();

		if(GameKeys.isPressed(GameKeys.U)) gsm.setState(gsm.UPGRADESTATE);
	}

	@Override
	public void dispose() {
		
	}
}
