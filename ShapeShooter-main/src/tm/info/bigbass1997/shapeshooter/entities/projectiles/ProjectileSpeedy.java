package tm.info.bigbass1997.shapeshooter.entities.projectiles;

import com.badlogic.gdx.math.Rectangle;

public class ProjectileSpeedy extends Projectile{
	
	public ProjectileSpeedy(float x, float y){
		super(x, y);
		
		width = 3;
		height = 6;
		
		speed = 400;
		
		hitbox = new Rectangle(x, y, width, height);

		damage = 0.5f;
	}
}
