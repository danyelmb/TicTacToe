
import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {
    private Board board;
    private TicTacToeGame tictac;

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
            board.getCellsIfWinner("Mark");
            
                
	}

	@Test
	public void testCheckDraw() {
		fail("Not yet implemented");
	}

}
