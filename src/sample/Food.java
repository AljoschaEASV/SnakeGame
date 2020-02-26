package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Food {
    Circle snack = new Circle (20,foodColor ());
    Random r = new Random ();
    double fodX = 0;
    double  fodY = 0;




    public Color foodColor(){
        Random redCol = new Random();
        Random greenCol = new Random();
        Random blueCol = new Random();

        int red  = redCol.nextInt (256);
        int green = greenCol.nextInt (256);
        int blue = blueCol.nextInt (256);

        return Color.rgb(red,green,blue);

    }

    public Circle foodSpawner( ){
        //TODO Use Random x & y coordinates to spawn the food, though withing the bounds of the pane/Canvas.
        int x = r.nextInt (601);
        int y = r.nextInt (601);

        snack.setCenterX (x);
        snack.setCenterY (y);
        snack.setFill(foodColor());


        return snack;
    }
}
