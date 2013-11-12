package Tests;

import static org.junit.Assert.*;
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
		p1.moveTo(50, 25);
		Assert.assertEquals(50, p1.getX());
		Assert.assertEquals(25, p1.getY());
		
		p1.moveTo(100, 50);
		Assert.assertEquals(100, p1.getX());
		Assert.assertEquals(50, p1.getY());
	}
	
	

}
