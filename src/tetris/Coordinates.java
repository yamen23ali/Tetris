/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author mindvalley
 */
public class Coordinates {
    
    int x , y;
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Coordinates(Coordinates coordinate){
        this.x = coordinate.x;
        this.y = coordinate.y;
    }
    
}
