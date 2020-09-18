package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    public String filePath;
    public BufferedImage image;
    public String outputFilePath;
    public String transform;

    public Bitmap(String filePath, String outputFilePath, String transform) {
        this.filePath= filePath;
        this.outputFilePath = outputFilePath;
        this.transform = transform;
        try {
            this.image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Failed to find file");
        }

        System.out.println(this.image);
        System.out.println(this.image.getRGB(100,10));
        System.out.println(this.image.getRGB(100,20));
    }

    public String addBorder(){
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        System.out.println(width);
        System.out.println(height);//reference for setting colors https://stackoverflow.com/questions/23234306/how-to-edit-the-pixels-in-a-bufferedimage
        for(int x = 0; x < width; x++ ){
            if(x == 5){
                x = width -5;
            }
            for(int y = 0; y < height; y++){
                this.image.setRGB(x,y,0);
            }
        }
        for(int y = 0; y < height; y++ ){
            if(y == 5){
               y = height -5;
            }
            for(int x = 0; x < width; x++){
                this.image.setRGB(x,y,0);
            }
        }
        try {
            ImageIO.write(this.image, "bmp", new File(this.outputFilePath));
        } catch (IOException e) {
            System.out.println("Failed");
        }

        return "Success!!";
    }

    public String changeBitmapUsingThisMethod(String input) {
        if(input.equals("addBorder")){
            return this.addBorder();
        } else if(input.equals("randomize")){
            return this.randomize();
        }else if(input.equals("mirror")){
            return this.mirror();
        }
        return "ERROR: Method Doesn't Exist";
    }

    private String randomize() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();

        for(int y = 0; y < height; y++ ){
            for(int x = 0; x < width; x++){// learned this from https://dyclassroom.com/image-processing-project/how-to-create-a-random-pixel-image-in-java
                int r= (int) (Math.random()*256);
                int g= (int) (Math.random()*256);
                int b= (int) (Math.random()*256);
                int a= (int) (Math.random()*256);
                int p= (a<<24)|(r<<16)|(g<<8)|(b);
                this.image.setRGB(x,y,p);
            }

        }
          try {
            ImageIO.write(this.image, "bmp", new File(this.outputFilePath));
        } catch (IOException e) {
            System.out.println("Failed");
        }
        return "Success!!";

    }


    private String mirror() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();

        for(int x = 0; x < width; x++ ){

            for(int y = 0; y < height; y++){
                int p = this.image.getRGB(width-x-1,y);
                this.image.setRGB(x,y,p);
            }
        }

        try {
            ImageIO.write(this.image, "bmp", new File(this.outputFilePath));
        } catch (IOException e) {
            System.out.println("Failed");
        }
        return "Success!!";

        }
    }


