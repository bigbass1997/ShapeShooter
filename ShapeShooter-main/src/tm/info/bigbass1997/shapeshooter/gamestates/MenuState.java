package tm.info.bigbass1997.shapeshooter.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.SettingsManager;

public class MenuState extends GameState {
	
	ArrayList<Button> buttons;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);

		buttons = new ArrayList<Button>();
		buttons.add(new Button("Level Select", 45, 400, 200, 80, 3, 0x000000FF, 0xAAAAAAFF, 0xFFFFFFFF, Button.FULL));
		buttons.add(new Button("Upgrade Shop", 45, 300, 200, 80, 3, 0x000000FF, 0xAAAAAAFF, 0xFFFFFFFF, Button.FULL));
	}

	@Override
	public void init() {

	}

	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			Button b = buttons.get(i);
			b.update(delta);
			
			if(b.getName().equals("Level Select") && b.isPressed()) gsm.setState(gsm.LEVELSELECTSTATE);
			if(b.getName().equals("Upgrade Shop") && b.isPressed()) gsm.setState(gsm.UPGRADESTATE);
		}
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0x002255FF, ShapeType.Filled);
		
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).draw(sr, dm, fm);
		}
		
		String title = "Welcome to " + SettingsManager.title + "!";
		dm.String(title, (GraphicsMain.sWidth / 2) - (fm.fs4.getBounds(title).width / 2), GraphicsMain.sHeight - 100, fm.fs4, 0xFFFFFFDD);
		dm.String(SettingsManager.version + "", 5, GraphicsMain.sHeight - 5, fm.fs3, 0x00FFFFFF);
	}

	@Override
	public void handleInput(float delta) {

	}

	@Override
	public void dispose() {

	}

}
