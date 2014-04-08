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
	
	private ArrayList<Enemy> enemies;
	private ArrayList<TextureRegion> regions;
	public final int SQUARE = 0; //SETS the ID for the type & the location, of REGIONS, for its TEXTURE//

	private GameStateManager gsm;
	
	public EnemyManager(GameStateManager gsm){
		this.gsm = gsm;
		
		spritesheet = new Texture(Gdx.files.internal("data/spritesheet.png"));
		
		int AREA = 32;
		int SIZE = 256;
		regions = new ArrayList<TextureRegion>(SIZE);
		for(int c = 0; c < Math.sqrt(SIZE); c++){
			for(int r = 0; r < Math.sqrt(SIZE); r++){
				regions.add(new TextureRegion(spritesheet, (c * AREA), (r * AREA), AREA, AREA));
			}
		}
		//regions.get(SQUARE).setRegion(regions.get(SQUARE).getRegionX(), regions.get(SQUARE).getRegionY(), AREA * 2, AREA);
		
		enemies = new ArrayList<Enemy>(100);
		////HOW TO ADD: enemies.add(new Enemy_TYPE_OF_ENEMY(X, Y, regions.get(TEST)));
	}
	
	public void deployEnemy(int type, float x, float y){
		if(type == SQUARE) enemies.add(new EnemySquare(regions.get(SQUARE), x, y));
		//else if(type == SOMETHING_ELSE) enemies.add(new EnemySOMETHING_ELSE(regions.get(SOMETHING_ELSE), x, y));
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
