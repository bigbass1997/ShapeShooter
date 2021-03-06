package tm.info.bigbass1997.shapeshooter.managers;

import java.io.IOException;
import java.util.ArrayList;

import tm.info.bigbass1997.shapeshooter.entities.enemies.ElementEnemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class SettingsManager {
	
	private XmlReader reader;
	
	public static String title;
	public static String version;

	public static ArrayList<Boolean> unlocked;
	
	public SettingsManager(){
		reader = new XmlReader();
		init();
	}
	
	public void init(){
		FileHandle file = Gdx.files.internal("data/xml/game.xml");
		Element root;
		try {
			root = reader.parse(file);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		title = root.getChildByName("title").getText();
		version = root.getChildByName("version").getText();

		unlocked = new ArrayList<Boolean>();
		for(int i = 0; i < 26; i++){
			unlocked.add(false);
		}
		unlocked.set(0, true);
	}
	
	public ArrayList<ElementEnemy> getLevelEnemies(String PATH){
		FileHandle file = Gdx.files.internal(PATH);
		Element root;
		try {
			root = reader.parse(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Array<Element> children = root.getChildrenByName("enemy");
		ArrayList<ElementEnemy> enemies = new ArrayList<ElementEnemy>(children.size);
		for(Element child : children){
			enemies.add(new ElementEnemy(Integer.parseInt(child.getAttribute("type")), Float.parseFloat(child.getChildByName("x").getText()), Integer.parseInt(child.getChildByName("releaseTime").getText())));
		}
		
		return enemies;
	}

	public static void unlockNextLevel(){
		int l = 0;
		for(int i = 0; i < unlocked.size(); i++){
			if(unlocked.get(i)) l = i;
			System.out.println("l: " + l);
		}
		unlocked.set(l + 1, true);
	}
}
