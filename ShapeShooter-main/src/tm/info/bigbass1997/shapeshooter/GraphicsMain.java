package tm.info.bigbass1997.shapeshooter;

import tm.info.bigbass1997.shapeshooter.managers.GameInputProcessor;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.SettingsManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GraphicsMain implements ApplicationListener {
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private GameStateManager gsm;
	
	public static SettingsManager sm;
	
	public static float sWidth;
	public static float sHeight;
	
	public static final String title = "ShapeShooter";
	public static final String version = "build_33";
	
	@Override
	public void create() {
		sWidth = Gdx.graphics.getWidth();
		sHeight = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(sWidth, sHeight);
		camera.setToOrtho(false, sWidth, sHeight);
		batch = new SpriteBatch();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());

		sm = new SettingsManager();
		gsm = new GameStateManager();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		
		GameKeys.update();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
