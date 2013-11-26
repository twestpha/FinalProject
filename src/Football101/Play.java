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
		// Counter to keep track of the number of usable characters read
		int charCounter = 0;
		// Either X or O
		char teamSign = ' ';
		// Starting x, y coordinates for the player
		int startX = -1;
		int startY = -1;
		int pathX = -1;
		int pathY = -1;
		
		while(playParser.hasNextLine()){
			// We need a path for the whole player line, so it's put here so it's not reset until next line
			Path playerPath = new Path();
			while(playParser.hasNext()){
				// Parse a character at a time
				playParser.useDelimiter(",");
				String playerLine = playParser.next();
				
				// If it's a comma, we can skip reading it
				if(playerLine.equals(",")){
					continue;
				}
				// We know this is the team sign, the rest of the data is numeric.
				else if(playerLine.equals("X") || playerLine.equals("O")){
					charCounter++;
					// Assign teamsign
					teamSign = playerLine.charAt(0);
				}
				// If it is an integer...
				else if(isInteger(playerLine)){
					// If we've only read 1 character then this character is the starting x coord 
					if(charCounter == 1){
						startX = Integer.parseInt(playerLine);
						//charCounter++;
					}
					// If we've read 2 characters, this is the starting y coord
					else if(charCounter == 2){
						startY = Integer.parseInt(playerLine);
					}
					// If charcounter mod 2 is one (because we counted the team character), it's an x value needing to be added to a point
					// then to a path
					else if(charCounter%2 == 1){
						pathX = Integer.parseInt(playerLine);
						//continue;
					}
					// Y value for point, then path
					else if(charCounter % 2 == 0){
						pathY = Integer.parseInt(playerLine);
						//continue;
					}
					charCounter++;
				}
				// Not sure we even need this else if
				else if(playerLine.equals("\n")){
					// EOL.
				}
				
				//System.out.println("pathX: " + pathX + " pathY: " + pathY);
				
				// Adds a point to the path, then resets the check varibles
				if(pathX != -1 && pathY != -1){
					Point pathPoint = new Point(pathX,pathY);	
					System.out.println("Added " + pathPoint);
					playerPath.addToPath(pathPoint);
					pathX = -1;
					pathY = -1;
					
				}
				
			}
			
			
			Player player = new Player(startX, startY, teamSign,fb101, playerPath);
			
			if(teamSign == 'O'){
				offensiveTeam.add(player);
			}
			else if (teamSign == 'X'){
				defensiveTeam.add(player);
			}
			else{
				System.out.println("Team sign incorrect. This shouldn't happen. Error in Play class.");
			}
			// Basically if the number of characters, except the team sign, mod 2 is not 0,
			// then we have a non-paired value.
			if((charCounter-1) % 2 != 0){
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

}
