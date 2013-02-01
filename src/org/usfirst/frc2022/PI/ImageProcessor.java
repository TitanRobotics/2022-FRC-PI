/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.PI;

import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.plugin.MarvinPlugin;
import marvin.util.MarvinAttributes;
import marvin.util.MarvinPluginLoader;

/**
 *
 * @author Michael
 */
public class ImageProcessor {

    MarvinImage image,imageOut;
    MarvinImagePlugin colorLookzorPlugin;
    MarvinAttributes attribute = new MarvinAttributes();
    MarvinImageMask mask = MarvinImageMask.NULL_MASK;
    
    
    public ImageProcessor(){
        
        image = MarvinImageIO.loadImage("./res/x.jpg");
        imageOut = new MarvinImage(image.getHeight(),image.getWidth());
        colorLookzorPlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.pattern.findColorPattern");
        
    }
    
    public void processImage(){
        colorLookzorPlugin.setAttribute("regionPX", 50);
        colorLookzorPlugin.setAttribute("regionPY", 50);
        colorLookzorPlugin.setAttribute("regionWidth", 10);
        colorLookzorPlugin.setAttribute("regionHeight", 10);
        colorLookzorPlugin.setAttribute("differenceColorRange", 10);
        colorLookzorPlugin.process(image, imageOut,attribute,mask,false);
        MarvinImageIO.saveImage(imageOut, "./res/y.jpg");
        
    }
    
}
