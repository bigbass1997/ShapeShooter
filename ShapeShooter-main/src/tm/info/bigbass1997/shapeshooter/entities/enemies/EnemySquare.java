package tm.info.bigbass1997.shapeshooter.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemySquare extends Enemy {

	public EnemySquare(TextureRegion texture, float y, float x) {
		super(texture, x, y);
		
		width = 32;
		height = 32;
		
		sprite = new Sprite(texture);
	}
}
