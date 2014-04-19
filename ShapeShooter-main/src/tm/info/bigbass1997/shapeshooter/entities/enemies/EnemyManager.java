package tm.info.bigbass1997.shapeshooter.entities.enemies;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import tm.info.bigbass1997.shapeshooter.entities.projectiles.ProjectileManager;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class EnemyManager {
	private Texture spritesheet;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<TextureRegion> regions;
	public final int SQUARE = 0; //SETS the ID for the type & the location, of REGIONS, for its TEXTURE//
	public final int RECTANGLE = 1;
	public final int TRIANGLE = 2;

	private GameStateManager gsm;
	private DrawManager dm;
	
	public EnemyManager(GameStateManager gsm, DrawManager dm){
		this.gsm = gsm;
		this.dm = dm;
		
		spritesheet = new Texture(Gdx.files.internal("data/spritesheet.png"));
		
		int AREA = 32;
		int SIZE = 256;
		regions = new ArrayList<TextureRegion>(SIZE);
		regions.add(new TextureRegion(spritesheet, 0, 0, AREA, AREA));
		regions.add(new TextureRegion(spritesheet, 32, 0, AREA * 2, AREA));
		regions.add(new TextureRegion(spritesheet, 96, 0, AREA, AREA));
		//regions.get(SQUARE).setRegion(regions.get(SQUARE).getRegionX(), regions.get(SQUARE).getRegionY(), AREA * 2, AREA);
		
		enemies = new ArrayList<Enemy>(100);
		////HOW TO ADD: enemies.add(new Enemy_TYPE_OF_ENEMY(X, Y, regions.get(TEST)));
	}
	
	public void deployEnemy(int type, float x, float y, EnemyManager em){
		if(type == SQUARE) enemies.add(new EnemySquare(regions.get(SQUARE), x, y, gsm, em));
		if(type == RECTANGLE) enemies.add(new EnemyRectangle(regions.get(RECTANGLE), x, y, gsm, em));
		if(type == TRIANGLE) enemies.add(new EnemyTriangle(regions.get(TRIANGLE), x, y, gsm, em));
		
		//else if(type == SOMETHING_ELSE) enemies.add(new EnemySOMETHING_ELSE(regions.get(SOMETHING_ELSE), x, y));
	}
	
	public void draw(ShapeRenderer sr){
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i) != null){
				enemies.get(i).draw(dm);
			}
		}
	}
	
	public void update(float delta, ProjectileManager pm){
		for(int i = 0; i < enemies.size(); i++){
			Enemy enemy = enemies.get(i);
			if(enemy != null){
				enemy.update(delta, pm);
				
				if(enemy.remove){
					enemies.remove(i);
				}
			}
		}
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
}
