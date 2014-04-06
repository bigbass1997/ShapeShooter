package tm.info.bigbass1997.shapeshooter.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;

public class Player extends GameObject {
	
	private boolean left;
	private boolean right;
	
	public Player(){
		
		x = (GraphicsMain.sWidth / 2) - (width / 2);
		y = height + 50;
		width = 25;
		height = 25;
		
		speed = 100.0f;
		
		shapex = new float[4];
		shapey = new float[4];
	}
	
	private void setShape() {
		shapex[0] = x;
		shapey[0] = y;
		
		shapex[1] = x + width;
		shapey[1] = y;
		
		shapex[2] = x + width;
		shapey[2] = y + height;
		
		shapex[3] = x;
		shapey[3] = y + height;
	}
	
	public void setLeft(boolean b){left = b;}
	public void setRight(boolean b){right = b;}
	
	@Override
	public void update(float delta){
		if(left && (x > 0)){
			x -= speed * delta;
		}else if(right && ((x + width) < GraphicsMain.sWidth)){
			x += speed * delta;
		}
		
		//Set Shape
		setShape();
	}
	
	@Override
	public void draw(ShapeRenderer sr){
		sr.setColor(new Color(0xFFFFFFFF));
		
		sr.begin(ShapeType.Line);
		
		for(int i = 0, j = shapex.length - 1; i < shapex.length; j = i++){
			sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
		}
		
		sr.end();
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
}
