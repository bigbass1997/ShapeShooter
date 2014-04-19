package tm.info.bigbass1997.shapeshooter.entities.enemies;

import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public class EnemyTriangle extends Enemy {

	public EnemyTriangle(TextureRegion texture, float x, float y, GameStateManager gsm, EnemyManager em) {
		super(texture, x, y, gsm, em);
		
		width = 32;
		height = 32;
		
		speed = -110.0f;
		
		float[] vertices;
		vertices = new float[]{
			x, y,
			x + width, y,
			x + (width / 2), y - height
		};
		
		hitbox = new Polygon(vertices).getBoundingRectangle();
		
		maxHealth = 3.0f;
		curHealth = maxHealth;
		
		reward = 10;
	}
}
