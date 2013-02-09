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
    
    public SocketServer server;
    
    public BotCommand(){
        
    }
    
    public void update(String Type, String atr){
        int doCommand = getType(Type);
        String[] attributes = getAttributes(atr);
        
        //use switch
        //update vars
        
    }
    
    public void create(String Type){
        
    }
    
    public int send(){
        
        try{
            //output from server
            return 0;
        } catch(Exception e){
            e.printStackTrace();
            return 404;
        }
    }

    private int getType(String Type) {
        if(Type.equals("MOVEMENT")){
            return 1;
        }else if(Type.equals("CAMOUTOFRANGE")){
            return 2;
        }else{
            return 404;
        }
    }

    private String[] getAttributes(String atr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setServer(SocketServer socket) {
        server = socket;
    }
    
}
