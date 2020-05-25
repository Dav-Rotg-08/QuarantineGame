package dev.DavRotg08.QGame.entities;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.weapons.Punch;
import dev.DavRotg08.QGame.entities.weapons.Weapon;
import dev.DavRotg08.QGame.gfx.Animation;
import dev.DavRotg08.QGame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Player extends Creature {

    //Weapon Queue, current weapon being used.
    Queue<Weapon> weaponQueue;

    //Animations
    private Animation walkDown, walkRight, walkUp, walkLeft;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_HEIGHT, Creature.DEFAULT_WIDTH);

        //16 pixels to the left of the player's x coord
        hitBox.x = 16;

        //32 pixels down of player's x coord
        hitBox.y = 32;
        hitBox.height = 32;
        hitBox.width = 32;

        //Animations Initialized
        walkDown = new Animation(320, Assets.player_down);
        walkRight = new Animation(320, Assets.player_right);
        walkLeft = new Animation(320, Assets.player_left);
        walkUp = new Animation(320, Assets.player_up);

        //initialize weaponQueue
        weaponQueue = new LinkedList<Weapon>();

        //Add punch to Player
        Punch basicAtk = new Punch(handler, this);
        addWeaponToQ(basicAtk);

    }

    public void debug() {
        if (!weaponQueue.isEmpty()) {
            System.out.println("Punch found");
        } else {
            System.out.println("Punch not Found");
        }
    }

    @Override
    public void tick() {
        //Implement Animation Tick
        walkDown.tick();
        walkLeft.tick();
        walkRight.tick();
        walkUp.tick();
        getInput();
        move();
        
        System.out.println("Sprite X: " + (int) (x - handler.getCamera().getxOffset()));
       

        //Center Camera on player
        handler.getCamera().centerOnEntity(this);

        //Attacks
        currentWeapon().getAttack();
         
        //playerAttack();
    }

    public void addWeaponToQ(Weapon x) {
        weaponQueue.add(x);
    }

    public Weapon currentWeapon() {
        return weaponQueue.peek();
    }

    /*
    private void playerAttack() {
        Rectangle hb = getHitBox(0, 0);
		Rectangle attack = new Rectangle();
		int aSize = 20;
		attack.width = aSize;
		attack.height = aSize;
		
		if(yMove < 0 && handler.getKeyManager().basicAttack){ //Up
			attack.x = hb.x + hb.width / 2 - aSize / 2;
			attack.y = hb.y - aSize;
		}else if(yMove > 0 &&  handler.getKeyManager().basicAttack){//Down
			attack.x = hb.x + hb.width / 2 - aSize / 2;
			attack.y = hb.y + hb.height;
		}else if(xMove < 0 && handler.getKeyManager().basicAttack){//left
			attack.x = hb.x - aSize;
			attack.y = hb.y + hb.height / 2 - aSize / 2;
		}else if(xMove > 0 && handler.getKeyManager().basicAttack){//right
			attack.x = hb.x + hb.width;
			attack.y = hb.y + hb.height / 2 - aSize / 2;
		}else{
			return;
		}

        for (Entity e : handler.getLevel().getEntityManager().getEntities()) {
            if(e.equals(this)){
                continue;
            }
            if (e.getHitBox(0, 0).intersects(attack)) {
                e.dmgTaken(10);
                //Hitting one enemy at a time, per tick
                return;
            }
        }

    } */
    //Method for capturing user input and moving player
    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        //drawing Player
        g.drawImage(getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()), width, height, null);
        
      
      

        //g.drawImage(getCurrentFrame(), (int) (x),
        //      (int) (y), width, height, null);
        //Code below is to Debug Hitbox
        /*g.setColor(Color.red);
        g.fillRect((int)(x + hitBox.x - handler.getCamera().getxOffset()),
                (int)(y + hitBox.y - handler.getCamera().getyOffset()), 
                hitBox.width, hitBox.height ); */
    }

    private BufferedImage getCurrentFrame() {
        if (xMove < 0) { //moving left
            return walkLeft.currentFrame();
        } else if (xMove > 0) { //moving right
            return walkRight.currentFrame();
        } else if (yMove < 0) { //moving up
            return walkUp.currentFrame();
        } else if (yMove > 0) { //moving down
            return walkDown.currentFrame();
        } else {
            return Assets.static_player;
        }
    }

    @Override
    public void onDeath() {
        System.out.println("Game Over");
    }

}
