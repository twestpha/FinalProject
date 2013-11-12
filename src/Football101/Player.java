package Football101;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Player {
	
	int x, y;
	char symbol;
	
	public Player(int xPosition, int yPosition, char team) {
		this.x = xPosition;
		this.y = yPosition;
		this.symbol = team;
	}

	public void draw(Graphics g){
		// Draws symbol, implement here!
	}

	public void moveTo(int xPosition, int yPosition) {
		this.x = xPosition;
		this.y = yPosition;		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveAlongLine(ArrayList<Point> pointsOfLine) {
		// The points in this array list will serve to draw a line.
		// The goal here is to repaint the player at every point in
		// the line, to demonstrate some sort of animation. They'll
		// obviously end at the final point in the arraylist.
		
	}
}
