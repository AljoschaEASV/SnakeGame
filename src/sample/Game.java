package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

        Pane root = new Pane ();
        root.setMinSize (600, 600);
        vb = new VBox ();
        c = new Canvas (600, 600);
        gc = c.getGraphicsContext2D ();
       Snake s = new Snake();
       s.getBaseBody ();
        root.getChildren ().addAll (vb,c);

        scene = new Scene (root);
        scene.setFill (Color.ALICEBLUE);



        primaryStage.setTitle ("Snake");
        primaryStage.setScene (scene);
        primaryStage.show ();
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


