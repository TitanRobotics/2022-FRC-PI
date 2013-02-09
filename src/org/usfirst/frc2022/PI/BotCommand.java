/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI;

import java.net.Inet4Address;

/**
 *
 * @author Michael
 */
public class BotCommand {
    
    public BotCommand(){
        
    }
    
    public void update(String Type, String[] atr){
        int doCommand = getType(Type);
        
        //use switch
        //update vars
        
    }
    
    public void process(String Type){
        
    }
    
    public int send(){
        
        return 666;
    }

    private int getType(String Type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
