
package dev.DavRotg08.QGame.states;

import dev.DavRotg08.QGame.Game;
import dev.DavRotg08.QGame.Handler;
import dev.DavRotg08.QGame.gfx.Assets;
import dev.DavRotg08.QGame.gfx.ImageLoader;
import dev.DavRotg08.QGame.ui.ClickListener;
import dev.DavRotg08.QGame.ui.SimpleMenuButton;
import dev.DavRotg08.QGame.ui.UIManager;
import dev.DavRotg08.QGame.ui.UIObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class MenuState extends State {
    
    //UI Manager
    private UIManager manager;
    
    private BufferedImage menuBackground;
    //constructor
    public MenuState(Handler handler){
        super(handler);
        menuBackground = ImageLoader.loadImage("/textures/back.png");
        manager = new UIManager(handler);
        
        //Set the UI manager to the moust manager, or else the ui object won't be clickable
        handler.getMouseManager().setUIManager(manager);
        
        //Add all the ui objects for this menu state
        manager.addUIObject(new SimpleMenuButton(500,500,128,128, Assets.btn_anim, new ClickListener(){
            @Override
            public void onClick(){
                //Turn off the UIManager when switching states
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().playGame);
            
        }
        }));
        
    }

    @Override
    public void tick() {
        manager.tick();
         
    }

    @Override
    public void render(Graphics g) {
        g.clearRect(0, 0, handler.getWidth(), handler.getHeight());
        g.drawImage(menuBackground, 0, 0, null);
        g.setColor(Color.RED);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
        manager.render(g);
        
    }
    
}
