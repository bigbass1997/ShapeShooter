package tm.info.bigbass1997.shapeshooter.entities;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.FontManager;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Button {
	
	private String name;
	private float x, y, width, height;
	private int color;
	
	private boolean isPressed;
	
	public Button(String name, float x, float y, float width, float height){
		this(name, x, y, width, height, 0x000000FF, 0xFFFFFFFF);
	}

	public Button(String name, float x, float y, float width, float height, int bcolor, int tcolor){
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = bcolor;
		isPressed = false;
	}
	
	public void draw(ShapeRenderer sr, DrawManager dm, FontManager fm){
		dm.Rect(x, y, width, height, color);
		
		SpriteBatch batch = new SpriteBatch();
		batch.setColor(0xFFFFFFFF);
		batch.begin();
		fm.fs3.draw(batch, name, x + (width / 2) - (fm.fs3.getBounds(name).width / 2), y + (height / 2) + (fm.fs3.getBounds(name).height / 2));
		batch.end();
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
	
	public String getName(){ return name;}
	public float getX(){ return x;}
	public float getY(){ return y;}
	public float getWidth(){ return width;}
	public float getHeight(){ return height;}
	
	public boolean isPressed(){ return isPressed;}
}
