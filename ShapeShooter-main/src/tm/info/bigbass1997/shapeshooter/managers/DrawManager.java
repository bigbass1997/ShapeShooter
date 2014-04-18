package tm.info.bigbass1997.shapeshooter.managers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawManager {
	
	private SpriteBatch batch = new SpriteBatch();
	private ShapeRenderer sr;
	
	public DrawManager(ShapeRenderer sr, FontManager fm){
		this.sr = sr;
	}
	
	public void Rect(float x, float y, float width, float height){
		Rect(x, y, width, height, 0xFFFFFFFF, ShapeType.Filled);
	}
	public void Rect(float x, float y, float width, float height, int color){
		Rect(x, y, width, height, color, ShapeType.Filled);
	}
	public void Rect(float x, float y, float width, float height, ShapeType type){
		Rect(x, y, width, height, 0xFFFFFFFF, type);
	}
	public void Rect(float x, float y, float width, float height, int color, ShapeType type){
		sr.setColor(new Color(color));
		sr.begin(type);
		sr.rect(x, y, width, height);
		sr.end();
	}
	public void String(String s, float x, float y, BitmapFont font){
		String(s, x, y, font, 0xFFFFFFFF);
	}
	public void String(String s, float x, float y, BitmapFont font, int color){
		font.setColor(new Color(0xFFFFFFFF));
		font.setColor(new Color(color));
		batch.begin();
		font.draw(batch, s, x, y);
		batch.end();
	}
}
