/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI;

import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.plugin.MarvinPlugin;
import marvin.util.MarvinAttributes;
import marvin.util.MarvinPluginLoader;
import org.usfirst.frc2022.PI.logic.FindGoal;

/**
 *
 * @author Michael
 */
public class ImageProcessor {

    MarvinImage image,imageOut;
    MarvinImagePlugin colorLookzorPlugin;
    MarvinAttributes attribute = new MarvinAttributes();
    MarvinImageMask mask = MarvinImageMask.NULL_MASK;
    
    FindGoal goalFinder;
    BotCommand commandProcessor;
    
    public ImageProcessor(){
        try {           
            URL website = new URL("http://lh4.ggpht.com/-XaGtIYg-OfU/TQeOX4zxvTI/AAAAAAAABf4/gyPjEyXqFcc/s720/SDC10873.JPG");
            
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("img.jpg");
            fos.getChannel().transferFrom(rbc, 0, 1 << 24);
            
            image = MarvinImageIO.loadImage("img.jpg");
            imageOut = new MarvinImage(image.getHeight(),image.getWidth());
            colorLookzorPlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.pattern.findColorPattern");
            
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void processImage(int px, int py, int width, int height){
        colorLookzorPlugin.setAttribute("regionPX", px);
        colorLookzorPlugin.setAttribute("regionPY", py);
        colorLookzorPlugin.setAttribute("regionWidth", width);
        colorLookzorPlugin.setAttribute("regionHeight", height);
        colorLookzorPlugin.setAttribute("differenceColorRange", 10);
        colorLookzorPlugin.process(image, imageOut,attribute,mask,false);
        
        goalFinder.update(attribute, px, py);
        goalFinder.process();
        goalFinder.sendToProcess(commandProcessor);
        
    }
    
    public void setLocation(){
        
    }
    
}
