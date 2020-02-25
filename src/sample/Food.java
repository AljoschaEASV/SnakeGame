package sample;

import javafx.scene.paint.Color;

import java.util.Random;

public class Food {





    public Color foodColor(){
          Random redCol = new Random();
          Random greenCol = new Random();
          Random blueCol = new Random();

        int red  = redCol.nextInt (256);
        int green = greenCol.nextInt (256);
        int blue = blueCol.nextInt (256);

        return Color.rgb(red,green,blue);

    }

    public static void main (String[] args) {

    }
}
