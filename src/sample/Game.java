package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.*;


public class Game extends Application {
    //VARIABLES
    boolean gameOver = false;
    Canvas c = new Canvas ();
    GraphicsContext gc;
    Scene scene;
    int score = 0;
    Food f;

    Timeline movement;
    private Object KeyCode;

    public static void main (String[] args) {
        launch (args);
    }

    public void gameState () {
        boolean gameOver = false;
        if (gameOver) {
            //TODO implement logic. & maybe return Type.
        }
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        Group root = new Group ();
        c = new Canvas (600, 600);
        gc = c.getGraphicsContext2D ();

        /**
         * Building the Snake and append it to the group to put it into the scene.
         */
        Snake s = new Snake ();
        ArrayList<Circle> ac = s.getBaseBody ();
        Circle snakeHead = ac.get (0);
        Circle snakeBody = ac.get (1);

        for (int i = 0; i < ac.size (); i++) {
            Circle c = ac.get (i);
            root.getChildren ().addAll (c);
        }

        /**
         * Building an showing the scene
         */
        root.getChildren ().addAll (c);
        scene = new Scene (root);

        /**
         * Calling the directions for the Snake
         */
        s.createTranslateTransition (snakeHead);
        f = new Food ();
        f.foodSpawner ();


        /**
         * Idea for the Movement like an Array: Get the Radius from the foreGoing Body Part (which is appended to the head)
         * Depending the Size from the snake itself, take the Radius from the foregoing bodyPart and move it by the amount
         * TODO Logic for the Correct Movement, like deleting the the Head and put it into a new Place.
         * TODO How to get the direction into an Animation?
         * @param args
         */

        scene.setOnKeyPressed (new EventHandler<KeyEvent> () {
            @Override
            public void handle (KeyEvent event) {

                scene.getAccelerators ().put (new KeyCodeCombination (DOWN), () -> {
                    snakeHead.setCenterY (snakeHead.getCenterY () + 5);
                    snakeHead.setCenterX (snakeHead.getCenterX ());
                    snakeBody.setCenterY ((snakeHead.getCenterY () - snakeHead.getRadius () - snakeBody.getRadius ()));
                    snakeBody.setCenterX ((snakeHead.getCenterX ()));
                })
                ;
                scene.getAccelerators ().put (new KeyCodeCombination (UP), () -> {
                    snakeHead.setCenterY (snakeHead.getCenterY () - 5);
                    snakeHead.setCenterX (snakeHead.getCenterX ());
                    snakeBody.setCenterY ((snakeHead.getCenterY () + snakeHead.getRadius () + snakeBody.getRadius ()));
                    snakeBody.setCenterX ((snakeHead.getCenterX ()));
                })
                ;
                scene.getAccelerators ().put (new KeyCodeCombination (LEFT), () -> {
                    snakeHead.setCenterY (snakeHead.getCenterY ());
                    snakeHead.setCenterX (snakeHead.getCenterX () - 5);
                    snakeBody.setCenterY ((snakeHead.getCenterY ()));
                    snakeBody.setCenterX ((snakeHead.getCenterX () + snakeHead.getRadius () + snakeBody.getRadius ()));
                })
                ;
                scene.getAccelerators ().put (new KeyCodeCombination (RIGHT), () -> {
                    snakeHead.setCenterY (snakeHead.getCenterY ());
                    snakeHead.setCenterX (snakeHead.getCenterX () + 5);
                    snakeBody.setCenterY ((snakeHead.getCenterY ()));
                    snakeBody.setCenterX ((snakeHead.getCenterX () - snakeHead.getRadius () - snakeBody.getRadius ()));
                })
                ;
            }
        });


        /**
         * Setting and showing the Scene/Stage
         */
        scene.setFill (Color.TRANSPARENT);
        primaryStage.setTitle ("Snake");
        primaryStage.setScene (scene);
        primaryStage.show ();
    }
}


//The Enum Idea for Direction.
    /* public direction getKeyDirect () {
        scene.addEventFilter (KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode () == KeyCode.W) {
                dir = direction.UP;
            }
            if(key.getCode () == KeyCode.A){
                dir = direction.LEFT;
            }
        if(key.getCode () == KeyCode.S){
                dir = direction.DOWN;
            }
        if(key.getCode () == KeyCode.D){
                dir = direction.RIGHT;
            }
        });
        return dir;


        }

    */



