package dev.DavRotg08.QGame.entities.weapons;

import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Player;
import java.awt.Graphics;
import java.util.ArrayList;

public class WeaponManager {

    private Handler handler;
    private Player player;
    private ArrayList<Weapon> weapons;

    public WeaponManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;

        weapons = new ArrayList<Weapon>();
        Punch punch = new Punch(handler, player);
        addWeapon(punch);
    }

    public void addWeapon(Weapon x) {
        weapons.add(x);
    }

    public void render(Graphics g) {
        for (Weapon x : weapons) {

            x.render(g);

        }
    }

    public void tick() {

        for (Weapon x : weapons) {
            
            x.tick();

        }

    }

    //Setter/Getters

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

   
    
}
