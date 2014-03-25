package tm.info.bigbass1997.shapeshooter.entities;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Button {
	
	private String name;
	private float x, y, width, height;
	private int color;
	
	private boolean isPressed;
	
	public Button(String name, float x, float y, float width, float height){
		this(name, x, y, width, height, 0x000000FF);
	}

	public Button(String name, float x, float y, float width, float height, int color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		isPressed = false;
	}
	
	public void draw(ShapeRenderer sr, DrawManager dm){
		dm.Rect(x, y, width, height, color);
		
	}
	
	public void update(float delta){
		handleInput();
	}
	
	private void handleInput(){
		float mx = Gdx.input.getX();
		float my = -Gdx.input.getY() + GraphicsMain.sHeight;
		//System.out.println("mx: " + mx + " | my: " + my);
		
		if(GameKeys.isMousePressed(GameKeys.MOUSELEFT) && isTouching(mx, my)){
			isPressed = true;
		}else{
			isPressed = false;
		}
	}
	
	private boolean isTouching(float mx, float my){
		return (mx >= x && mx <= x + width && my >= y && my <= y + height);
	}
	
	public float getX(){ return x;}
	public float getY(){ return y;}
	public float getWidth(){ return width;}
	public float getHeight(){ return height;}
	
	public boolean isPressed(){ return isPressed;}
}
