
package dev.DavRotg08.QGame.gfx;

//Camera to control how much of level can be seen

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Entity;
import dev.DavRotg08.QGame.tiles.Tile;

public class Camera {
    
    private Handler handler; 
    
    //variables for offsetting the view of the canvas
    private float xOffset, yOffset;
    
    //mapSize
    private int mapX;
    private int mapY;
    
    //Max Offsets
    private int xOffsetMax;
    private int yOffsetMax;
    
    public Camera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
        mapX = handler.getWidth();
        mapY = handler.getHeight();
        
        
    }
    
    //Method to see if camera shows area outside level 
    public void mapLimitCheck(){
        xOffsetMax = handler.getLevel().getWidth()*Tile.TILE_WIDTH - handler.getWidth();
        yOffsetMax = handler.getLevel().getHeight()*Tile.TILE_HEIGHT - handler.getHeight();
        //Assuming the map is positioned at 0,0
        if(xOffset < 0){
            xOffset = 0;
        }
        /*Checking if camera goes over limit on right side of level which is based on 
        Width of the map which is handled by the handler, multiply by tile width to
        get dimensions in pixels and finally subtract "handler.getWidth" to get the
        width of the window being shown to player */
        else if(xOffset > xOffsetMax){
            xOffset = xOffsetMax;
            
        }
        if(yOffset < 0){
            yOffset = 0;
        }
        else if(yOffset > yOffsetMax){
            yOffset = yOffsetMax;
        }
    }
    
    //Method to center camera on an entity
    public void centerOnEntity(Entity e){
        
       // xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
       // yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
       xOffset = e.getX() - mapX/2 + e.getWidth()/2;
       yOffset = e.getY() - mapY/2 + e.getHeight()/2;
        
        mapLimitCheck();
        
        
        
    }
    
    public void move(float xVal, float yVal){
        xOffset += xVal;
        yOffset += yVal;
        mapLimitCheck();
       
        
    }
    
       public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
    
}
