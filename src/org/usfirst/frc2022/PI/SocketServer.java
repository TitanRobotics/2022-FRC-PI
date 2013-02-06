package org.usfirst.frc2022.PI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server-side code for the socket communication between the robot
 * and the Raspberry Pi.
 * 
 * @param clientPort Port that the socket is on
 * @return
 */
public class SocketServer extends Thread{
    
    public ServerSocket serverSocket;
    DataInputStream input;
    DataOutputStream out;
    int PORT;
    boolean connected;
    
    public SocketServer(int clientPort){
        PORT  = clientPort; //4444 testing port
        
        try{
            serverSocket = new ServerSocket(PORT);
            connected = false;
        }
        catch (IOException e){
            System.out.println("Port " + PORT + "unavailable" );
            System.exit(-1);
        }
    }   
    
    /**
     * 
     * Starts the connection between the two machines. The input and
     * output streams are initialized.
     * 
     * @param 
     * @return 
     */
    @Override
    public void run(){
            try{
                Socket server = serverSocket.accept();
                input = new DataInputStream(server.getInputStream());
                out = new DataOutputStream(server.getOutputStream());
                connected = true;
            }
            catch(IOException e){
                e.printStackTrace();
            }  
    }
    
    /**
     * Gets the incoming stream from the socket
     * 
     * @param
     * @return out DataOutputStream of data from socket
     */
    public DataOutputStream getOutputStream(){
        return out;
    }

    /**
     * Gets the outgoing stream from the socket
     * 
     * @param
     * @return out DataInputStream of data from socket
     */
    public DataInputStream getInputStream(){
        return input;
    }
    
    /**
     * Gets the boolean of whether or not the connection is true.
     * Do not do image processing unless this is true.
     * 
     * @param
     * @return connected Boolean value of the socket connection's success
     */    
    public boolean getConnectionStatus(){
        return connected;
    }
    
}
