package dev.DavRotg08.QGame.entities.weapons;

import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.entities.Creature;
import dev.DavRotg08.QGame.entities.Entity;
import dev.DavRotg08.QGame.entities.Player;
import dev.DavRotg08.QGame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.Graphics;

import java.awt.Graphics;

import java.awt.Graphics;
import java.util.Random;

public class Punch extends Weapon {

    public Punch(Handler handler, Creature creature) {
        super(handler, creature, Weapon.DEFAULT_WIDTH, Weapon.DEFAULT_HEIGHT, 15, 0.3);

        //setting dmg and crit
        super.dmg = 15;
        super.critChance = 0.3;

        //Animations
    }

    @Override
    public void tick() {
        getAttack();

    }

    @Override
    public void render(Graphics g) {
        if (handler.getGame().getKeyManager().basicAttack) {
            g.drawImage(Assets.rock, (int) (weaponSize.x - handler.getGame().getCamera().getxOffset()),
                    (int) (weaponSize.y - handler.getGame().getCamera().getyOffset()), width, height, null);
        } else {
            return;
        }

    }

}
