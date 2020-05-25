
package dev.DavRotg08.QGame.entities;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.tiles.Tile;

public abstract class Creature extends Entity{
    
    
    public static final float DEFAULT_SPEED = 3.5f;
    public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
    
    
    protected float speed;
    
    protected float xMove, yMove;
    
    public Creature(Handler handler, float x, float y, int height, int width){
        super(handler, x,y, height, width);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        
    }
    
    public void move(){
        if(!checkCollisions(xMove, 0f))
            moveX();
        if(!checkCollisions(0f, yMove))
            moveY();
    }
    
    public void moveX(){
        
        if(xMove >0){ //moving right
            int temp = (int)(x + xMove + hitBox.x + hitBox.width)/Tile.TILE_WIDTH;
            if(!TileCollision(temp, (int)(y + hitBox.y)/ Tile.TILE_HEIGHT)  &&
                    !TileCollision(temp, (int)(y + hitBox.y + hitBox.height)/ Tile.TILE_HEIGHT)){
                x += xMove;
            }
            else{//There is a collision
            //Convert to pixel coordinates and set x of hitbox to x of tile you can't cross    
            x = temp * Tile.TILE_WIDTH - hitBox.x - hitBox.width -1; 
            
        }
        }
        else if(xMove < 0){ //moving left
            int temp = (int)(x + xMove + hitBox.x)/Tile.TILE_WIDTH;
            if(!TileCollision(temp, (int)(y + hitBox.y)/ Tile.TILE_HEIGHT)  &&
                    !TileCollision(temp, (int)(y + hitBox.y + hitBox.height)/ Tile.TILE_HEIGHT)){
                x += xMove;
            }
            else{
                x = temp*Tile.TILE_WIDTH + Tile.TILE_WIDTH - hitBox.x;
            }
        }
        
        
    }
    
    public void moveY(){
        if(yMove < 0 ){//Up
            int temp = (int)(y + yMove + hitBox.y)/Tile.TILE_HEIGHT;
            if(!TileCollision((int)(x + hitBox.x)/Tile.TILE_WIDTH,temp) && 
                    !TileCollision((int)(x + hitBox.x + hitBox.width)/Tile.TILE_WIDTH,temp)){
                y += yMove;
            
        }
            else{
                y = temp*Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - hitBox.y;
            }
        }
        else if(yMove > 0){//Down
            int temp = (int)(y + yMove + hitBox.y + hitBox.height)/Tile.TILE_HEIGHT;
            if(!TileCollision((int)(x + hitBox.x)/Tile.TILE_WIDTH,temp) && 
                    !TileCollision((int)(x + hitBox.x + hitBox.width)/Tile.TILE_WIDTH,temp)){
                y += yMove;
            
        }
            else{
            y = temp * Tile.TILE_HEIGHT - hitBox.y - hitBox.height -1; 
            
        }
            }
        
    }
    
    protected boolean TileCollision(int x, int y){
        return handler.getLevel().getTile(x,y).isSolid();
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    
}
