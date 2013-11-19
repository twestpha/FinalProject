package Football101;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Football101 extends JFrame {
	
	private Field field;
	private Play currentPlay;
	
	private ArrayList<Player> offensivePlayers;
	private ArrayList<Player> defensivePlayers;
	
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
	}

	public ArrayList<Player> getOffensivePlayers() {
		return offensivePlayers;
	}

	public ArrayList<Player> getDefensivePlayers() {
		return defensivePlayers;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Field getField(){
		return field;
	}



}
