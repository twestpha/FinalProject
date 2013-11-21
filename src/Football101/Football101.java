package Football101;
import java.awt.BorderLayout;
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

		offensivePlayers = new ArrayList<Player>();
		defensivePlayers = new ArrayList<Player>();
		
		// Jframe/Gui stuff
		field = new Field();
		add(field, BorderLayout.CENTER);
		setSize(1024,768);
		setResizable(false);
		setVisible(true);
		setTitle("Football 101");
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
		Football101 f = new Football101();
	}

	public Field getField(){
		return field;
	}
	
    public void loadMenu(String filename) throws BadConfigException, FileNotFoundException{
        try {
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			while(in.hasNext()){
				String[] content = in.nextLine().split(",");
				if (content.length != 2){
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
