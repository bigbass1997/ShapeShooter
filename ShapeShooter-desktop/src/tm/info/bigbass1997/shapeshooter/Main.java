package tm.info.bigbass1997.shapeshooter;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ShapeShooter";
		cfg.width = 700;
		cfg.height = 700;
		
		new LwjglApplication(new GraphicsMain(), cfg);
	}
}
