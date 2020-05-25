
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;

public class PondTile extends Tile{
    
    public PondTile(int id){
        super(Assets.pond, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
