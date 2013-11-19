package Football101;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Play {
	
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
		
		
	}

	public enum Playtype{
		RUN;
	}

}
