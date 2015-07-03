/**
 * An object of this class will represent a Tetris piece 
 */
package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author mindvalley
 */
public class Pieces {
    
    ArrayList<Coordinates> coordinates;
    int width,height;
    Coordinates center;
    int totalShiftX , totalShiftY;
    int type ;
    
    /**
     * Constructor
     * @param coordinates piece coordinates
     * @param type piece type ( we have 5 types)
     */
    public Pieces(ArrayList<Coordinates> coordinates,int type,Coordinates center){
        this.coordinates = coordinates;
        this.type = type;
        this.center = center;
        setPieceDimensions();
    }
    
    /**
     * Copy Constructor
     * @param piece the piece to make deep copy of
     */
    public Pieces(Pieces piece){
        this.coordinates = new ArrayList<Coordinates>();
        for (Coordinates coordinate : piece.coordinates) {
            this.coordinates.add(new Coordinates(coordinate));
        }
        this.type = piece.type;
        this.width = piece.width;
        this.center = new Coordinates(piece.center);
        this.height = piece.height;
    }
    
    /**
     * Calculate the piece dimensions
     */
    private void setPieceDimensions(){
        for (Coordinates coordinate : coordinates) {
            height = Math.max(height,coordinate.x+1);
        }
        height-= totalShiftX;
        for (Coordinates coordinate : coordinates) {
            width = Math.max(width,coordinate.y+1);
        }
        width-=totalShiftY;
    }
   
    /**
     * Shift piece
     * @param xShift amount of shift in X axis
     * @param yShift amount of shift in y axis
     */
    void shiftCorrdintaes(int xShift , int yShift){
        for (Coordinates coordinate : coordinates) {
            coordinate.x += xShift;
            coordinate.y +=yShift;
        }
        totalShiftX+=xShift;
        totalShiftY+=yShift;
        center.x+=xShift;
        center.y+=yShift;
    }
    
    /**
     * Move piece left
     */
    void moveLeft(){
        shiftCorrdintaes(0, -1);
    }
    
    /**
     * Move piece right
     */
    void moveRight(){
        shiftCorrdintaes(0, 1);
    }
    
    /**
     * move piece down
     */
    void moveDown(){
        shiftCorrdintaes(+1, 0);
    }
    
    /**
     * move piece coordinates to origin coordinates in order to rotate it
     * @param coordinate piece coordinates to move
     */
    void transferToOrigin(Coordinates coordinate){
        coordinate.x-=totalShiftX;
        coordinate.y-=totalShiftY;
    }
    
    /**
     * Move piece coordinates back to original point after rotation
     * @param coordinate 
     */
    void transferToPoint(Coordinates coordinate){
        coordinate.x+=center.x;
        coordinate.y+=center.y;
    }
    
    /**
     * ROtate piece clock wise
     */
    void rotateClockWise(){
        if (type==5) return;
        for (Coordinates coordinate : coordinates) {
            int oldX = coordinate.x ;
            coordinate.x = coordinate.y-center.y;
            coordinate.y  = center.x-oldX;
            
            transferToPoint(coordinate);
        }
        
        setPieceDimensions();
    }
    
    /**
     * Rotate piece counter clockwise
     */
    void rotateCounterClockWise(){
        if (type==5) return;
        for (Coordinates coordinate : coordinates) {
            int oldY = coordinate.y;
            coordinate.y = coordinate.x-center.x;
            coordinate.x  = center.y -oldY;
            transferToPoint(coordinate);
        }
        setPieceDimensions();
    }
    
}
