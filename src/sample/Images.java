package sample;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Images {
    ArrayList<Image> imagesArray = new ArrayList<>();

    public Images() throws FileNotFoundException {
        FileInputStream fis1 = new FileInputStream("images\\1.png");
        FileInputStream fis2 = new FileInputStream("images\\2.png");
        FileInputStream fis3 = new FileInputStream("images\\3.png");
        FileInputStream fis4 = new FileInputStream("images\\4.png");
        FileInputStream fis5 = new FileInputStream("images\\5.png");
        FileInputStream fis6 = new FileInputStream("images\\6.png");
        FileInputStream fis7 = new FileInputStream("images\\7.png");
        FileInputStream fis8 = new FileInputStream("images\\8.png");
        FileInputStream fis9 = new FileInputStream("images\\9.png");
        FileInputStream fis10 = new FileInputStream("images\\10.png");
        FileInputStream fis11 = new FileInputStream("images\\11.png");
        FileInputStream fis12 = new FileInputStream("images\\12.png");
        FileInputStream fis13 = new FileInputStream("images\\13.png");
        FileInputStream fis14 = new FileInputStream("images\\14.png");
        FileInputStream fis15 = new FileInputStream("images\\15.png");
        FileInputStream fis16 = new FileInputStream("images\\16.png");
        FileInputStream fis17 = new FileInputStream("images\\17.png");
        FileInputStream fis18 = new FileInputStream("images\\18.png");

        imagesArray.add(new Image(fis1));
        imagesArray.add(new Image(fis2));
        imagesArray.add(new Image(fis3));
        imagesArray.add(new Image(fis4));
        imagesArray.add(new Image(fis5));
        imagesArray.add(new Image(fis6));
        imagesArray.add(new Image(fis7));
        imagesArray.add(new Image(fis8));
        imagesArray.add(new Image(fis9));
        imagesArray.add(new Image(fis10));
        imagesArray.add(new Image(fis11));
        imagesArray.add(new Image(fis12));
        imagesArray.add(new Image(fis13));
        imagesArray.add(new Image(fis14));
        imagesArray.add(new Image(fis15));
        imagesArray.add(new Image(fis16));
        imagesArray.add(new Image(fis17));
        imagesArray.add(new Image(fis18));



    }
}
