import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;

public class Level1 extends GameLevel
{
	@Override public void create()
	{
		GameObject lot = new GameObject("Parkinglot",1920,1085,"Parkinglot.png");
		GameObject hud = new GameObject("Hud",1920,1080,"Hud.png");
		GameObject car = new Player();
		ObjectManager.addGameObject(car);
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{

	}

	@Override public void uninitialize()
	{

	}
}
