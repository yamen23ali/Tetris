/*
 * An object of this class represent the game board
 */
package tetris;

import java.util.HashMap;

/**
 *
 * @author Yamen Ali
 */
public class Boards {

    private int[][] content;
    int width, height;
    HashMap cellsTypes;

    /* Constructor */
    public Boards(int width, int height) {
        this.width = width;
        this.height = height;
        
        cellsTypes =new HashMap();
        cellsTypes.put(0,' ');
        cellsTypes.put(1,'*');
        cellsTypes.put(2,'*');
        
        initializeContent();
    }

    /* Initialize the board before starting the game */
    private void initializeContent() {
        content = new int[height][];
        for (int i = 0; i < height; i++) {
            content[i] = new int[width];
            for (int j = 0; j < width; j++) {
                content[i][j] = 0;
            }
        }
        
        for (int i = 0; i < height; i++) {
            content[height - 1][i] = 1;
        }

        for (int i = 0; i < width; i++) {
            content[i][0] = content[i][width - 1] = 1;
        }
    }
    
    /* Fill the board with approriate piece type
    * @params piece : the piece we want to place
    * @params type : the piece type ( 1: for final piece , 2: for temp peice)
    */
    public void drawPiece(Pieces piece,int type){
        for (Coordinates coordinate : piece.coordinates) {
            content[coordinate.x][coordinate.y] =type;
        }
    }
    
    /* Erase piece from board 
    *
    */
    public void erasePiece(Pieces piece){
        for (Coordinates coordinate : piece.coordinates) {
            content[coordinate.x][coordinate.y] = 0;
        }
    }

    /* print the board */
    public void printContent() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(cellsTypes.get(content[i][j]));
            }
            System.out.println();
        }
    }
    
    /* Check for coordinates if they out bound the board 
    * @params x : x coord for the piece
    * @params y : y coord for the piece
    * @return : boolean to indecate if the piece coords are out bound 
    */
    public boolean isOutBound(int x, int y){
       return ( x>=height||x<=0 || y>=width || y <=0 );
    }
    
    /**
     * Check if we can place the piece in the board
     * @param piece the piece we want to place
     * @return boolean indecating if we can place the piece in the board
     */
    public boolean canPlacePiece(Pieces piece){
        for (Coordinates coordinate : piece.coordinates) {
            if(isOutBound(coordinate.x,coordinate.y) || 
                    content[coordinate.x][coordinate.y] == 1)
                return false;
        }
        return true;
    }
    
    /**
     * Check if there is next move for the piece
     * @param piece the piece we want to check it's next move
     * @return boolean to indecate if we can move this piece in the next iteration
     */
    public boolean canMovePiece(Pieces piece){
        for (Coordinates coordinate : piece.coordinates) {
            if(content[coordinate.x+1][coordinate.y] == 1)
                return false;
        }
        return true;
    }

}
