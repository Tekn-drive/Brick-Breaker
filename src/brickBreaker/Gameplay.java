package brickBreaker;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score =0;
	private int totalbricks = 21;
	private Timer time;
	private int delay = 5;
	private int player1= 310;
	private int ballposx = 120;
	private int ballposy = 350;
	private int ballxdir = -1;
	private int ballydir = -2;
	
	private mapbrick map; 
	
	public Gameplay() {
		map = new mapbrick (3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time = new Timer(delay, this);
		time.start();
	}
	
	//Draws the level of the brick breaker game (including the scene when the player wins/loses)
	public void paint(Graphics g) {
		//Sets the background color of the level
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		//Draws the map
		map.draw((Graphics2D)g);
		
		//Shows the score
		g.setColor(Color.white);
		g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		//Sets the color and size of the paddle (in this case, the paddle is a rectangle)
		g.setColor(Color.white);
		g.fillRect(player1, 550, 100,8);
		
		//Sets the color and size of the ball
		g.setColor(Color.white);
		g.fillOval(ballposx,ballposy, 20, 20);
		
		//If there is 0 bricks left, show this scene (the player has won)
		if(totalbricks <=0) {
			play = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.white);
			g.setFont(new Font("Times New Roman", Font.BOLD, 35));
			g.drawString("You Win!", 190, 300);
			
			g.setFont(new Font("Times New Roman", Font.BOLD, 30));
			g.drawString("Press ENTER to Restart",230, 350);
		}
		
		//If the ball position in the y axis is below the paddle, show this scene (the player has lost)
		if (ballposy > 570) {
			play = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("Times New Roman", Font.BOLD, 35));
			g.drawString("You Lost!", 190, 300);
			g.setFont(new Font("Times New Roman", Font.BOLD, 30));
			g.drawString("Press ENTER to Restart",230, 350);
			
		}
		g.dispose();
	}
	
	@Override
	//Determines the mechanism of the game, how will it work
	public void actionPerformed(ActionEvent e) {
		time.start();
		//If the player is playing the game, then the following actions will be performed
		if(play) {
			//Detects intersection of 2 objects
			if (new Rectangle(ballposx,ballposy, 20, 20).intersects(new Rectangle(player1, 550, 100, 8))) {
				ballydir = -ballydir; 
			}
			
			B: for (int i=0; i< map.map.length; i++) {
				for (int j=0; j<map.map[0].length; j++) {
					if (map.map[i][j]>0) {
						//Draws the bricks again with the specified specification
						int brickx = j*map.brickwidth + 80;
						int bricky = i* map.brickheight + 50; 
						int brickwidth = map.brickwidth;
						int brickheight = map.brickheight;
						
						Rectangle rect = new Rectangle(brickx, bricky, brickwidth, brickheight);
						Rectangle ballrect = new Rectangle(ballposx, ballposy, 20, 20);
						Rectangle brickrect = rect; 
						
						//If the ball hits the brick, then the score will be added by 10.
						if(ballrect.intersects(brickrect)) {
							map.setBrickval(0,i,j);
							totalbricks--;
							score += 10;
							
							if(ballposx + 19 <= brickrect.x || ballposx + 1 >= brickrect.x + brickrect.width) {
								ballxdir = - ballxdir;
							} else {
								ballydir = -ballydir; 
							}
							
							break B;
						}
					}
				}
			}
			ballposx += ballxdir;
			ballposy += ballydir;
			if (ballposx < 0) { 
				ballxdir = - ballxdir;
			}
			if (ballposy < 0) { 
				ballydir = - ballydir;
			}
			if (ballposx > 670) { 
				ballxdir = - ballxdir;
			}
			
		}
		
		//Repaints the level to the origin state if its closed or restarted
		repaint();
	}

	@Override
	//This is a helper function to determine which key is typed with the keyboard
	public void keyTyped(KeyEvent e) {}
	
	@Override
	//This is also a helper function to determine which key is released
	public void keyReleased(KeyEvent e) {}

	@Override
	//This function tells the game what to do if a certain key is pressed.
	public void keyPressed(KeyEvent e) {
		
		//If the right key is pressed, the paddle will go right
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(player1 >= 600) {
				player1 = 600;
			} else {
				moveright();
			}
		}
		
		//If the left key is pressed, the paddle will go left
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(player1 <10) {
				player1 = 10;
			} else {
				moveleft();
			}
		}
		
		//If the Enter key is pressed then the game will start
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				play = true;
				ballposx = 120;
				ballposy = 350;
				ballxdir = -1;
				ballydir = -2;
				player1 = 310;
				score = 0;
				totalbricks = 21;
				map = new mapbrick(3,7);
				
				repaint();
			};
			
		}
	}
	
	//When moving right, the game is started, and the paddle will move for 20 pixels to the right
	public void moveright() {
		play = true;
		player1+=20;
	}
	
	//When moving right, the game is started, and the paddle will move for 20 pixels to the left
	public void moveleft() {
		play = true;
		player1 -=20;
	}
	
}
