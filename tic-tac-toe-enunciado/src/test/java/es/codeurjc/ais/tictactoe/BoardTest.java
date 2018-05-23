package es.codeurjc.ais.tictactoe;


import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase{
    private Board board;
    private TicTacToeGame tictac;
    private Player p1;
    private Player p2;
    private Connection con1;
    private Connection con2;

    
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
            tictac = new TicTacToeGame();
            board = new Board();   
	}

        @After
	public void tearDown() throws Exception {
            board = null;
            tictac = null;
	}
        
	@Test
	public void testGetCellsIfWinner() {
            
            
                
	}

	@Test
	public void testCheckDraw() {
		fail("Not yet implemented");
	}

}
