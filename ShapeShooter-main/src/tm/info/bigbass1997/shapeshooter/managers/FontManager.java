package tm.info.bigbass1997.shapeshooter.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontManager {
	
	public BitmapFont fs1 = new BitmapFont(Gdx.files.internal("data/The-First-FontStruction.fnt"),
			Gdx.files.internal("data/The-First-FontStruction_0.png"), false);
	public BitmapFont fs2 = new BitmapFont(Gdx.files.internal("data/The-First-FontStruction.fnt"),
			Gdx.files.internal("data/The-First-FontStruction_0.png"), false);
	public BitmapFont fs3 = new BitmapFont(Gdx.files.internal("data/The-First-FontStruction.fnt"),
			Gdx.files.internal("data/The-First-FontStruction_0.png"), false);
	public BitmapFont fs4 = new BitmapFont(Gdx.files.internal("data/The-First-FontStruction.fnt"),
			Gdx.files.internal("data/The-First-FontStruction_0.png"), false);

	public BitmapFont fslarge1 = new BitmapFont(Gdx.files.internal("data/The-First-FontStruction_large.fnt"),
			Gdx.files.internal("data/The-First-FontStruction_large_0.png"), false);
	
	public FontManager(){
		fs1.setScale(1.0f);
		fs2.setScale(0.5f);
		fs3.setScale(0.7f);
		fs4.setScale(1.0f, 2.0f);
		
		fslarge1.setScale(1.0f, 1.5f);
	}
}
