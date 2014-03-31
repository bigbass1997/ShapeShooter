package tm.info.bigbass1997.shapeshooter.managers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawManager {
	
	private ShapeRenderer sr;
	
	public DrawManager(ShapeRenderer sr){
		this.sr = sr;
	}
	
	public void Rect(float x, float y, float width, float height){
		Rect(x, y, width, height, 0xFFFFFFFF);
	}
	public void Rect(float x, float y, float width, float height, int color){
		sr.setColor(new Color(color));
		sr.begin(ShapeType.Filled);
		sr.rect(x, y, width, height);
		sr.end();
	}
}