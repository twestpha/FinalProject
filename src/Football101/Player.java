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
	private final int PRECISION = 8;
	private boolean isPlayDone;

	public Player(int xPosition, int yPosition, char team, ArrayList<Point> path, Football101 f) {
		this.x = xPosition;
		this.y = yPosition;
		this.teamSymbol = team;
		this.f = f;
		this.path = path;
		isPlayDone=(path.size()==0);
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
	
	public boolean doneWithPlay(){
		return isPlayDone;
	}

	public char getSymbol() {
		return teamSymbol;
	}

	public void setPath(ArrayList<Point> path){
		this.path = path;
	}
	
	public ArrayList<Point> getPath(){
		return path;
	}

	public void moveAlongLine() {
		if(path.size() != 0 && !isPlayDone){
			if( x > path.get(pathCount).x + PRECISION || x < path.get(pathCount).x - PRECISION || y < path.get(pathCount).y - PRECISION || y > path.get(pathCount).y + PRECISION){// Not at destination
				double dx = path.get(pathCount).x - x;
				double dy = path.get(pathCount).y - y;
				double theta = Math.atan(dy/dx);
				x = (int) (x + (12 * Math.cos(theta) ));
				y = (int) (y + (12 * Math.sin(theta) ));
			} else {
				if(pathCount+1 < path.size()){
					pathCount++;
				} else {
					isPlayDone = true;
				}
			}
		}
		f.getField().repaint();
	}
	
}
