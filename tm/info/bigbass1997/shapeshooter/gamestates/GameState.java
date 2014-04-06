package tm.info.bigbass1997.shapeshooter.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import tm.info.bigbass1997.shapeshooter.entities.projectiles.ProjectileManager;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.FontManager;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;

	protected FontManager fm;
	protected ShapeRenderer sr;
	protected DrawManager dm;
	
	protected ProjectileManager pm;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		
		sr = new ShapeRenderer();
		fm = new FontManager();
		dm = new DrawManager(sr, fm);

		pm = new ProjectileManager(gsm);
		
		init();
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void draw();
	public abstract void handleInput(float delta);
	public abstract void dispose();
	
}
