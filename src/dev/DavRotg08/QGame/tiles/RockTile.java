
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;


public class RockTile extends Tile {
    
    public RockTile(int id){
        super(Assets.rock, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
