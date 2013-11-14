package Tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Football101.Player;

public class Football101Tests {
	private Player p1;
	@Before
	public void setUp() throws Exception {
		p1 = new Player(0,0,'O');
	}

	@Test
	public void testMove() {
		// Marcus
		p1.moveTo(50, 25);
		Assert.assertEquals(50, p1.getX());
		Assert.assertEquals(25, p1.getY());
		
		p1.moveTo(100, 50);
		Assert.assertEquals(100, p1.getX());
		Assert.assertEquals(50, p1.getY());
	}
	
	@Test
	public void testMoveAlongLine(){
		// Marcus
		// Create an array of points which will be used to
		// draw a line, which will be followed by the player.
		ArrayList<Point> lines = new ArrayList<Point>();
		lines.add(new Point(0,0));
		lines.add(new Point(25,25));
		lines.add(new Point(15,15));
		
		// Make sure that the player follows the line, ends up
		// at the end of it.
		p1.moveAlongLine(lines);
		Assert.assertEquals(15, p1.getX());
		Assert.assertEquals(15, p1.getY());
		
		// Add more points to the line. Make sure player still
		// follows it and ends up at the end.
		lines.add(new Point(30, 35));
		lines.add(new Point( 40, 30));
		p1.moveAlongLine(lines);
		Assert.assertEquals(40, p1.getX());
		Assert.assertEquals(30, p1.getY());
	}
	
	@Test 
	public void testLoadMenu(){
		// Tests the loading of the menu file
		// Brendan's Test
	}
	
	@Test
	public void loadOffensiveTeam(){
		// Tests the creation/loading of the offensive "team" (collection) of players.
		// Chris
	}
	
	@Test
	public void loadDefensiveTeam(){
		// Tests the creation/loading of the defensive "team" (collection) of players.
		// Chris
	}
	
	@Test
	public void testDropDownSelection(){
		// Tests which Item has been selected for the dropdown menus.
		// TREVORS TEST
	}
}
