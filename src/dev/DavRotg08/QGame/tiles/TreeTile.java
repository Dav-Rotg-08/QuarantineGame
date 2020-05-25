
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;


public class TreeTile extends Tile{
    
    public TreeTile(int id){
        super(Assets.tree, id);
        
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
