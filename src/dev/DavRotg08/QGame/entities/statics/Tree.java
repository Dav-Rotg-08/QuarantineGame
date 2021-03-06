package dev.DavRotg08.QGame.entities.statics;

import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.gfx.Assets;
import dev.DavRotg08.QGame.tiles.Tile;
import java.awt.Graphics;

public class Tree extends StaticEntity {
    
    public Tree(Handler handler, float x, float y){
        //Tree will be width of a tile and height of a tile
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        
        //Hitbox of Tree, can change later
        hitBox.x = 10;
        hitBox.y = (int)(height/1.5f);
        hitBox.width = (int)(width - width/1.5f);
        hitBox.height = (int)(height - height/1.5f);
       
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
         g.drawImage(Assets.tree, (int)(x - handler.getCamera().getxOffset()), 
                 (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
    
    @Override
    public void onDeath() {
        System.out.println("Game Over");
    }
    
}
