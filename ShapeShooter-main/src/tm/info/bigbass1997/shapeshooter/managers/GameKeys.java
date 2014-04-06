package tm.info.bigbass1997.shapeshooter.managers;

import com.badlogic.gdx.Input.Buttons;

public class GameKeys {
	
	private static boolean[] keys;
	private static boolean[] pkeys;

	private static boolean[] mouses;
	private static boolean[] pmouses;
	
	private static final int NUM_KEYS = 4;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int SPACE = 2;
	public static final int U = 3;
	
	private static final int NUM_MOUSES = 1;
	public static final int MOUSELEFT = Buttons.LEFT;
	
	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
		
		mouses = new boolean[NUM_MOUSES];
		pmouses = new boolean[NUM_MOUSES];
	}
	
	public static void update(){
		for(int i = 0; i < NUM_KEYS; i++){
			pkeys[i] = keys[i];
		}
		
		for(int i = 0; i < NUM_MOUSES; i++){
			pmouses[i] = mouses[i];
		}
	}
	
	public static void setKey(int k, boolean b){
		keys[k] = b;
	}
	
	public static void setMouse(int button, boolean b){
		mouses[button] = b;
	}
	
	public static boolean isDown(int k){
		return keys[k];
	}

	public static boolean isPressed(int k){
		return keys[k] && !pkeys[k];
	}
	
	public static boolean isMouseDown(int b){
		return mouses[b];
	}
	
	public static boolean isMousePressed(int b){
		return mouses[b] && !pmouses[b];
	}
}