import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

import java.awt.event.KeyEvent;

public class Player extends GameObject
{
	public Player()
	{
		super("ae86", 200, 110, "ae86.png");
		setPositionX(-828);
	}

	public Vec2 direction = new Vec2(1.0f,0.0f);
	int pauseCount = 0;
	@Override public void update(float v)
	{
		float movementSpeed = 3.0f;
		float rotationSpeed = 1.0f;

		boolean moving = false;
		//Wheels Cut Left, Reverse
		if (InputManager.isPressed(KeyEvent.VK_A) && InputManager.isPressed(KeyEvent.VK_S))
		{
			float rotation = getRotation();
			rotation -= rotationSpeed;
			setRotation(rotation);
			rotation = (float) Math.toRadians(rotation);
			direction.setX((float) Math.cos(rotation));
			direction.setY((float) Math.sin(rotation));
		}
		//Wheels Cut Left, Forward
		if (InputManager.isPressed(KeyEvent.VK_A) && InputManager.isPressed(KeyEvent.VK_W))
		{
			float rotation = getRotation();
			rotation += rotationSpeed;
			setRotation(rotation);
			rotation = (float) Math.toRadians(rotation);
			direction.setX((float) Math.cos(rotation));
			direction.setY((float) Math.sin(rotation));
		}
		//Wheels Cut Right, Reverse
		if (InputManager.isPressed(KeyEvent.VK_D) && InputManager.isPressed(KeyEvent.VK_S))
		{
			float rotation = getRotation();
			rotation += rotationSpeed;
			setRotation(rotation);
			rotation = (float) Math.toRadians(rotation);
			direction.setX((float) Math.cos(rotation));
			direction.setY((float) Math.sin(rotation));
		}
		//Wheels Cut Right, Forward
		if (InputManager.isPressed(KeyEvent.VK_D) && InputManager.isPressed(KeyEvent.VK_W))
		{
			float rotation = getRotation();
			rotation -= rotationSpeed;
			setRotation(rotation);
			rotation = (float) Math.toRadians(rotation);
			direction.setX((float) Math.cos(rotation));
			direction.setY((float) Math.sin(rotation));
		}
		//Forward
		if (InputManager.isPressed(KeyEvent.VK_W))
		{
			Vec2 position = getPosition();
			position.add(Vec2.scale(direction, movementSpeed));
			setPosition(position);
		}
		//Reverse
		if (InputManager.isPressed(KeyEvent.VK_S))
		{
			Vec2 position = getPosition();
			position.subtract(Vec2.scale(direction, movementSpeed));
			setPosition(position);
		}

		//Side lights


		//Pause menu


	}
}
