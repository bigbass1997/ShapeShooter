package tm.info.bigbass1997.shapeshooter.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

<<<<<<< HEAD
import tm.info.bigbass1997.shapeshooter.GraphicsMain;
=======
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
import tm.info.bigbass1997.shapeshooter.entities.Player;
import tm.info.bigbass1997.shapeshooter.entities.projectiles.ProjectileManager;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.UpgradesManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
<<<<<<< HEAD
=======
	protected Player player;
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106

	protected ShapeRenderer sr;
	protected DrawManager dm;
	
	protected ProjectileManager pm;
<<<<<<< HEAD
=======
	protected UpgradesManager um;
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		
<<<<<<< HEAD
		sr = new ShapeRenderer();
		dm = new DrawManager(sr);
		
		pm = new ProjectileManager(gsm);
=======
		player = new Player();
		
		sr = new ShapeRenderer();
		dm = new DrawManager(sr);
		
		um = new UpgradesManager(player);
		pm = new ProjectileManager(player, um);
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
		
		init();
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void draw();
	public abstract void handleInput(float delta);
	public abstract void dispose();
	
}
