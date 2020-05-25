
package dev.DavRotg08.QGame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;


public abstract class UIObject {
    
    protected float x,y;
    protected int width, height;
    protected boolean hovering;
    protected Rectangle ui_shape;
        
    
    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        ui_shape = new Rectangle((int)x, (int)y, width, height);
        
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public abstract void onClick();
    
    //helper methods
    
    //Check to see if mouse is hovering over UI element
    public void onMouseHover(MouseEvent e){
        if(ui_shape.contains(e.getX(), e.getY())){
            hovering = true;
        }
        else{
            hovering = false;
        }
        
    }
    
    //What occurs after user has clicked whatever they were hovering over
    public void onMouseRelease(MouseEvent e){
        if(hovering)
            //Call abstract method that each ui object has to define themselves
            onClick();
        
    }
    
    //Getters/Setters

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
    
    
}
