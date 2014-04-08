package tm.info.bigbass1997.shapeshooter.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemySquare extends Enemy {

	public EnemySquare(TextureRegion texture, float x, float y) {
		super(texture, x, y);
		
		width = 32;
		height = 32;
		
		speed = -100.0f;
		
		sprite = new Sprite(texture);
	}
}
