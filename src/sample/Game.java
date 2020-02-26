package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Game extends Application {
    //VARIABLES
    boolean gameOver = false;
    Canvas c = new Canvas ();
    GraphicsContext gc;
    Scene scene;
    int score = 0;


    public enum direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void gameState () {
        boolean gameOver = false;
        if (gameOver) {
            //TODO implement logic. & maybe return Type.
        }
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        Group root = new Group();
        c = new Canvas(600, 600);
        gc = c.getGraphicsContext2D();

        /**
         * Building the Snake and append it to the group to put it into the scene.
         */
        Snake s = new Snake();
        ArrayList<Circle> ac = s.getBaseBody();
        Circle snakeHead = ac.get(0);
        for (int i = 0; i < ac.size(); i++) {
            Circle c = ac.get(i);
            root.getChildren().addAll(c);
        }

        /**
         * Building an showing the scene
         */
        root.getChildren().addAll(c);
        scene = new Scene(root);

        /**
         * Calling the directions for the Snake
         */
        s.createTranslateTransition(snakeHead);
        s.moveSnakeOnKeyPress(scene);

        /**
         * Animations
         * @param args
         */
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.DOWN), new Runnable() {
            @Override
            public void run() {
                ac.get(0).setCenterY(ac.get(0).getCenterY() + 5);
                ac.get(1).setCenterY((ac.get(0).getCenterY()-25));
                ac.get(1).setCenterX((ac.get(0).getCenterX()) + 5);

            }
        });

        /**
         * Setting and showing the Scene/Stage
         */
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();


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



        public static void main (String[]args){ launch (args); }


    }


