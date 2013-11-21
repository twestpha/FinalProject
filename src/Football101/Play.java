package Football101;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	ArrayList<Player> offensiveTeam;
	ArrayList<Player> defensiveTeam;
	String currentPlayFilename;

	public Play(String filename) {
		currentPlayFilename = filename;
	}

	private void readPlayFromFile(){
		File playFile = new File(currentPlayFilename);
		Scanner playParser = null;
		try {
			playParser = new Scanner(playFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't open play file");
		}

		int charCounter = 0;
		char teamSign = ' ';
		int startX = -1;
		int startY = -1;
		while(playParser.hasNextLine()){
			while(playParser.hasNext()){
				String playerLine = playParser.next();

				if(playerLine.equals(",")){
					// don't increment charcounter
				}
				else if(playerLine.equals("X") || playerLine.equals("O")){
					charCounter++;
					teamSign = playerLine.charAt(0);
				}
				else if(isInteger(playerLine)){
					if(charCounter == 2){
						startX = Integer.parseInt(playerLine);
						charCounter++;
					}
					else if(charCounter == 3){
						startY = Integer.parseInt(playerLine);
						charCounter++;
					}
					else if(charCounter%2 == 0){
						// x-value for 
					}
					else if(charCounter % 2 == 1){
						// y-value for
					}
				}
				else if(playerLine.equals("\n")){
					// EOL.
				}
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
