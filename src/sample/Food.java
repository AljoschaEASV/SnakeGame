package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Food {
    Circle snack = new Circle (20,foodColor ());





    public Color foodColor(){
          Random redCol = new Random();
          Random greenCol = new Random();
          Random blueCol = new Random();

        int red  = redCol.nextInt (256);
        int green = greenCol.nextInt (256);
        int blue = blueCol.nextInt (256);

        return Color.rgb(red,green,blue);

    }

    public foodSpawner(){

    }
}
