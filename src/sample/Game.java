package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
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
    direction dir = direction.LEFT;
    Canvas c = new Canvas ();
    GraphicsContext gc;

    VBox vb = new VBox ();
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

        Group root = new Group ();

        //root.setMinSize (600, 600);
        vb = new VBox ();
        c = new Canvas (600, 600);
        gc = c.getGraphicsContext2D ();

        Snake s = new Snake();
        ArrayList<Circle> ac = s.getBaseBody();
        Circle snakeHead = ac.get(0);


        for (int i = 0; i <ac.size() ; i++) {
            Circle c = ac.get(i);
            root.getChildren().addAll(c);

        }

        System.out.println("Init Variables");
        root.getChildren ().addAll (vb,c);
        System.out.println("Childs added");

        scene = new Scene (root);
        s.createTranslateTransition(snakeHead);
        s.moveSnakeOnKeyPress(scene);
        scene.setFill (Color.TRANSPARENT);
        System.out.println("Scene filled");




        primaryStage.setTitle ("Snake");
        primaryStage.setScene (scene);
        primaryStage.show ();
        System.out.println("Stage showed");
    }

    public direction getKeyDirect () {
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





























        public static void main (String[]args){

            launch (args);
        }


    }


