package tm.info.bigbass1997.shapeshooter.entities.enemies;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Enemy {
	
	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;

	protected float speed;
	
	protected float lifeTime;
	protected float lifeTimer;
	
	protected boolean remove;
	
	protected TextureRegion texture;
	
	public Enemy(float x, float y, TextureRegion texture){
		this.x = x;
		this.y = y;

		remove = false;
		
		lifeTime = 10.0f;
		lifeTimer = 0.0f;
		
		texture = null;
	}

	public void draw(){
		
	}
	
	public void update(float delta){
		dx = 0;
		dy = speed;
		
		x += dx * delta;
		y += dy * delta;
		
		lifeTimer += delta;
		if(lifeTimer > lifeTime){
			remove = true;
		}
	}
}
