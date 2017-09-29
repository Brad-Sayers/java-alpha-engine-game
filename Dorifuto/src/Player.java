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
		setRectangleCollider(45,45);

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
	}
	//collision
	@Override
	public void collisionReaction(GameObject otherObject)
	{
		float x1 = getPositionX();
		float y1 = getPositionY();
		float x2 = otherObject.getPositionX();
		float y2 = otherObject.getPositionY();

		float halfW1 = getCollider().getWidth()/2;
		float halfW2 = otherObject.getCollider().getWidth()/2;
		float halfH1 = getCollider().getHeight()/2;
		float halfH2 = otherObject.getCollider().getHeight()/2;

		float critSlope = Math.abs((halfH1+halfH2)/(halfW1+halfW2));
		float curSlope = Math.abs((y1-y2)/(x1-x2));

		if(otherObject.getName() == "Hud")
		{
			if(curSlope < critSlope)
			{
				if (x1 - x2 < halfW1 + halfW2 && x1 > x2)
				{
					float adjust = (halfW1 + halfW2) - (x1 - x2);
					setPositionX(getPositionX() + adjust + 1);
				} else if (x2 - x1 < halfW1 + halfW2 && x2 > x1)
				{
					float adjust = (halfW1 + halfW2) - (x2 - x1);
					setPositionX(getPositionX() - adjust - 1);
				}
			}
			else
			{
				if (y1 - y2 < halfH1 + halfH2 && y1 > y2)
				{
					float adjust = (halfH1 + halfH2) - (y1 - y2);
					setPositionY(getPositionY() + adjust + 1);
				} else if (y2 - y1 < halfH1 + halfH2 && y2 > y1)
				{
					float adjust = (halfH1 + halfH2) - (y2 - y1);
					setPositionY(getPositionY() - adjust - 1);
				}
			}
		}
	}

}
