package tm.info.bigbass1997.shapeshooter.entities.enemies;

public class ElementEnemy {
	
	public int type;
	public float x; //yPos not included as all enemies should deploy ABOVE the visable screen
	public int releaseTime; //Monitored in SECONDS from level start
	public boolean deployed;
	
	public ElementEnemy(int type, float x, int releaseTime){
		this.type = type;
		this.x = x;
		this.releaseTime = releaseTime;
		deployed = false;
	}
}
