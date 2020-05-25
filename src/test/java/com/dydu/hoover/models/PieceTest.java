package com.dydu.hoover.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTest {

    private Piece pieceTest;

    @Before
    public void before()
    {
        pieceTest = new Piece("/maze1.txt");
    }

    @Test
    public void initialisationTest() {
        assertEquals(Piece.getCoordonneesList().size(), 10);
        assertEquals(Piece.getObstacleList().size(), 2);
        assertEquals(Piece.getCaseVideList().size(), 8);
        for(int j = 0; j < 4; j++){
            assertEquals(Piece.getPieceMap()[j].length,7 );
        }
    }


}