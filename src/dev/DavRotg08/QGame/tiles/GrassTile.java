
package dev.DavRotg08.QGame.tiles;

import dev.DavRotg08.QGame.gfx.Assets;
import java.awt.image.BufferedImage;

public class GrassTile extends Tile {
    
    //only need ID because grass tile imported from assets
    public GrassTile(int id){
        super(Assets.grass, id);
        
    }
    
}
