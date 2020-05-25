
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;


public class bigTreeTile extends Tile  {
    
    public bigTreeTile(int id){
        super(Assets.bigTree, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
