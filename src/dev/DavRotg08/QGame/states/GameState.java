package dev.DavRotg08.QGame.states;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Player;
import dev.DavRotg08.QGame.entities.statics.Tree;
import dev.DavRotg08.QGame.gfx.Assets;
import dev.DavRotg08.QGame.levels.Level;
import dev.DavRotg08.QGame.tiles.Tile;
import java.awt.Graphics;


public class GameState extends State {
    
    private Player player;
    
    //initialize a Level
    private Level level;
    
    
    
    public GameState(Handler handler){
        super(handler);
        level = new Level(handler, "res/levels/level2.txt");
        handler.setLevel(level);
        player = new Player(handler, 500, 500);
        
        
        
        
    }

    @Override
    public void tick() {
        level.tick();
        player.tick();
        
        
       
        
    }

    @Override
    public void render(Graphics g) {
        //rendering the level
        level.render(g);
        
        
        //render player after everything so he is in front of tiles
        //player.render(g);
        
        
       
    }
    
}
