/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mindvalley
 */
public class GameController {
    
    List<String> validMoves;
    
    /*
    * Constructor
    */
    public GameController(){
        validMoves = Arrays.asList("A","D","W","S","Q","N");
    }

    /**
     * This function has the main logic of controlling game work flow
     * @param board the game board
     * @param generator pieces generator
     */
    public void start(Boards board, PiecesGenerator generator) {
        Pieces currentPiece = generator.generate();
  
        while (true) {
            
            if(!board.canMovePiece(currentPiece)){
                board.drawPiece(currentPiece,1);
                currentPiece = generator.generate();
            }
            Pieces originalPiece = new Pieces(currentPiece);
            
            board.drawPiece(originalPiece,2);
            board.printContent();
            
            switch (getUserMove()) {
                case "A":
                    currentPiece.moveLeft();
                    break;
                case "D":
                    currentPiece.moveRight();
                    break;
                case "W":
                    currentPiece.rotateCounterClockWise();
                    break;
                case "S":
                    currentPiece.rotateClockWise();
                    break;
                case "Q":
                    return;
            }
            
            currentPiece.moveDown();
            
            if(board.canPlacePiece(currentPiece)){
                board.erasePiece(originalPiece);
            }else{
                currentPiece = originalPiece;
            }
        }

    }

    /**
     * This function will be the user UI
     * @return the user choice
     */
    private String getUserMove() {
        String move = "";

        while (true) {
            System.out.println("Choose A Valid Move Please : ");
            System.out.println("A (return): Move piece left");
            System.out.println("D (return): Move piece right");
            System.out.println("W (return): Move piece counter colckwise");
            System.out.println("S (return): Move piece clockwise");
            System.out.println("N (return): Do nothing");
            System.out.println("Q (return): To Exit Game");

            Scanner in = new Scanner(System.in);
            move = in.next();
            if(validMoves.contains(move)) {
                break;
            }
        }
        return move;
    }

}
