package Football101;
import java.awt.Graphics;


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
}
