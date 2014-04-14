package tm.info.bigbass1997.shapeshooter.gamestates.levels;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.gamestates.GameState;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class LevelSelectState extends GameState {
	
	ArrayList<Button> buttons;
	
	public LevelSelectState(GameStateManager gsm) {
		super(gsm);
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button("Back", 14, GraphicsMain.sHeight - 49, 80, 35, 3, 0x000000FF, 0xAAAAAAFF, 0xFFFFFFFF));

		float bx = 105, by = GraphicsMain.sHeight - 150, bwidth = 80, bheight = 80, buffer = 18;
		for(int r = 0; r < 5; r++){
			for(int c = 0; c < 5; c++){
				buttons.add(new Button("", bx + (c * bwidth) + (c * buffer), by - (r * bheight) - (r * buffer), bwidth, bheight, Button.FULL));
			}
		}
		for(int i = 0; i < 25; i++){
			buttons.get(1 + i).setName(String.valueOf(1 + i));
		}
		
		buttons.add(new Button("Boss", 50, 30, 600, 110, Button.DOUBLE));
	}

	@Override
	public void init() {

	}

	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			Button b = buttons.get(i);
			b.update(delta);
			
			if(b.getName().equals("Back") && b.isPressed()) gsm.setState(gsm.MENUSTATE);
		}
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0x002255FF, ShapeType.Filled);
		
		int buf = 10;
		for(int b = 1; b <= 3; b++){
			dm.Rect(buf + b, buf + b, GraphicsMain.sWidth - ((buf * 2) + (b * 2)), GraphicsMain.sHeight - ((buf * 2) + (b * 2)), 0xEEEEEEFF, ShapeType.Line);
		}
		
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).draw(sr, dm, fm);
		}
	}

	@Override
	public void handleInput(float delta) {
		
	}

	@Override
	public void dispose() {
		
	}
}
