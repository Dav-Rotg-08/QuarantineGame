package dev.DavRotg08.QGame.entities;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.tiles.Tile;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    //Default hp
    public static final int DEFAULT_HP = 100;
    protected int hp;

    //game object, contains input manager/ settings of game
    protected Handler handler;

    //protected variables for position so subclasses can access
    protected float x, y;

    //Collision Hitbox
    protected Rectangle hitBox;

    //values for resizing
    protected int width, height;
    protected float xMove, yMove;
    
    protected boolean destroyed = false;

    public Entity(Handler handler, float x, float y, int width, int height) {
        hp = DEFAULT_HP;
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        xMove = 0;
        yMove = 0;

        //generic hitbox is same size as sprite
        hitBox = new Rectangle(0, 0, width, height);

    }

    //Helper functions for collision detection, DO QUADTREES LATER!!!
    //Method to see if any entity in the game has collided with "this" entity
    public boolean checkCollisions(float xOffset, float yOffset) {
        for (Entity e : handler.getLevel().getEntityManager().getEntities()) {
            if(e.equals(this)){
                //skip checking if the selected entity equals itself in arraylist
                continue;
            }
            if (e.getHitBox(0f, 0f).intersects(getHitBox(xOffset, yOffset))) {
                return true;
            }

        }
        return false;
    }
    
    /*xOffset and yOffset tells hitBox where the entity is moving so hitbox also moves!
    check Creature class, move() method for more details on this */
    public Rectangle getHitBox(float xOffset, float yOffset) {

        //Check current x, plus x of hitbox, plus where we are moving to (Offset)
        return new Rectangle((int) (x + hitBox.x + xOffset), (int) 
                (y + hitBox.y + yOffset), hitBox.width, hitBox.height);
    }
    
    //Damage taken
    public void dmgTaken(int amt){
        hp -= amt;
        if(hp <= 0){
            destroyed = true;
            onDeath();
        }
    }
    
    //Method for entity to do something on Death
    public abstract void onDeath();

    //GETTERS AND SETTERS
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    

    public abstract void tick();

    public abstract void render(Graphics g);
}
