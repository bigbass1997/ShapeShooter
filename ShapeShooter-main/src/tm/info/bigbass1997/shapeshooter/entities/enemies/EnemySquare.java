package tm.info.bigbass1997.shapeshooter.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemySquare extends Enemy {

	public EnemySquare(TextureRegion texture, float x, float y) {
		super(texture, x, y);
		
		width = 16;
		height = 16;
		
		speed = -100.0f;
		
		sprite = new Sprite(texture);
		
		hitbox = new Rectangle(x, y, width, height);
	}
}
