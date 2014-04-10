package tm.info.bigbass1997.shapeshooter.entities.projectiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {
	
	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected float speed;
	
	protected float lifeTime;
	protected float lifeTimer;
	
	public boolean remove;
	
	protected int width;
	protected int height;
	
	public Rectangle hitbox;
	
	protected float damage;
	
	public Projectile(float x, float y){
		this.x = x;
		this.y = y;
		
		remove = false;
		
		lifeTime = 10.0f;
		lifeTimer = 0.0f;
	}

	public void draw(ShapeRenderer sr){
		sr.setColor(new Color(0xFFFFFFFF));
		
		sr.begin(ShapeType.Filled);
		sr.rect(x, y, width, height);
		sr.end();
	}
	
	public void update(float delta){
		dx = 0;
		dy = speed;
		
		x += dx * delta;
		y += dy * delta;
		
		hitbox.setPosition(x, y);
		
		lifeTimer += delta;
		if(lifeTimer > lifeTime){
			remove = true;
		}
	}
	
	public float getDamage(){
		return damage;
	}
}
