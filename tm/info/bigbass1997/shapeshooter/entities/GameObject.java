package tm.info.bigbass1997.shapeshooter.entities;

import java.awt.Point;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameObject {
	
	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected float speed;
	
	protected float width;
	protected float height;
	
	protected float[] shapex;
	protected float[] shapey;
	
	protected void update(float delta){}
	protected void draw(ShapeRenderer sr){}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getXAxisCenter(){
		return width / 2;
	}
	
	public float getYAxisCenter(){
		return height / 2;
	}
	
	public Point getCenter(){
		return new Point((int) getXAxisCenter(), (int) getYAxisCenter());
	}
}
