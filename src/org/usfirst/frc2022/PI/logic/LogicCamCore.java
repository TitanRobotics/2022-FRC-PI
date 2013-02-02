/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI.logic;

import java.net.Inet4Address;
import marvin.image.MarvinImage;
import org.usfirst.frc2022.PI.BotCommand;

/**
 *
 * @author Michael
 */
public interface LogicCamCore {
    
    public boolean canFindCam(Inet4Address IP);
    public boolean imageOutOfBounds(MarvinImage image);
    public boolean sendCommandToBot(BotCommand command, Inet4Address IP);
    
    
}
