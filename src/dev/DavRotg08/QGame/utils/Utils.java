
package dev.DavRotg08.QGame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//helper functions that will help anytime we need them
public class Utils {
    
    public static String loadFile(String path){
        
        StringBuilder builder = new StringBuilder();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while((line = reader.readLine()) != null){
                builder.append(line + "\n");
            }
            reader.close();
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
        return builder.toString();
        
    }
    
    public static int parseInt(String num){
        
        try{
            return Integer.parseInt(num);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
    
}
