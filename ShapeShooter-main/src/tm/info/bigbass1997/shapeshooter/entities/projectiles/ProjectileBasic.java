package tm.info.bigbass1997.shapeshooter.entities.projectiles;

import com.badlogic.gdx.math.Rectangle;

public class ProjectileBasic extends Projectile{
	
	public ProjectileBasic(float x, float y){
		super(x, y);
		
		width = 8;
		height = 8;
		
		speed = 220;
		
		hitbox = new Rectangle(x, y, width, height);
		
		damage = 1.0f;
	}
}
