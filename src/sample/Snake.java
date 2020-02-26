package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Snake {
    ArrayList<Circle> baseBody = new ArrayList<Circle> ();
    Circle head = new Circle (25, Color.ORCHID);
    Circle body = new Circle (15, Color.CORNFLOWERBLUE);
    private static final int      KEYBOARD_MOVEMENT_DELTA = 2;
    private static final Duration TRANSLATE_DURATION      = Duration.seconds(2);


    public ArrayList<Circle> getBaseBody () {
        head.setCenterX (200);
        head.setCenterY (200);
        this.baseBody.add(head);
        body.setCenterX (head.getCenterX()-(head.getRadius()+body.getRadius()));
        body.setCenterY (head.getCenterY());
        this.baseBody.add(body);
        return baseBody;
    }

    public TranslateTransition createTranslateTransition(final Circle circle) {
        final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, circle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                head.setCenterX(head.getTranslateX() + head.getCenterX());
                head.setCenterY(head.getTranslateY() + head.getCenterY());
                head.setTranslateX(0);
                head.setTranslateY(0);
                body.setCenterX(body.getTranslateX() + body.getCenterX());
                body.setCenterY(body.getTranslateY() + body.getCenterY());
                body.setTranslateX(0);
                body.setTranslateY(0);
            }
        });
        return transition;
    }
    public void moveSnakeOnKeyPress(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        head.setCenterY(head.getCenterY() - KEYBOARD_MOVEMENT_DELTA);
                        body.setCenterY(body.getCenterY() - KEYBOARD_MOVEMENT_DELTA);
                        break;
                    case RIGHT:
                        head.setCenterX(head.getCenterX() + KEYBOARD_MOVEMENT_DELTA);
                        body.setCenterX(body.getCenterX() + KEYBOARD_MOVEMENT_DELTA);

                        break;
                    case DOWN:
                        head.setCenterY(head.getCenterY() + KEYBOARD_MOVEMENT_DELTA);
                        body.setCenterY(body.getCenterY() + KEYBOARD_MOVEMENT_DELTA);

                    break;
                    case LEFT:
                        head.setCenterX(head.getCenterX() - KEYBOARD_MOVEMENT_DELTA);
                        body.setCenterX(body.getCenterX() - KEYBOARD_MOVEMENT_DELTA);

                    break;

                }
            }
        });

    }

}
