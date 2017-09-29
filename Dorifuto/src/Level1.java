import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;

public class Level1 extends GameLevel
{
	@Override public void create()
	{
		GameObject lot = new GameObject("Parkinglot",1920,1085,"Parkinglot.png");
		GameObject hud = new GameObject("Hud",302,1080,"Hud.png");
		hud.setPositionX(810);
		GameObject car = new Player();
		ObjectManager.addGameObject(car);

		hud.setRectangleCollider(165,540);
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		Graphics.setDrawCollisionData(true);
	}

	@Override public void uninitialize()
	{

	}
}
