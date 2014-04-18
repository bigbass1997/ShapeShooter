package tm.info.bigbass1997.shapeshooter.gamestates.levels;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.gamestates.GameState;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class LevelSelectState extends GameState {
	
	ArrayList<Button> buttons;
	ArrayList<Boolean> locked;
	
	public LevelSelectState(GameStateManager gsm) {
		super(gsm);
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button("Menu", 14, GraphicsMain.sHeight - 49, 80, 35, 3, 0x000000FF, 0xAAAAAAFF, 0xFFFFFFFF));

		float bx = 105, by = GraphicsMain.sHeight - 150, bwidth = 80, bheight = 80, buffer = 18;
		for(int r = 0; r < 5; r++){
			for(int c = 0; c < 5; c++){
				buttons.add(new Button("", bx + (c * bwidth) + (c * buffer), by - (r * bheight) - (r * buffer), bwidth, bheight, Button.DOUBLE));
			}
		}
		for(int i = 0; i < 25; i++){
			buttons.get(1 + i).setName(String.valueOf(1 + i));
		}
		buttons.add(new Button("Boss", 50, 30, 600, 110, Button.DOUBLE));
		buttons.add(new Button("Shop", GraphicsMain.sWidth - 92, GraphicsMain.sHeight - 49, 80, 35, 3, 0x000000FF, 0xAAAAAAff, 0xFFFFFFFF));
		
		locked = new ArrayList<Boolean>();
		for(int i = 0; i < 26; i++){
			locked.add(false);
		}
		locked.set(0, true);
	}

	@Override
	public void init() {

	}

	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			Button b = buttons.get(i);
			b.update(delta);
			
			if(b.getName().equals("Menu") && b.isPressed()) gsm.setState(gsm.MENUSTATE);
			if(b.getName().equals("Shop") && b.isPressed()) gsm.setState(gsm.UPGRADESTATE);
			if(b.getName().length() == 1 && b.isPressed() && locked.get(Integer.valueOf(b.getName()) - 1)) gsm.setState(Integer.valueOf(b.getName()) + 100);
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
		for(int i = 0; i < locked.size() - 1; i++){
			if(!locked.get(i)){
				dm.String("LOCKED", buttons.get(i + 1).getX() + 7, buttons.get(i + 1).getY() + 75, fm.fs3, 0xFF0000FF);
				dm.String("LOCKED", buttons.get(i + 1).getX() + 7, buttons.get(i + 1).getY() + 17, fm.fs3, 0xFF0000FF);
			}
		}
		int l = locked.size();
		if(!locked.get(l - 1)){
			dm.String("LOCKED", buttons.get(l).getX() + 50, buttons.get(l).getY() + 78, fm.fslarge1, 0xFF0000FF);
			dm.String("LOCKED", buttons.get(l).getX() + 395, buttons.get(l).getY() + 78, fm.fslarge1, 0xFF0000FF);
		}
	}

	@Override
	public void handleInput(float delta) {
		
	}

	@Override
	public void dispose() {
		System.out.println("LevelSelectState Disposing");
		sr.dispose();
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).dispose();
		}
	}
}
