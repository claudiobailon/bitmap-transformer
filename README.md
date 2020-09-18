# bitmap-transformer
## Methods
### addBorder
This method transforms the given image by adding a 5 pixel border around the image.
### randomize
This method transforms the given image by randomizing the color of every pixel in the given image.
### mirror
 This method transforms the given image by mirroring it over the y-axis.
### How to run in the Terminal
 `./gradlew run --args 'src/main/resources/mario.bmp src/main/resources/imgResult.bmp addBorder'`<br>
 where arg1 is the file path for the image you want to transform<br>
 arg2 is the file path for where you want to store the transformed image<br>
 arg3 is the method you want to use to transform the image. 