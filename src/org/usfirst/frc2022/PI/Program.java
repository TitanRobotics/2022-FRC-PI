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
    
    public static void main(String args[]){
        
        imageProcessor = new ImageProcessor();
        imageProcessor.processImage();
                
    }
    
}
