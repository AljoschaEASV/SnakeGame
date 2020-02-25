package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Snake {
    ArrayList<Circle> baseBody = new ArrayList<Circle> ();
    Circle head = new Circle (50, Color.RED);
    Circle body = new Circle (25, Color.CORNFLOWERBLUE);

    public Snake(){
        baseBody.add(head);
        baseBody.add(body);
    }

    public void getDirection(){

    }


}
