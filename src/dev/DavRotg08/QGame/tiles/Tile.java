
package dev.DavRotg08.QGame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tile {
    
    //Static Elements
    public static Tile[] tilesArr = new Tile[256];
    public static Tile grass = new GrassTile(0);
    public static Tile tree = new TreeTile(1);
    public static Tile sand = new SandTile(2);
    public static Tile rock = new RockTile(3);
    public static Tile tealShrine = new TealShrineTile(4);
    public static Tile pond = new PondTile(5);
    public static Tile bigTree = new bigTreeTile(6);
    public static Tile cherryBloss = new CherryBlossomTile(7);
    public static Tile grassDirt = new GrassyDirtTile(8);
    
    
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    
    protected BufferedImage image;
    protected final int id;
    
    public Tile(BufferedImage image, int id){
        this.image = image;
        this.id = id;
        
        /*when you make a new tile, it adds that tile to the array at the
        index of its id */
        tilesArr[id]= this;
        
    }
    
    public void tick(){
        
    }
    public void render(Graphics g, int x, int y){
        g.drawImage(image, x, y,TILE_WIDTH, TILE_HEIGHT, null);
        
    }
    
    //Determining if a Tile is solid or not
    public boolean isSolid(){
        return false;
    }
    
    public int getID(){
        return id;
    }
}
