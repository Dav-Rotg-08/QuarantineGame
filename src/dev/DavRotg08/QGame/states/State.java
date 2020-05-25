
package dev.DavRotg08.QGame.states;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import java.awt.Graphics;


public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State s){
        currentState = s;
    }
    
    public static State getState(){
        return currentState;
    }
    
    protected Handler handler;
    
    //constructor
    public State(Handler handler){
        this.handler = handler;
    }
    //generic abstract methods every State will need to fill
    public abstract void tick();
    public abstract void render(Graphics g);
        
    
    
}
