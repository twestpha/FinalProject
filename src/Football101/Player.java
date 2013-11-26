package Football101;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Player {
	
	int x, y;
	char teamSymbol;
	Football101 f;
	
	public Player(int xPosition, int yPosition, char team, Football101 f, Path p) {
		this.x = xPosition;
		this.y = yPosition;
		this.teamSymbol = team;
		this.f = f;
	}

	public void draw(Graphics g){
		// Draws symbol, implement here!
	}

	public void moveTo(int xPosition, int yPosition) {
		this.x = xPosition;
		this.y= yPosition;
		f.getField().repaint();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public char getSymbol() {
		return teamSymbol;
	}

	public void moveAlongLine(ArrayList<Point> pointsOfLine) {
		// TODO Implement moveAlongLine()
		// The points in this array list will serve to draw a line.
		// The goal here is to repaint the player at every point in
		// the line, to demonstrate some sort of animation. They'll
		// obviously end at the final point in the arraylist.
		
		for(Point p : pointsOfLine){
			// Move player
			this.moveTo(p.x, p.y);
			// Reflect changes
			f.getField().repaint();
			// Pause application for half a second so that
			// the animation actually shows
			try { 
				Thread.sleep(70); 
			} catch(InterruptedException e) {
				System.out.println("Unable to sleep program");
			}
			
			
		}
		
		
	}
}
