package dev.DavRotg08.QGame.entities.weapons;

import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Creature;
import dev.DavRotg08.QGame.entities.Entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Weapon {

    //Default dmg, critChance, width, height
    protected static final int DEFAULT_WIDTH = Creature.DEFAULT_WIDTH / 2;
    protected static final int DEFAULT_HEIGHT = Creature.DEFAULT_HEIGHT / 2;
    protected static final int DEFAULT_DMG = 10;
    protected static final double DEFAULT_CRIT = 0.2;

    //Size of area weapon exists in
    Rectangle weaponSize;

    protected Handler handler;
    protected Creature creature;

    //Positions and sizes for weapon
    protected int height, width;
    protected float x, y;

    //Damage Calculations
    protected double critChance;
    protected int dmg;
    
    //Determining Cooldowns for attacks
    private long attackFired;
    private long cooldown = 700;
    private long attackTimer = cooldown;

    public Weapon(Handler handler, Creature creature, int width,
            int height, int dmg, double critChance) {

        this.handler = handler;
        this.creature = creature;
        this.height = height;
        this.width = width;

        //Change dmg and critChance with every new Weapon so dmgDealt() is unique!!
        dmg = DEFAULT_DMG;
        critChance = DEFAULT_CRIT;

        //Generic weapon size, same width/height as sprite
        weaponSize = new Rectangle();

    }

    public void getAttack() {
        
        attackTimer += System.currentTimeMillis() - attackFired;
        attackFired = System.currentTimeMillis();
        
        //Check to see if player is eligible to attack
        if(attackTimer < cooldown){
            return;
        }

        Rectangle creatureHB = creature.getHitBox(0, 0);
        int aSize = 20;
        weaponSize.width = aSize;
        weaponSize.height = aSize;
        float creatureX = creature.getxMove();
        float creatureY = creature.getyMove();

        if (creatureY < 0 && handler.getKeyManager().basicAttack) { //Up
            System.out.println("Attacking UP:");
            weaponSize.x = creatureHB.x + creatureHB.width / 2 - aSize / 2;
            weaponSize.y = creatureHB.y - aSize;
            System.out.println("Damage Done:" + dmgDealt());
        } else if (creatureY > 0 && handler.getKeyManager().basicAttack) {//Down
            weaponSize.x = creatureHB.x + creatureHB.width / 2 - aSize / 2;
            weaponSize.y = creatureHB.y + creatureHB.height;
        } else if (creatureX < 0 && handler.getKeyManager().basicAttack) {//left
            weaponSize.x = creatureHB.x - aSize;
            weaponSize.y = creatureHB.y + creatureHB.height / 2 - aSize / 2;
        } else if (creatureX > 0 && handler.getKeyManager().basicAttack) {//right
            weaponSize.x = creatureHB.x + creatureHB.width;
            weaponSize.y = creatureHB.y + creatureHB.height / 2 - aSize / 2;
        } else {
            return;
        }
        //Attack Executed
        attackTimer = 0;
        for (Entity e : handler.getLevel().getEntityManager().getEntities()) {
            if (e.equals(creature)) {
                System.out.println("I'm hitting myself");
                System.out.println("My hp:" + creature.getHp());
                continue;
            }
            if (e.getHitBox(0, 0).intersects(weaponSize)) {
                System.out.println("Entity Health Before: " + e.getHp());
                e.dmgTaken(dmgDealt());
                System.out.println("Entity Health: " + e.getHp());
                //Hitting one enemy at a time, per tick
                return;
            }
        }
    }

    public int dmgDealt() {
        //double critChance, double attackSpeed
        Random rand = new Random();
        int val = rand.nextInt(99);
        if (val <= critChance - 1) {
            //Critical Hit!
            System.out.println("Critical Hit!");
            return dmg * 2;
        } else {
            return dmg;
        }

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    //Getters and Setters
    public Rectangle getWeaponSize() {
        return weaponSize;
    }

    public void setWeaponSize(Rectangle weaponSize) {
        this.weaponSize = weaponSize;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

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

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

}
