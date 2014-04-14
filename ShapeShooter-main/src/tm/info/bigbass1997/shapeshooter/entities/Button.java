package tm.info.bigbass1997.shapeshooter.entities;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.managers.DrawManager;
import tm.info.bigbass1997.shapeshooter.managers.FontManager;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Button {
	
	private String name;
	private float x, y, width, height;
	private float buffer;
	private int backcolor, bordcolor, tcolor;
	private int size;
	
	public static final int FULL = 1, HALF = 2, DEFAULT = 3, DOUBLE = 4;
	
	private boolean isPressed, isHovering;

	public Button(String name, float x, float y, float width, float height){
		this(name, x, y, width, height, 2, 0x000000FF, 0xFFFFFFFF, 0xFFFFFFFF, DEFAULT);
	}
	public Button(String name, float x, float y, float width, float height, float buffer){
		this(name, x, y, width, height, buffer, 0x000000FF, 0xFFFFFFFF, 0xFFFFFFFF, DEFAULT);
	}
	public Button(String name, float x, float y, float width, float height, int size){
		this(name, x, y, width, height, 2, 0x000000FF, 0xFFFFFFFF, 0xFFFFFFFF, size);
	}
	public Button(String name, float x, float y, float width, float height, float buffer, int size){
		this(name, x, y, width, height, buffer, 0x000000FF, 0xFFFFFFFF, 0xFFFFFFFF, size);
	}
	public Button(String name, float x, float y, float width, float height, float buffer, int backcolor, int bordcolor, int tcolor){
		this(name, x, y, width, height, buffer, 0x000000FF, 0xFFFFFFFF, 0xFFFFFFFF, DEFAULT);
	}
	public Button(String name, float x, float y, float width, float height, float buffer, int backcolor, int bordcolor, int tcolor, int size){
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.buffer = buffer;
		this.backcolor = backcolor;
		this.bordcolor = bordcolor;
		this.tcolor = tcolor;
		this.size = size;
		isPressed = false;
		isHovering = false;
	}
	
	public void draw(ShapeRenderer sr, DrawManager dm, FontManager fm){
		dm.Rect(x, y, width, height, backcolor);
		
		if(isHovering) dm.Rect(x, y, width, height, 0xDDDDDDFF);
		
		for(int i = 0; i < buffer; i++){
			dm.Rect(x + i, y + i, width - (i * 2), height - (i * 2), bordcolor, ShapeType.Line);
		}
		
		SpriteBatch batch = new SpriteBatch();
		batch.setColor(tcolor);
		batch.begin();
		if(size == FULL) fm.fs1.draw(batch, name, x + (width / 2) - (fm.fs1.getBounds(name).width / 2), y + (height / 2) + (fm.fs1.getBounds(name).height / 2));
		if(size == HALF) fm.fs2.draw(batch, name, x + (width / 2) - (fm.fs2.getBounds(name).width / 2), y + (height / 2) + (fm.fs2.getBounds(name).height / 2));
		if(size == DEFAULT) fm.fs3.draw(batch, name, x + (width / 2) - (fm.fs3.getBounds(name).width / 2), y + (height / 2) + (fm.fs3.getBounds(name).height / 2));
		if(size == DOUBLE) fm.fs4.draw(batch, name, x + (width / 2) - (fm.fs4.getBounds(name).width / 2), y + (height / 2) + (fm.fs4.getBounds(name).height / 2));
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
		
		if(isTouching(mx, my)){
			isHovering = true;
		}else{
			isHovering = false;
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
	
	public void setName(String name){ this.name = name;}
}
