package com.dydu.hoover.service;

import com.dydu.hoover.models.Coordonnee;
import com.dydu.hoover.models.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Deplacement {

    private static final Logger LOG = LoggerFactory
           .getLogger(Deplacement.class);
    /**
     * Liste des cases dèjà lavée
     */
    public static List<Coordonnee> listCaseLavées = new ArrayList<Coordonnee>();

    private static final String caseVide = "";
    private static final String caseObstacle = "M";

    //tableau de direction 0=>à droite, 1=>en bas, 2=>à gauche, 3=>en haut
    //On définit la priorité du dèplacement dans le sens des aiguilles d'une montre
    private static int[] direction = new int[4];


    private int rowLimit = Piece.getPieceMap().length - 1;
    private int colLimit = Piece.getPieceMap()[0].length - 1;

    private Coordonnee positionDroite = null;
    private Coordonnee positionGauche = null;
    private Coordonnee positionBas = null;
    private Coordonnee positionHaut = null;

    /**
     *
     * @param posInitiale position de départ du l'aspirateur
     * @return Liste des cases parcourues
     */

    public  List<String>  laverPièce(Coordonnee posInitiale){
        Coordonnee position_0 = posInitiale;
        List<String> casesParcourues = new ArrayList<String>();
        listCaseLavées.add(position_0);
        casesParcourues.add(position_0.toString());

    while (listCaseLavées.size() != Piece.getCaseVideList().size() ){

            Coordonnee coordLavee = seDeplacer(position_0);
            if(coordLavee != null){
                position_0 = coordLavee;
                if(coordLavee != null && !listCaseLavées.contains(coordLavee)){
                    listCaseLavées.add(coordLavee);
                }
                casesParcourues.add(position_0.toString());
            }else{
                break;
            }
        }

    return casesParcourues;
    }

    /**
     *
     * @param posInitiale postion case actuelle
     * @return   position prochaine case
     */
    private  Coordonnee seDeplacer(Coordonnee posInitiale){

        //Laver la position initiale
        Coordonnee aLaver = cherchDirection(posInitiale);
        if(aLaver!= null && aLaver != posInitiale){
            return aLaver;
        }else{
            return rechercheCaseSale();
        }

    }

    /**
     * Parcours les cases autour de la dernière case lavées
     * @return la plus proche case sale
     */
    private Coordonnee rechercheCaseSale(){
        Coordonnee aLaver = null;
            for(int i = 0 ; i < listCaseLavées.size(); i++){
                Coordonnee derniereCaseSale = listCaseLavées.get(i);
                aLaver = cherchDirection(derniereCaseSale);
                if(aLaver != null){
                   break;
                }
            }

        return  aLaver;
    }

    /**
     *
     * @param coordonnee position actuelle
     * @return la case direction du prochain dèplaceement
     */
    private Coordonnee cherchDirection(Coordonnee coordonnee) {
        String[][] pieceMapping = Piece.getPieceMap();
        Coordonnee coorProchaine = null;
        if (coordonnee.getY() < colLimit && coordonnee.getY() >= 1) {
            positionDroite = new Coordonnee(coordonnee.getX(), coordonnee.getY() + 1);
            positionGauche = new Coordonnee(coordonnee.getX(), coordonnee.getY() - 1);
        }
        if (coordonnee.getX() < rowLimit &&  coordonnee.getX()>= 1) {
            positionBas = new Coordonnee(coordonnee.getX() + 1, coordonnee.getY());
            positionHaut = new Coordonnee(coordonnee.getX() - 1, coordonnee.getY());
        }
        if (!listCaseLavées.contains(positionDroite) &&
                !pieceMapping[positionDroite.getX()][positionDroite.getY()].contains(caseObstacle)) {
            listCaseLavées.add(positionDroite);
            coorProchaine =  positionDroite;
        } else if (!listCaseLavées.contains(positionBas) &&
                !pieceMapping[positionBas.getX()][positionBas.getY()].contains(caseObstacle)) {
            listCaseLavées.add(positionBas);
            coorProchaine = positionBas;
        } else if (!listCaseLavées.contains(positionGauche) &&
                !pieceMapping[positionGauche.getX()][positionGauche.getY()].contains(caseObstacle)) {
            listCaseLavées.add(positionGauche);
            coorProchaine = positionGauche;
        } else if (!listCaseLavées.contains(positionHaut) &&
                !pieceMapping[positionHaut.getX()][positionHaut.getY()].contains(caseObstacle)) {
            listCaseLavées.add(positionHaut);
            coorProchaine = positionHaut;
        }
        return coorProchaine ;
    }

}
