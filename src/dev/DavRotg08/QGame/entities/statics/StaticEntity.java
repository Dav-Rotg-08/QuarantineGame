
package dev.DavRotg08.QGame.entities.statics;

//Entities that don't change, i.e., tree/rock

import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Entity;

public abstract class StaticEntity extends Entity {
    
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }
    
}
