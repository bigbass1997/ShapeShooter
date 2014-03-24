package tm.info.bigbass1997.shapeshooter.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class UpgradeState extends GameState{

    private SpriteBatch batch;
	private BitmapFont font;
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
		
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/The-First-Fontstruction.fnt"),
				Gdx.files.internal("data/The-First-FontStruction_0.png"), false);
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update(float delta) {
		handleInput(delta);
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0xCC00FFFF);
		
		batch.setColor(new Color(0xFFFFFFFF));
		batch.begin();
		font.draw(batch, "Hello World!", 5, 100);
		batch.end();
	}

	@Override
	public void handleInput(float delta) {
		if(GameKeys.isPressed(GameKeys.U)) gsm.returnToLastState();
	}

	@Override
	public void dispose() {
		
	}
}
