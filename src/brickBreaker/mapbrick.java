package brickBreaker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class mapbrick {
	public int map[][];
	public int brickwidth;
	public int brickheight; 
	
	//The 2D array in this map is used to set the level and prepare the bricks for the game.
	public mapbrick (int row, int col) {
		map = new int [row][col];
		for (int i=0; i< map.length; i++) {
			for (int j=0; j<map[0].length ; j++) {
				map[i][j] = 1;
			}
		}
		
		//Specifies the properties of bricks available in the level
		brickwidth = 540/col;
		brickheight = 150/row; 
	}
	
	//Draws the bricks inside the level.
	public void draw(Graphics2D g) {
		for (int i=0; i< map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j]> 0) {
					g.setColor(Color.white);
					g.fillRect(j*brickwidth + 80,  i*brickheight + 50,  brickwidth,  brickheight);
					
					//Creates the line which separates a brick from the next one.
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickwidth +80, i*brickheight + 50, brickwidth, brickheight);
					
				}
			}
		}
	}
	
	//Sets the value of the bricks in the level.
	public void setBrickval(int val, int row, int col) {
		map[row][col] = val;
	}
}


