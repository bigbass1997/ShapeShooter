package tm.info.bigbass1997.shapeshooter.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;
import tm.info.bigbass1997.shapeshooter.managers.FontManager;
<<<<<<< HEAD
=======
import tm.info.bigbass1997.shapeshooter.managers.UpgradesManager;
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106

public class UpgradeState extends GameState{
	
	private FontManager fm;
    private SpriteBatch batch;
	
	private ArrayList<Button> buttons;
	private String speedy_t1_button = "Speedy Bullets T1";
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
		
		fm = new FontManager();
		batch = new SpriteBatch();
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button("Speedy Bullets T1", 5, GraphicsMain.sHeight - 200, 200, 40, 0xCCCCCCFF, 0xFFFFFFFF));
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update(delta);
			if(buttons.get(i).isPressed()){
<<<<<<< HEAD
				if(buttons.get(i).getName().equals(speedy_t1_button) && !gsm.um.getUnlocked().contains(gsm.um.SPEEDY_GUN)){
					System.out.println("Button Pressed");
					gsm.um.addSpeedyGun();
=======
				if(buttons.get(i).getName().equals(speedy_t1_button) && !um.getUnlocked().contains(um.SPEEDY_GUN)){
					System.out.println("Button Pressed");
					um.addSpeedyGun();
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
				}
			}
		}
		
<<<<<<< HEAD
		for(int i = 0; i < gsm.um.getUnlocked().size(); i++){
			System.out.println(gsm.um.getUnlocked().get(i));
		}
		
=======
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
		handleInput(delta);
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0x444477FF);
		
		batch.setColor(new Color(0xFFFFFFFF));
		batch.begin();
<<<<<<< HEAD
		fm.fs1.draw(batch, "Money: " + gsm.um.money, 5, GraphicsMain.sHeight - 5);
=======
		fm.fs1.draw(batch, "Money: " + um.money, 5, GraphicsMain.sHeight - 5);
>>>>>>> 4f6b723350d3e781488dfbdac2c61291c3eed106
		batch.end();

		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).draw(sr, dm, fm);
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
