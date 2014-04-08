package tm.info.bigbass1997.shapeshooter.entities.enemies;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


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
	
	public Enemy(TextureRegion texture, float x, float y){
		this.x = x;
		this.y = y;
		this.texture = texture;
		
		batch = new SpriteBatch();
		
		remove = false;
	}

	public void draw(){
		if(texture != null && sprite != null){
			System.out.println("Drawing Enemy");
			batch.begin();
			sprite.draw(batch);
			batch.end();
		}
	}
	
	public void update(float delta){
		dx = 0;
		dy = speed;
		
		x += dx * delta;
		y += dy * delta;
		
		sprite.setPosition(x, y);

		System.out.println("x: " + x + " | y: " + y);
		System.out.println("x: " + sprite.getX() + " | y: " + sprite.getY());
		
		if(y < -height){
			remove = true;
		}
	}
}
