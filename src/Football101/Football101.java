package Football101;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import Tests.BadConfigException;


public class Football101 extends JFrame {

	private Field field;
	private Play currentPlay;
	private Menu menu;

	private ArrayList<Player> offensivePlayers;
	private ArrayList<Player> defensivePlayers;
	
	Map<String, String> menuContent = new HashMap<String, String>();

	private static final int PLAYERS_PER_TEAM = 11;

	public Football101() {
		// TODO Auto-generated constructor stub
		field = new Field();

		offensivePlayers = new ArrayList<Player>();
		defensivePlayers = new ArrayList<Player>();

		for (int i = 0; i < PLAYERS_PER_TEAM; ++i){
			// Fills the team array lists. The first two arguments just control where the player is at on the field
			//	What is shown is a simple example of where they can be.
			offensivePlayers.add(new Player(field.getWidth()*(2/5),i*field.getHeight()/PLAYERS_PER_TEAM,'O', this));
			defensivePlayers.add(new Player(field.getWidth()*(4/5),i*field.getHeight()/PLAYERS_PER_TEAM,'X', this));
		}
	}

	public void clear(){

	}

	public void executePlay(Play target){

	}

	public void loadPlay(String filename){
		// Load the Play object.
		currentPlay = new Play(filename);
	}

	public ArrayList<Player> getOffensivePlayers() {
		return offensivePlayers;
	}

	public ArrayList<Player> getDefensivePlayers() {
		return defensivePlayers;
	}

	public static void main(String[] args) {
		
		
		/* tested if loadMenu worked/
		Football101 test = new Football101();
		try {
			test.loadMenu("PracticeMenuFile");
		} catch (BadConfigException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(test.getMap());
		/*/
	}

	public Field getField(){
		return field;
	}
	
    public void loadMenu(String filename) throws BadConfigException, FileNotFoundException{
        try {
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			while(in.hasNext()){
				String[] content = in.nextLine().split(", ");
				if (content.length >2 || content.length <2){
					// LOOK AT THIS LINE // -- LINE 70 --------------------------------
					throw new BadConfigException("Bad legend Config");
				}
				menuContent.put(content[0], content[1]);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("The File could not be Found");
		}
        menu = new Menu(menuContent);
    }

	public Menu getMenu() {
		return menu;
	}

	public Map<String, String> getMap(){
		return menuContent;
	}


}
