
import edu.duke.*;
import java.io.*;

public class Assignment {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);
        
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int r = inPixel.getRed();
            int g = inPixel.getGreen();
            int b = inPixel.getBlue();
            int average = (r + g + b) / 3;
            
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        
        return outImage;
    }
   

    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);
        
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int r = inPixel.getRed();
            int g = inPixel.getGreen();
            int b = inPixel.getBlue();
            
            pixel.setRed(255 - r);
            pixel.setGreen(255 - g);
            pixel.setBlue(255 - b);
        }
        
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outgImage = makeGray(inImage);
            
            String fileName = inImage.getFileName();
            String newFileName = "gray-" + fileName;
            
            outgImage.setFileName(newFileName);
            outgImage.save();
            
            ImageResource outvImage = makeInversion(inImage);
            String fileName = inImage.getFileName();
            String newFileName = "inverted-" + fileName;
            outvImage.setFileName(newFileName);
            outvImage.save();
        }
    }
}
