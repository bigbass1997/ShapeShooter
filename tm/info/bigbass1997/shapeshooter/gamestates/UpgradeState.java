package tm.info.bigbass1997.shapeshooter.gamestates;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.FontManager;

public class UpgradeState extends GameState{
	
	private FontManager fm;
    private SpriteBatch batch;
	
	private ArrayList<Button> buttons;
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
		
		fm = new FontManager();
		batch = new SpriteBatch();
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button("Test Button", 5, GraphicsMain.sHeight - 200, 100, 40));
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update(delta);
			if(buttons.get(i).isPressed()){
				System.out.println("Button Pressed!");
			}
		}
		
		handleInput(delta);
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0xCC00FFFF);
		
		batch.setColor(new Color(0xFFFFFFFF));
		batch.begin();
		fm.fontstruction.draw(batch, "Money: " + um.money, 5, GraphicsMain.sHeight - 5);
		batch.end();

		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).draw(sr, dm);
		}
	}

	@Override
	public void handleInput(float delta) {
		if(GameKeys.isPressed(GameKeys.U)) gsm.returnToLastState();
	}

	@Override
	public void dispose() {
		
	}
}
