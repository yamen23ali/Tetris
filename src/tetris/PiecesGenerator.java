/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mindvalley
 */
public class PiecesGenerator {
    
    private final int MAX_PIECES_TYPES = 5;
    private final int MAX_SHIFT = 15;
    
    /**
     * Generate random pieces
     * @return 
     */
    public Pieces generate(){
        Random rand = new Random();
        int randomPieceNum = rand.nextInt(MAX_PIECES_TYPES) + 1;
        int randomShift = rand.nextInt(MAX_PIECES_TYPES) + 1; 
        
        Pieces piece = createPiece(randomPieceNum);
        piece.shiftCorrdintaes(0, randomShift);
        
        return piece;
    }
    
    /**
     * Create piece
     * @param pieceNum represent piece type we want to generate
     * @return piece
     */
    public Pieces createPiece(int pieceNum){
        
        int [] coords;
        
        Coordinates center ;

        switch(pieceNum){
            case 1:
                /*
                 ****
                */
                coords = new int[]{0,0,0,1,0,2,0,3};
                center = new Coordinates(0,0);
                break;
            case 2:
                 /*
                   *
                   *
                   **
                 */
                 coords = new int[]{0,0,1,0,2,0,2,1};
                 center = new Coordinates(2,0);
                break;
            case 3:
                 /*
                   *
                   *
                  **
                 */
                coords = new int[]{0,1,1,1,2,0,2,1};
                center = new Coordinates(2,1);
                break;
            case 4:
                /*
                  *
                 **
                 *
                */
                coords = new int[]{0,1,1,0,1,1,2,0};
                center = new Coordinates(1,0);
                break;
            default:
                 /*
                  **
                  **
                 */
                coords = new int[]{0,0,0,1,1,0,1,1};
                center = new Coordinates(1,0);
                break;
        }
        return new Pieces(createCoords(coords),pieceNum,center);
        
    }
    
    /**
     * A helper method to transform piece coordinates from array to Coordinates objects
     * @param coords array of piece coordinates
     * @return list of Coordinates objects
     */
    public ArrayList<Coordinates> createCoords(int[] coords){
        ArrayList<Coordinates> coordsList = new ArrayList<Coordinates>();
        for(int i=0;i<coords.length;i+=2){
          coordsList.add(new Coordinates(coords[i],coords[i+1]));
        }
        return coordsList;
    }
    
}
