package tm.info.bigbass1997.shapeshooter.entities.enemies;

import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemySquare extends Enemy {

	public EnemySquare(TextureRegion texture, float x, float y, GameStateManager gsm, EnemyManager em) {
		super(texture, x, y, gsm, em);
		
		width = 32;
		height = 32;
		
		speed = -70.0f;
		
		hitbox = new Rectangle(x, y, width, height);
		
		maxHealth = 2.0f;
		curHealth = maxHealth;
		
		reward = 10;
	}
}
