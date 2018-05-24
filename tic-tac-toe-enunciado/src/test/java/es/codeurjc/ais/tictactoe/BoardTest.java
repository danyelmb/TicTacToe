package es.codeurjc.ais.tictactoe;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase{
    private Board board;
    
    private String lineaJugador(String label, int[] linea){
        String player;
        String result;
        if(label.equals("X")){
            player = "Player 1 with label " + label;
        }else{
            player = "Player 2 with label " + label;
        }
        if(linea!=null){
            result = " should win with line: " + linea[0] + " - " + linea[1] + " - " + linea[2];
        }else{
            result = " shouldn't win the game.";
        }
        return player + result;
    }
    
    
    private void turnoJugador(String label, int celda){
        board.getCell(celda).active=true;
        board.getCell(celda).value=label;
    }
    
    /**
     *
     * @throws Exception
     */
    @Before
    @Override
    public void setUp() throws Exception {
        board = new Board();   
    }

    /**
     *
     * @throws Exception
     */
    @After
    @Override
    public void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void testGetCellsIfWinnerP1() {

        turnoJugador("X",0); //P1 T1 
        turnoJugador("O",3); //P2 T2 
        turnoJugador("X",1); //P1 T3 
        turnoJugador("O",4); //P2 T4 
        turnoJugador("X",2); //P1 T5 
        //Jugador 1 Gana
        int[] lineaGanadora = {0,1,2};

        assertArrayEquals(lineaJugador("X",lineaGanadora),
                board.getCellsIfWinner("X"),lineaGanadora);
        assertArrayEquals(lineaJugador("O",null),
                board.getCellsIfWinner("O"),null);
        assertFalse("Game not draw",board.checkDraw());
    }

    @Test
    public void testGetCellsIfWinnerP2() {
        
        turnoJugador("X",0); //P1 T1 
        turnoJugador("O",7); //P2 T2  
        turnoJugador("X",3); //P1 T3 
        turnoJugador("O",6); //P2 T4 
        turnoJugador("X",8); //P1 T5 
        turnoJugador("O",4); //P2 T6 
        turnoJugador("X",1); //P1 T7 
        turnoJugador("O",2); //P2 T8 
        //Jugador 2 Gana
        int[] lineaGanadora = {6,4,2};

        assertArrayEquals(lineaJugador("X",null),
                board.getCellsIfWinner("X"),null);
        assertArrayEquals(lineaJugador("O",lineaGanadora),
                board.getCellsIfWinner("O"),lineaGanadora);
        assertFalse("Game not draw",board.checkDraw());
    }

    @Test
    public void testCheckDraw() {
        
        turnoJugador("X",0); //P1 T1 
        turnoJugador("O",1); //P2 T2 
        turnoJugador("X",2); //P1 T3 
        turnoJugador("O",3); //P2 T4 
        turnoJugador("X",4); //P1 T5 
        turnoJugador("O",8); //P2 T6 
        turnoJugador("X",5); //P1 T7 
        turnoJugador("O",6); //P2 T8 
        turnoJugador("X",7); //P1 T9 
        //Empate
        assertArrayEquals(lineaJugador("X",null),
                board.getCellsIfWinner("X"),null);
        assertArrayEquals(lineaJugador("0",null),
                board.getCellsIfWinner("O"),null);
        assertTrue("Game draw!!",board.checkDraw());
    }
}
