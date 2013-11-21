package Football101;

import java.awt.Point;
import java.util.ArrayList;

public class Path {
	ArrayList<Point> path;
	
	public void addToPath(Point p){
		path.add(p);
	}
	
	public ArrayList<Point> getPath(){
		return path;
	}

}
