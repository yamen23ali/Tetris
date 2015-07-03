/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author mindvalley
 */
public class Tetris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Boards board = new Boards(20,20);
        PiecesGenerator generator = new PiecesGenerator();
        GameController controller =new GameController();
        controller.start(board,generator);

    }
    
   
    
}
