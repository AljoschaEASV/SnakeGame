package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Snake {
    ArrayList<Circle> baseBody = new ArrayList<Circle> ();
    Circle head = new Circle (50, Color.RED);
    Circle body = new Circle (25, Color.CORNFLOWERBLUE);


    public ArrayList<Circle> getBaseBody () {
        head.setCenterX (100);
        head.setCenterY (100);
        this.baseBody.add(head);
        body.setCenterX (100);
        body.setCenterY (100);
        this.baseBody.add(body);
        return baseBody;
    }

}
