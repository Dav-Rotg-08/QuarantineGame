
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;


public class TealShrineTile extends Tile {
    
    public TealShrineTile(int id){
        super(Assets.shrine, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
