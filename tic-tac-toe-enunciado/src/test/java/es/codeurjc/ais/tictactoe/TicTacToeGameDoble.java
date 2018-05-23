package es.codeurjc.ais.tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;
//import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.verification.VerificationMode;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.Mock;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;



/**
 *
 * @author Daniel
 */
public class TicTacToeGameDoble extends TestCase{
    private Player p1;
    private Player p2;
    private List<Player> players = new ArrayList<>();
    private Connection connection1 ;
    private Connection connection2 ;
    private TicTacToeGame tictac;
    private ArgumentCaptor<WinnerValue> argument;
        
    /**
     *
     * @throws Exception
     */
    @Before
    @Override
    public void setUp() throws Exception {
        tictac = new TicTacToeGame();
        p1 = new Player(1,"X","Mark");
        p2 = new Player(2,"O","Dany");
        connection1 = mock(Connection.class);
        connection2 = mock(Connection.class);
        tictac.addConnection(connection1);
        tictac.addConnection(connection2);
        tictac.addPlayer(p1);
        tictac.addPlayer(p2);
        argument = ArgumentCaptor.forClass(WinnerValue.class);
        

    }
    
    @After
    @Override
    public void tearDown() throws Exception {
        reset(connection1);
        reset(connection2);
    }
    
    @Test
    public void testConnection1() {
        verify(connection1, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p1,p2)));

    }
    
    @Test
    public void testConnection2() {
        verify(connection2, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p1,p2)));
    }
    
    
    @Test
    public void testTurnosWinner1(){ 
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(4);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(0);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(3);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(2);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(5);
        //Array Ganador
        int[] ganador = {3,4,5};
        //P1 Ganador
        verify(connection1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        assertEquals(argument.getValue().player,p1);
        assertArrayEquals(argument.getValue().pos, ganador);
        verify(connection2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        assertEquals(argument.getValue().player,p1);
        assertArrayEquals(argument.getValue().pos, ganador);
    }
    
    @Test
    public void testTurnosDraw(){
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(4);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(0);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(3);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(1);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(2);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(5);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(7);
        //Turno P2
        assertFalse(tictac.checkTurn(1));
        assertTrue(tictac.checkTurn(2));
        tictac.mark(6);
        //Turno P1
        assertTrue(tictac.checkTurn(1));
        assertFalse(tictac.checkTurn(2));
        tictac.mark(8);
        //Draw
        verify(connection1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        assertEquals(argument.getValue(),null);
    }
}
