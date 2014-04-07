package tm.info.bigbass1997.shapeshooter.entities.enemies;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class EnemyManager {
	
	private SpriteBatch batch;
	
	private Texture spritesheet;
	private TextureRegion test;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<TextureRegion> regions;
	private final int TEST = 0;

	private GameStateManager gsm;
	
	public EnemyManager(GameStateManager gsm){
		this.gsm = gsm;
		
		spritesheet = new Texture(Gdx.files.internal("data/spritesheet.png"));
		
		int SIZE = 32;
		regions = new ArrayList<TextureRegion>(256);
		for(int c = 0; c < regions.size(); c++){
			for(int r = 0; r < regions.size(); r++){
				regions.add(new TextureRegion(spritesheet, (c * SIZE) + 1, (r * SIZE) + 1, SIZE, SIZE));
			}
		}
		
		enemies = new ArrayList<Enemy>(100);
		////HOW TO ADD: enemies.add(new Enemy_TYPE_OF_ENEMY(X, Y, regions.get(TEST)));
	}

	public void draw(ShapeRenderer sr){
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i) != null){
				enemies.get(i).draw();
			}
		}
	}
	
	public void update(float delta){
		for(int i = 0; i < enemies.size(); i++){
			Enemy enemy = enemies.get(i);
			if(enemy != null){
				enemy.update(delta);
				
				if(enemy.remove){
					enemies.remove(i);
				}
			}
		}
	}
}
