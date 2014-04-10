package tm.info.bigbass1997.shapeshooter.entities.enemies;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.entities.projectiles.Projectile;
import tm.info.bigbass1997.shapeshooter.entities.projectiles.ProjectileManager;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {
	
	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected float width;
	protected float height;

	protected float speed;
	
	protected boolean remove;
	
	private SpriteBatch batch;
	protected TextureRegion texture;
	protected Sprite sprite;
	
	protected Rectangle hitbox;
	
	//curHealth stands for Current Health
	protected float curHealth;
	protected float maxHealth;
	
	protected int reward;
	
	private GameStateManager gsm;
	
	public Enemy(TextureRegion texture, float x, float y, GameStateManager gsm){
		this.x = x;
		this.y = y;
		this.texture = texture;
		this.gsm = gsm;
		
		sprite = new Sprite(texture);
		
		batch = new SpriteBatch();
		
		remove = false;
	}
	
	public void draw(DrawManager dm){
		if(texture != null && sprite != null){
			batch.begin();
			sprite.draw(batch);
			batch.end();
		}
	}
	
	public void update(float delta, ProjectileManager pm){
		dx = 0;
		dy = speed;
		
		x += dx * delta;
		y += dy * delta;
		
		sprite.setPosition(x, y);
		hitbox.setPosition(x, y);
		
		/*System.out.println("x: " + x + " | y: " + y);
		System.out.println("x: " + sprite.getX() + " | y: " + sprite.getY());
		*/
		ArrayList<Projectile> projectiles = pm.getProjectiles();
		for(int i = 0; i < projectiles.size(); i++){
			if(projectiles.get(i).hitbox.overlaps(hitbox)){
				projectiles.get(i).remove = true;
				hit(projectiles.get(i).getDamage());
			}
		}
		
		if(y < -height){
			remove();
		}
	}
	
	public void hit(float damage){
		curHealth -= damage;
		if(curHealth <= 0.0f) killed();
	}
	
	public void remove(){
		remove = true;
	}
	
	private void killed(){
		remove();
		reward();
	}
	
	private void reward(){
		gsm.um.money += reward;
	}
}
