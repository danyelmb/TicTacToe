package es.codeurjc.ais.tictactoe;


import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoardTest extends TestCase{
    private Board board;
    private TicTacToeGame tictac;
    private Player p1;
    private Player p2;
    private Connection con1;
    private Connection con2;
    private WebDriver driver;
    
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
            tictac = new TicTacToeGame();
            driver = new ChromeDriver();
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
