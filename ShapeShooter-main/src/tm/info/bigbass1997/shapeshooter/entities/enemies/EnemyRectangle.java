package tm.info.bigbass1997.shapeshooter.entities.enemies;

import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemyRectangle extends Enemy {

	public EnemyRectangle(TextureRegion texture, float x, float y, GameStateManager gsm, EnemyManager em) {
		super(texture, x, y, gsm, em);
		
		width = 64;
		height = 32;
		
		speed = -50.0f;
		
		hitbox = new Rectangle(x, y, width, height);
		
		maxHealth = 4.0f;
		curHealth = maxHealth;
		
		reward = 12;
	}
	
	@Override
	public void killed(EnemyManager em){
		em.deployEnemy(em.SQUARE, x - 16, y - 1, em);
		em.deployEnemy(em.SQUARE, x + 32, y, em);
		remove();
		reward();
	}
}
