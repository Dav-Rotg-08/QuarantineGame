package dev.DavRotg08.QGame;

import dev.DavRotg08.QGame.display.Display;
import dev.DavRotg08.QGame.gfx.Assets;
import dev.DavRotg08.QGame.gfx.Camera;
import dev.DavRotg08.QGame.gfx.ImageLoader;
import dev.DavRotg08.QGame.gfx.SpriteSheet;
import dev.DavRotg08.QGame.input.InputManager;
import dev.DavRotg08.QGame.input.MouseManager;
import dev.DavRotg08.QGame.states.GameState;
import dev.DavRotg08.QGame.states.MenuState;
import dev.DavRotg08.QGame.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


//Game class implements runnable to run on a separate thread
public class Game implements Runnable {
    
    private Display display;
    public String title;
    private int width, height;
    private boolean running = false;
    
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //private BufferedImage background;
    
    
    //All Game States
    public State playGame;
    private State menu;
    
    //Input Manager
    private InputManager keyManager;
    
    //Mouse Manager
    private MouseManager mouseManager;
    
    //Camera
    private Camera camera;
    
    //Handler
    private Handler handler;
    
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new InputManager();
        mouseManager = new MouseManager();
        
        
    }
    
    private void init(){
        display = new Display(title, width, height);
        //initialize all assets
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        //sprites = ImageLoader.loadImage("/textures/sprites.png");
        //sheet = new SpriteSheet(sprites);
        
        //initializing camera at (0,0)
        handler = new Handler(this);
        camera = new Camera(handler,0,0);
        
       
        
        playGame = new GameState(handler);
        menu = new MenuState(handler);
       // State.setState(playGame);
       State.setState(menu);
        
    }
    
    //constant update for Game loop
    private void update(){
        keyManager.tick();
        if(State.getState() != null){
            State.getState().tick();
        }
        
    }
    
    //rendering of game after every update cycle
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        //At start of game, there is no buffer strategy, so initialize 3 buffers
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Start of graphics being drawn
        //g.drawImage(background, 0, 0, null);
        //g.drawImage(Assets.tree, 10, 10, null);
         if(State.getState() != null){
            State.getState().render(g);
        }
        //End of graphics drawn
        
        bs.show();
        g.dispose();
    }

    //run method for runnable
    @Override
    public void run() {
        init();
        
        //controlling the game clock
        int fps = 60;
        
        //maximum time allowed per tick
        double timePerTick = 1000000000/fps;
        
        //Other important time variables
        double delta = 0;
        long now;
        
        //current time
        long lastTime = System.nanoTime();
        
        //These two variables will monitor the fps
        long timer = 0;
        int ticks = 0;
        

        //Main Loop of Game
        while(running){
            now = System.nanoTime();
            delta += (now-lastTime)/timePerTick;
            
            //For monitoring FPS
            timer += now - lastTime;
            
            //updating last time this was executed
            lastTime = now;
            
            if(delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }
            
            //printing to the console the FPS
            if(timer >= 1000000000){
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    
    //start and stop methods for thread
    public synchronized void start(){
        if(running){
            return;
        }
        //start thread with this Game class
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    public InputManager getKeyManager(){
        return keyManager;
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public Camera getCamera(){
        return camera;
        
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    //Stopping thread safelt with thread.join, but needs try/catch block
    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
            
        }
        
    }
    
}
