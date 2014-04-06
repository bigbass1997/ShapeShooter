package tm.info.bigbass1997.shapeshooter.gamestates;

import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.GraphicsMain;
import tm.info.bigbass1997.shapeshooter.entities.Button;
import tm.info.bigbass1997.shapeshooter.managers.GameKeys;
import tm.info.bigbass1997.shapeshooter.managers.GameStateManager;

public class UpgradeState extends GameState{
	
	private ArrayList<Button> buttons;
	private String speedy_t1_button = "Speedy Bullets T1";
	private String player_speed_t1_button = "Player Speed T1";
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button(speedy_t1_button, 5, GraphicsMain.sHeight - 200, 200, 40, 0xCCCCCCFF, 0xFFFFFFFF));
		buttons.add(new Button(player_speed_t1_button, 210, GraphicsMain.sHeight - 200, 200, 40, 0xCCCCCCFF, 0xFFFFFFFF));
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update(float delta) {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update(delta);
			if(buttons.get(i).isPressed()){
				String name = buttons.get(i).getName();
				ArrayList<Integer> unlocked = gsm.um.getUnlocked();
				
				if(name.equals(speedy_t1_button) && !unlocked.contains(gsm.um.SPEEDY_GUN_T1) && gsm.um.COST_SPEEDY_GUN_T1 <= gsm.um.money){
					gsm.um.upgradeSpeedyGunT1();
				}
				if(name.equals(player_speed_t1_button) && !unlocked.contains(gsm.um.PLAYER_SPEED_T1) && gsm.um.COST_PLAYER_SPEED_T1 <= gsm.um.money){
					gsm.um.upgradePlayerSpeedT1();
				}
			}
		}
		
		/*for(int i = 0; i < gsm.um.getUnlocked().size(); i++){
			System.out.println(gsm.um.getUnlocked().get(i));
		}*/
		
		handleInput(delta);
	}

	@Override
	public void draw() {
		dm.Rect(0, 0, GraphicsMain.sWidth, GraphicsMain.sHeight, 0x444477FF);
		
		dm.String("$" + gsm.um.money, 5, GraphicsMain.sHeight - 5, fm.fs1);
		
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
