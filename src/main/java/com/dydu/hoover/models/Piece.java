package com.dydu.hoover.models;

import com.dydu.hoover.utils.MatrixFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class qui gère le dèplacement de l'aspirateur
 */
public class Piece {


    private static final String caseVide = "";
    private static final String caseObstacle = "M";

    /**
     * List des cases  de la pièce
     */

    private static List<Coordonnee> coordonneesList = new ArrayList<Coordonnee>();

    /**
     * liste des cases avec obstacle
     */
    private static List<Coordonnee> obstacleList = new ArrayList<Coordonnee>();

    /**
     * Liste des case vides
     */
    private static List<Coordonnee> caseVideList = new ArrayList<Coordonnee>();


    /**
     * Matrice des cases de la pièce
     */
     private static  String[][] pieceMap;


    /**
     * Constructor to init the List of all cases (dirty, obstacle)
     * @param fileName
     */
    public Piece(String fileName){
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        pieceMap = matrixFileReader.readFile(fileName);
        for(int row = 1; row < pieceMap.length - 1 ; row ++){
            for(int col = 1; col < pieceMap[row].length - 1; col++){
                coordonneesList.add(new Coordonnee(row, col));
                if(pieceMap[row][col].contains(caseObstacle)){
                    obstacleList.add(new Coordonnee(row,col));
                }else if(pieceMap[row][col].contains(caseVide)){
                    caseVideList.add(new Coordonnee(row,col));
                }
            }
        }
    }

    public static List<Coordonnee> getCoordonneesList() {
        return coordonneesList;
    }


    public static List<Coordonnee> getObstacleList() {
        return obstacleList;
    }


    public static List<Coordonnee> getCaseVideList() {
        return caseVideList;
    }


    public static String[][] getPieceMap() {
        return pieceMap;
    }

}
