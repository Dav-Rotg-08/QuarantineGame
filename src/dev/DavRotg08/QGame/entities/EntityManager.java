
package dev.DavRotg08.QGame.entities;

import dev.DavRotg08.QGame.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//Will manage all entities within the Gamestate
public class EntityManager {
    
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    
    
//Make a comparator to sort arraylist in terms of render order (By entity's bottom y-coord)
    private Comparator<Entity> renderOrder = new Comparator<Entity>(){
        @Override
        public int compare(Entity e1, Entity e2){
            if(e1.getY() + e1.getHeight() < e2.getY() + e2.getHeight()){
                return -1;
            }else{
                return 1;
            }
        }
    };
    
   
    
    
    
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        
        //Add player to Arraylist of entities
        addEntity(player);
    
    }
    
    public void tick(){
        //Using iterator to tick all entities that haven't been destroyed
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext()){
            Entity e = iter.next();
            e.tick();
            if(e.isDestroyed()){
                iter.remove();
            }
        }
        entities.sort(renderOrder);
        
        
        
    }
    
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        
        
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }
    
    
    //Getters/Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
