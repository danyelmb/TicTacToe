package es.codeurjc.ais.tictactoe;


import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase{
    /*private Board board;
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
        */
	@Test
	public void testGetCellsIfWinnerP1() {
            Board board = new Board();
            board.getCell(0).active=true;
            board.getCell(0).value="X";
            board.getCell(3).active=true;
            board.getCell(3).value="O";
            board.getCell(1).active=true;
            board.getCell(1).value="X";
            board.getCell(4).active=true;
            board.getCell(4).value="O"; 
            board.getCell(2).active=true;
            board.getCell(2).value="X";

            int[] lineaGanadora = {0,1,2};
            
            assertArrayEquals(board.getCellsIfWinner("X"),lineaGanadora);
            
	}

	@Test
	public void testCheckDraw() {
		fail("Not yet implemented");
	}

        @Test
	public void testGetCellsIfWinnerP2() {
                fail("Not yet implemented");
            
                
	}
}
