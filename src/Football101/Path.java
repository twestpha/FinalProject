package Football101;

import java.awt.Point;
import java.util.ArrayList;

public class Path {
	ArrayList<Point> path;
	
	public Path() {
		// TODO Auto-generated constructor stub
		path = new ArrayList<Point>();
	}
	
	public void addToPath(Point p){
		path.add(p);
	}
	
	public ArrayList<Point> getPath(){
		return path;
	}

}
