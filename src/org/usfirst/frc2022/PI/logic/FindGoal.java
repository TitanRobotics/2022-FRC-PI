/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI.logic;

import marvin.util.MarvinAttributes;
import org.usfirst.frc2022.PI.BotCommand;

/**
 *
 * @author Michael
 */
public class FindGoal {
    
    int moveX;
    int moveY;
    boolean hasMovedLeft;
    boolean hasMovedRight;
    boolean hasMovedUp;
    boolean hasMovedDown;
    boolean isInRange;
    
    public FindGoal(){
        moveX = 0;
        moveY = 0;
        hasMovedLeft = false;
        hasMovedRight = false;
        hasMovedUp = false;
        hasMovedDown = false;
        isInRange = false;
    }
    
    public void update(MarvinAttributes att, int px, int py){
        
        moveX = (int) att.get("regionPX") - px;
        moveY = (int) att.get("regionPY") - py;
        
    }

    public void process() {
        
    }

    public void sendToProcess(BotCommand commandProcessor) {
        commandProcessor.update("MOVEMENT",)
        commandProcessor.create("MOVEMENT",)
        int sendStatus = commandProcessor.send();
        
        if(sendStatus != 0){
            System.err.println("Error sending command to bot! \nErrorcode: " + sendStatus);
        }
        
    }
    
}
