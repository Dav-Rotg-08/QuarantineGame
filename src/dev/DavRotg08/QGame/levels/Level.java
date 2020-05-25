
package dev.DavRotg08.QGame.levels;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.EntityManager;
import dev.DavRotg08.QGame.entities.Player;
import dev.DavRotg08.QGame.entities.statics.Rock;
import dev.DavRotg08.QGame.entities.statics.Shrine;
import dev.DavRotg08.QGame.entities.statics.Tree;
import dev.DavRotg08.QGame.entities.weapons.WeaponManager;
import dev.DavRotg08.QGame.tiles.Tile;
import dev.DavRotg08.QGame.utils.Utils;
import java.awt.Graphics;


public class Level {
    private Handler handler;
    private int width, height;
    private int xPos, yPos;
    
    
    //multi dimensional array
    private int[][] tiles;
    
    //Entity Manager
    private EntityManager em;
    
    //Weapon Manager
    private WeaponManager wm;
    
    public Level(Handler handler, String path){
        this.handler = handler;
        em = new EntityManager(handler, new Player(handler,300,300));
        
        loadLevel(path);
        em.addEntity(new Tree(handler, 260, 260));
        // em.addEntity(new Shrine(handler, 500, 500));
        
        for(int i=0; i< handler.getHeight(); i+= 100){
            em.addEntity(new Rock(handler, 200, i));
        }
        
        //Set X/Y spawn based on what is specified in level file
        em.getPlayer().setX(xPos);
        em.getPlayer().setY(yPos);
        
        wm = new WeaponManager(handler, em.getPlayer());
        
    }
    
    public void tick(){
        
        em.tick();
        wm.tick();
        
    }
    
    public void render(Graphics g){
        //maximizing the efficiency of rendering map, only rendering part of map that can be seen
        int xStart = (int)Math.max(0, handler.getCamera().getxOffset()/Tile.TILE_WIDTH);
        int yStart = (int)Math.max(0, handler.getCamera().getyOffset()/Tile.TILE_HEIGHT);
        int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth())/ Tile.TILE_WIDTH + 1);
        int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight())/ Tile.TILE_HEIGHT + 1);
        for(int y=yStart; y < yEnd; y++){
            for(int x=xStart; x< xEnd; x++){
                /*When rendering, multiply by tile width and height to get 
                true size of level, we want size of every tile, not 1 pixel by 1 pixel. 
                Also, x/y offsets are to move the tiles around based on camera view*/
                getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getCamera().getxOffset()), 
                        (int)(y*Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
                
            }
        }
        
        //Render entities
        em.render(g);
        wm.render(g);
        
    }
    
    //getting a tile from array and finding its id
    public Tile getTile(int x, int y){
       //If player is off the map
       if(x<0 ||y<0 ||x >= width||y >= height){
           return Tile.grass;
           
       }
       Tile found = Tile.tilesArr[tiles[x][y]] ;
       if(found == null){
           //return default tile if tile not found
           return Tile.tree;
       }
       return found;
    }
    
    private void loadLevel(String path){
        String file = Utils.loadFile(path);
        //Splitting file based on whitespace
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        xPos = Utils.parseInt(tokens[2]);
        yPos = Utils.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[x][y]= Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return em;
    }
    public WeaponManager getWeaponManager() {
        return wm;
    }
}
