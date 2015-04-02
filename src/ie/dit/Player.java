package ie.dit;

import processing.core.PApplet;

public class Player 
{
	float w,h;
	float playerX, playerY;
	float gravity = 1;
	float speed =5;//0;
	
	
	PApplet parent;

	Player(PApplet p)
	{
		parent = p;
		
		playerX = 100; //parent.random(0,100);
		playerY = 80; //parent.random(0,80);
		w= 50;
		h = 50;
		
		
	}

	
	public void move()
	{
		/*
		if(parent.keyPressed)
		{
			if(parent.key == 'd')
			{
				playerX += 5;
			}
			
			if(parent.key == 'a')
			{
				playerX -= 5;
			}
		}
		*/
		if(parent.keyPressed && parent.key == 'd')
		{
			playerX += 5;
		}
		if(parent.keyPressed && parent.key == 'a')
		{
			playerX -= 5;
		}
		

	}
	
	public void display()
	{
		/*if(speed==0&&playerY==parent.height-h)
		{
			speed=0;
		}
		else
		{
		  speed=speed+gravity;
		}*/
		parent.fill(255,255,0);
		
		parent.rect(playerX, playerY,w,h);
		
		playerY=playerY+speed;
		
		if(playerY>parent.height-h)
		{
			speed=speed*-1;
		}
		if(playerY<0)
		{
			speed=speed*-1;
		}

		
		
	}
	boolean collided(Boxes b)
	{
		if(playerX + w < b.boxX) //(playerX + w < b.boxX) 
		{
			return false; 
			
		}
		if(playerX - b.boxW > b.boxX)//(playerX-w - b.boxW > b.boxX)
		{
			return false;
		}
		if(playerY + h < b.boxY)//(playerY + w < b.boxY)
		{
			return false;
		}
		if(playerY - b.boxH > b.boxY)//(playerY - w - b.boxH > b.boxY)
		{
			return false;
		}
		
		speed *= -1;
		
		//if they collided then its true
		return true;
	}
	
	public int LeftRight(Boxes b)
	{
		int i=0;
		if(playerX+w>b.boxX&&playerY+h>b.boxY)
		{
		    i =1;
			return i;
		}
		//left box side
		else if(playerX+w>b.boxX&&playerY-b.boxH<b.boxY)
		{
			i =1;
			return i;
		}
		else if(playerX-b.boxW<b.boxX&&playerY+h>b.boxY)
		{
			i=2;
			return i;
		}
		else if(playerX-b.boxW<b.boxX&&playerY-b.boxH<b.boxY)
		{
			i=2;
			return i;
		}
		else
		{
			return i;
		}
	}
	
	//chck for powerUp and player collision
	boolean collided(PowerUp pow)
	{
		if(playerX + w < pow.powerX) //(playerX + w < b.boxX) 
		{
			return false; 
			
		}
		if(playerX - pow.powerW > pow.powerX)//(playerX-w - b.boxW > b.boxX)
		{
			return false;
		}
		if(playerY + h < pow.powerY)//(playerY + w < b.boxY)
		{
			return false;
		}
		if(playerY - pow.powerH > pow.powerY)//(playerY - w - b.boxH > b.boxY)
		{
			return false;
		}
		
		//speed *= -1;
		
		//if they collided then its true
		return true;
	}
	
}
