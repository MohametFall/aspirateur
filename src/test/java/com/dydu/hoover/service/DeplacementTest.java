package com.dydu.hoover.service;

import com.dydu.hoover.models.Coordonnee;
import com.dydu.hoover.models.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeplacementTest {

    @Test
    public void seDeplacerTest(){
        Piece piece  =  new Piece("/maze1.txt");
        Deplacement deplacement = new Deplacement();

        Coordonnee coordonneeInit = new Coordonnee(1 , 1);

        List<String> casesLavees = deplacement.laverPièce(coordonneeInit);

        assertEquals(casesLavees.size(), 8);

    }
}