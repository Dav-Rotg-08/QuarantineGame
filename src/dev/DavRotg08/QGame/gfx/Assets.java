
package dev.DavRotg08.QGame.gfx;

import java.awt.image.BufferedImage;


public class Assets {
    //make final ints for all sprites cut from sprite sheet
    private static final int width = 32, height = 32;
    private static final int pWidth = 64, pHeight = 64;
    public static BufferedImage static_player, grass, dirt, tree, bigTree, shrine,
            pond, rock, cherryBloss, dirtGrass, smallDirt, wood, rockDrop, key, arrow ;
    //public static BufferedImage player;
    
    //Making  BufferedImage arrays for animating the player
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    
    
    
    //BunnySlime BufferedImage Arrays
    public static BufferedImage[] bSlime_Down, bSlime_Left, bSlime_Right, bSlime_Up;
    
    //Menu Button Array
    public static BufferedImage[] btn_anim;
    
    
    //loading in all assets to game, music, sound, textures, etc.
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Nature.png"));
        SpriteSheet playerAnim = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerAnim.png"));
        SpriteSheet v2 = new SpriteSheet(ImageLoader.loadImage("/textures/moreSprites.png"));
        SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/Items.png")); 
        
        //PLAYER ANIMS
        //Down Animations
        player_down = new BufferedImage[2];
        player_down[0] = playerAnim.cutOut(pWidth, 0, pWidth, pHeight);
        player_down[1] = playerAnim.cutOut(pWidth*2, 0, pWidth, pHeight);
        
        //Up animations
        player_up = new BufferedImage[3];
        player_up[0] = playerAnim.cutOut(pWidth*3, pHeight, pWidth, pHeight);
        player_up[1] = playerAnim.cutOut(pWidth*4, pHeight, pWidth, pHeight);
        player_up[2] = playerAnim.cutOut(pWidth*5, pHeight, pWidth, pHeight);
        
        //left animations
        player_left = new BufferedImage[3];
        player_left[0] = playerAnim.cutOut(0, pHeight, pWidth, pHeight);
        player_left[1] = playerAnim.cutOut(pWidth, pHeight, pWidth, pHeight);
        player_left[2] = playerAnim.cutOut(pWidth*2, pHeight, pWidth, pHeight);
        
        //Right animations
        player_right = new BufferedImage[3];
        player_right[0] = playerAnim.cutOut(pWidth*3, 0, pWidth, pHeight);
        player_right[1] = playerAnim.cutOut(pWidth*4, 0, pWidth, pHeight);
        player_right[2] = playerAnim.cutOut(pWidth*5, 0, pWidth, pHeight);
        
        //BUNNYSLIME ANIMATIONS
        //Down
        bSlime_Down = new BufferedImage[5];
        bSlime_Down[0] = v2.cutOut(0, 0, pWidth, pHeight);
        bSlime_Down[1] = v2.cutOut(pWidth, 0, pWidth, pHeight);
        bSlime_Down[2] = v2.cutOut(pWidth*2, 0, pWidth, pHeight);
        bSlime_Down[3] = v2.cutOut(0, pWidth, pWidth, pHeight);
        bSlime_Down[4] = v2.cutOut(pWidth, pHeight, pWidth, pHeight);
        
        //Left
        bSlime_Left = new BufferedImage[5];
        bSlime_Left[0] = v2.cutOut(pWidth*3, 0, pWidth, pHeight);
        bSlime_Left[1] = v2.cutOut(pWidth*4, 0, pWidth, pHeight);
        bSlime_Left[2] = v2.cutOut(pWidth*5, 0, pWidth, pHeight);
        bSlime_Left[3] = v2.cutOut(pWidth*4, pHeight, pWidth, pHeight);
        bSlime_Left[4] = v2.cutOut(pWidth*5, pHeight, pWidth, pHeight);
        
        //Up
        bSlime_Up = new BufferedImage[5];
        bSlime_Up[0] = v2.cutOut(0, 0, pWidth, pHeight);
        bSlime_Up[1] = v2.cutOut(pWidth, 0, pWidth, pHeight);
        bSlime_Up[2] = v2.cutOut(pWidth*2, 0, pWidth, pHeight);
        bSlime_Up[3] = v2.cutOut(0, pWidth, pWidth, pHeight);
        bSlime_Up[4] = v2.cutOut(pWidth, pHeight, pWidth, pHeight);
        
        //Right
        bSlime_Right = new BufferedImage[5];
        bSlime_Right[0] = v2.cutOut(pWidth*3, 0, pWidth, pHeight);
        bSlime_Right[1] = v2.cutOut(pWidth*4, 0, pWidth, pHeight);
        bSlime_Right[2] = v2.cutOut(pWidth*5, 0, pWidth, pHeight);
        bSlime_Right[3] = v2.cutOut(pWidth*4, pHeight, pWidth, pHeight);
        bSlime_Right[4] = v2.cutOut(pWidth*5, pHeight, pWidth, pHeight);
        
        //Button animations
        btn_anim = new BufferedImage[2];
        btn_anim[0] = v2.cutOut(pWidth*2, pHeight, pWidth*2, pHeight);
        btn_anim[1] = v2.cutOut(pWidth*2, pHeight*2, pWidth*2, pHeight);
        
        
        
        //set sprites to Image variables
        static_player = playerAnim.cutOut(0, 0, pWidth, pHeight);
        grass = sheet.cutOut(0, 0, width, height);
        smallDirt = sheet.cutOut(width, 0, width, height);
        dirtGrass = sheet.cutOut(2*width, 0, width, height);
        cherryBloss = sheet.cutOut(3*width, 0, width, height);
        dirt = sheet.cutOut(4*width, 0, width, height);
        tree = sheet.cutOut(5*width, 0, width, height);
        bigTree = sheet.cutOut(6*width, 0, width, height);
        rock = sheet.cutOut(7*width, 0, width, height);
        shrine = sheet.cutOut(8*width, 0, width, height);
        pond = sheet.cutOut(9*width, 0, width, height);
        //wood, rockDrop, key, arrow 
        wood = items.cutOut(0, 0, width, height);
        rockDrop = items.cutOut(width, 0, width, height);
        key = items.cutOut(width*2, 0, width, height);
        arrow = items.cutOut(width*3, 0, width, height);
        
    }
    
}
