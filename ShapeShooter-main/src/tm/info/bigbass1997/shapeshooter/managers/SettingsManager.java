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
	
	public SettingsManager(){
		reader = new XmlReader();
		
		/* Example of use...
		try {
			root = reader.parse(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		players = root.getChildrenByName("player");
		for(Element child : players){
			System.out.println(child.getAttribute("name") +  " | " + child.getChildByName("age").getText() + " | " + child.getChildByName("gender").getText());
		}*/
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
}
