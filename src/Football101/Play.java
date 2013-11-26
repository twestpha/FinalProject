package Football101;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	ArrayList<Player> offensiveTeam;
	ArrayList<Player> defensiveTeam;
	String currentPlayFilename;
	Football101 fb101;

	public Play(String filename, Football101 fb101) {
		currentPlayFilename = filename;
		this.fb101 = fb101;
		
		offensiveTeam = new ArrayList<Player>();
		defensiveTeam = new ArrayList<Player>();
	}
    // Added throws declaration. Figured this error should be handled elsewhere.
	public void readPlayFromFile() throws BadConfigException{
		// Open file, wrap it in scanner.
		File playFile = new File(currentPlayFilename);
		Scanner playParser = null;
		try {
			playParser = new Scanner(playFile);
		} catch (FileNotFoundException e) {
			// TODO: handle this exception
			System.out.println("Can't open play file");
		}
		
		
		
		System.out.println("------------------");
		
		while(playParser.hasNextLine()){
			char teamSign = ' ';
			int startX = -1;
			int startY = -1;
			int pathX = -1;
			int pathY = -1;
			
			ArrayList<Point> path = new ArrayList<Point>();
			
			String playerLine = playParser.nextLine();
			String[] lines = playerLine.split(",");
			
			if ((lines.length % 2) == 0 ) {
				throw new BadConfigException(currentPlayFilename);
			}
			
			for (String s : lines) {
				
				if(s.contains("X") || s.contains("O")){
					// Assign teamsign
					teamSign = playerLine.charAt(0);
				} else {
					//System.out.println("I've got an int");
					int coordinate = Integer.parseInt(s);
					
					if (startX == -1){
						//System.out.println("set startX to " + coordinate);
						startX = coordinate;
					} else if (startY == -1) {
						//System.out.println("set startY to " + coordinate);
						startY = coordinate;
					} else if (pathX == -1) {
						//System.out.println("set pathX to " + coordinate);
						pathX = coordinate;
					} else if (pathY == -1) {
						//System.out.println("set pathY to " + coordinate);
						pathY = coordinate;
					} 
					if (pathX != -1 && pathY != -1) {
						path.add(new Point(pathX, pathY));
						pathX = -1;
						pathY = -1;
					}
				}
			}
			
			System.out.println("Team sign: " + teamSign + ", startX: " + startX + ", startY: " + startY);
			System.out.println("\tPath: " + path);
			System.out.println("------------------");

			if (teamSign == 'X') {
				defensiveTeam.add(new Player(startX,startY,teamSign, path, fb101));
			} else if (teamSign == 'O') {
				offensiveTeam.add(new Player(startX,startY,teamSign, path, fb101));
			} else {
				throw new BadConfigException(currentPlayFilename);
			}
			
		}
		
	}

	public static boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		} catch(NumberFormatException e){
			return false;
		}

		// will only get here if it's in integer
		return true;
	}

	public enum Playtype{
		RUN;
	}

	public ArrayList<Player> getOffensiveTeam() {
		return offensiveTeam;
	}
	public ArrayList<Player> getDefensiveTeam() {
		return defensiveTeam;
	}

}
