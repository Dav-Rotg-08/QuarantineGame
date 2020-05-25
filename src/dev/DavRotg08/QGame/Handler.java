
package dev.DavRotg08.QGame;

import dev.DavRotg08.QGame.gfx.Camera;
import dev.DavRotg08.QGame.input.InputManager;
import dev.DavRotg08.QGame.input.MouseManager;
import dev.DavRotg08.QGame.levels.Level;


public class Handler {
    
    private Game game;
    private Level level;
    
    public Handler(Game game){
        
        this.game = game;
        
    }
    
    public Camera getCamera(){
       return game.getCamera();
    }
    
    public InputManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
