/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI;

/**
 *
 * @author Michael
 */
public class Program {

    static ImageProcessor imageProcessor;
    static SocketServer socket;
    static int PORT;
    
    public static void main(String args[]){
        
        PORT = 4444;
        socket = new SocketServer(PORT);
        socket.start();
        
        imageProcessor = new ImageProcessor();
        if (socket.getConnectionStatus()){
            //imageProcessor.processImage();
            //input/output at socket.getInputStream/socket.getOutputStream()
            //TODO: send back info only if robot sends us something
            
        }
       
    }
    
}
