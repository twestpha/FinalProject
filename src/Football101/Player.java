package Football101;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Player {

	private int x, y, pathCount;
	private boolean doneWithPlay;
	private char teamSymbol;
	private Football101 f;
	private ArrayList<Point> path;

	public Player(int xPosition, int yPosition, char team, ArrayList<Point> path, Football101 f) {
		this.x = xPosition;
		this.y = yPosition;
		this.teamSymbol = team;
		this.f = f;
		this.path = path;
		pathCount = 0;
	}

	public void draw(Graphics g){
		g.setFont(new Font("CourierNew", Font.PLAIN, 50));
		if(teamSymbol == 'O'){
			g.setColor(Color.RED);
		}else{
			g.setColor(Color.BLACK);
		}
		g.drawString(new Character(teamSymbol).toString(), x, y);
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

	public void setPath(ArrayList<Point> path){
		this.path = path;
	}
	
	public boolean isDoneWithPlay(){
		return doneWithPlay;
	}
	public ArrayList<Point> getPath(){
		return path;
	}

	public void moveAlongLine() {
		if(path.size() != 0 && !doneWithPlay){
			if( x != path.get(pathCount).x || y != path.get(pathCount).y ){// Not at destination
				double dx = path.get(pathCount).x - x;
				double dy = path.get(pathCount).y - y;
				double theta = Math.atan(dy/dx);
				x = (int) (x + (1 * Math.cos(theta) ));
				y = (int) (y + (1 * Math.sin(theta) ));
			} else {
				if(pathCount+1 < path.size()){
					pathCount++;
				} else {
					doneWithPlay = true;
				}
			}
		}
		f.getField().repaint();
	}
	
}
