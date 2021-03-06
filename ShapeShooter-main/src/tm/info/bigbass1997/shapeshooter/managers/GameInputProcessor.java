package tm.info.bigbass1997.shapeshooter.managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter {
	
	public boolean keyDown(int k){
		if(k == Keys.LEFT) GameKeys.setKey(GameKeys.LEFT, true);
		if(k == Keys.RIGHT) GameKeys.setKey(GameKeys.RIGHT, true);
		if(k == Keys.SPACE) GameKeys.setKey(GameKeys.SPACE, true);
		if(k == Keys.U) GameKeys.setKey(GameKeys.U, true);
		return true;
	}

	public boolean keyUp(int k){
		if(k == Keys.LEFT) GameKeys.setKey(GameKeys.LEFT, false);
		if(k == Keys.RIGHT) GameKeys.setKey(GameKeys.RIGHT, false);
		if(k == Keys.SPACE) GameKeys.setKey(GameKeys.SPACE, false);
		if(k == Keys.U) GameKeys.setKey(GameKeys.U, false);
		return true;
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button){
		if(Gdx.input.isButtonPressed(button)) GameKeys.setMouse(GameKeys.MOUSELEFT, true);
		return true;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button){
		GameKeys.setMouse(GameKeys.MOUSELEFT, false);
		return true;
	}
}