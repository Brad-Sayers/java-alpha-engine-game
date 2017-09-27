import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;

import java.awt.event.KeyEvent;

public class Level1 extends GameLevel
{
	@Override public void create()
	{
		GameObject hud = new GameObject("Hud",1920,1080,"Hud.png");
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		if (InputManager.isPressed(KeyEvent.VK_SPACE))
		{
			GameObject ClutchLight = new GameObject("ClutchLight",1920,1080,"ClutchLight.png");
		}
		if (InputManager.isReleased(KeyEvent.VK_SPACE))
		{
			ObjectManager.removeAllObjectsByName("ClutchLight");
		}
		if (InputManager.isPressed(KeyEvent.VK_W))
		{
			GameObject ThrottleLight = new GameObject("ThrottleLight",1920,1080,"ThrottleLight.png");
		}
		if (InputManager.isReleased(KeyEvent.VK_W))
		{
			ObjectManager.removeAllObjectsByName("ThrottleLight");
		}
		if (InputManager.isPressed(KeyEvent.VK_S))
		{
			GameObject BrakeLight = new GameObject("BrakeLight",1920,1080,"BrakeLight.png");
		}
		if (InputManager.isReleased(KeyEvent.VK_S))
		{
			ObjectManager.removeAllObjectsByName("BrakeLight");
		}

	}

	@Override public void uninitialize()
	{

	}
}
