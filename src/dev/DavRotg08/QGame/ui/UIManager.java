
package dev.DavRotg08.QGame.ui;

import dev.DavRotg08.QGame.Handler;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class UIManager {
    
    private Handler handler;
    private ArrayList<UIObject> ui_objs;
    public UIManager(Handler handler){
        this.handler = handler;
        ui_objs = new ArrayList<UIObject>();
        
    }
    
    public void tick(){
        for(UIObject obj : ui_objs)
            obj.tick();
    }
    
    public void render(Graphics g){
        for(UIObject obj : ui_objs)
            obj.render(g);
    }
    
    //Check to see if mouse is hovering over UI element
    public void onMouseHover(MouseEvent e){
        for(UIObject obj : ui_objs)
            obj.onMouseHover(e);
        
    }
    
    //What occurs after user has clicked whatever they were hovering over
    public void onMouseRelease(MouseEvent e){
        for(UIObject obj : ui_objs)
            obj.onMouseRelease(e);
        
        
    }
    
    public void addUIObject(UIObject obj){
        ui_objs.add(obj);
    }
    
    public void removeUIObject(UIObject obj){
        ui_objs.remove(obj);
    }
    
    //Setters and Getters

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getUi_objs() {
        return ui_objs;
    }

    public void setUi_objs(ArrayList<UIObject> ui_objs) {
        this.ui_objs = ui_objs;
    }
    
}
