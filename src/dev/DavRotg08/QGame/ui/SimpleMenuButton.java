
package dev.DavRotg08.QGame.ui;

import dev.DavRotg08.QGame.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class SimpleMenuButton extends UIObject{
    
    private BufferedImage[] images;
    private ClickListener click;
    public SimpleMenuButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener click){
        super(x,y,width,height);
        this.images = images;
        this.click = click;
        
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(hovering)
            g.drawImage(images[1], (int)x, (int)y, width, height, null);
        else
            g.drawImage(images[0], (int)x, (int)y, width, height, null);
            
        
    }

    @Override
    public void onClick() {
        click.onClick();
        
    }
    
}
