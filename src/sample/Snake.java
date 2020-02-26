package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Snake {
    ArrayList<Circle> baseBody = new ArrayList<Circle> ();
    Circle head = new Circle (25, Color.ORCHID);
    Circle body = new Circle (15, Color.CORNFLOWERBLUE);
    private static final int   MOVEMENT_RANGE = 5;
    private static final Duration TRANSLATE_DURATION      = Duration.seconds(2);


    /**
     * Builds the base Body for the Snake.
     * @return
     */
    public ArrayList<Circle> getBaseBody () {
        head.setCenterX (200);
        head.setCenterY (200);
        this.baseBody.add(head);
        body.setCenterX (head.getCenterX()-(head.getRadius()+body.getRadius()));
        body.setCenterY (head.getCenterY());
        this.baseBody.add(body);
        return baseBody;
    }

    /**
     *
     * @param circle gets the Snake body.
     * @return
     */
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

    /**
     * Taking the Scene and writing the
     * @param scene
     */
    /*public void moveSnakeOnKeyPress(Scene scene) {

                switch (event.getCode()) {
                    case UP:
                        head.setCenterY(head.getCenterY() - MOVEMENT_RANGE);
                        body.setCenterY(body.getCenterY() - MOVEMENT_RANGE);
                        break;
                    case RIGHT:
                        head.setCenterX(head.getCenterX() + MOVEMENT_RANGE);
                        body.setCenterX(body.getCenterX() + MOVEMENT_RANGE);

                        break;
                    case DOWN:


                    break;
                    case LEFT:
                        head.setCenterX(head.getCenterX() - MOVEMENT_RANGE);
                        body.setCenterX(body.getCenterX() - MOVEMENT_RANGE);

                    break;
                }
            }
        });

     */

    }


