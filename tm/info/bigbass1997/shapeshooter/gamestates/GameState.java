package tm.info.bigbass1997.shapeshooter.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Player;
import tm.info.bigbass1997.shapeshooter.entities.projectiles.ProjectileManager;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.UpgradesManager;

public abstract class GameState {
	
	protected GameStateManager gsm;

	protected ShapeRenderer sr;
	protected DrawManager dm;
	
	protected ProjectileManager pm;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		
		sr = new ShapeRenderer();
		dm = new DrawManager(sr);
		
		pm = new ProjectileManager(gsm);
		
		init();
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void draw();
	public abstract void handleInput(float delta);
	public abstract void dispose();
	
}
