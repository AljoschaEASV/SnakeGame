package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    boolean gameOver = false;

    public enum direction{
        UP, DOWN, LEFT, RIGHT
    }

    public void gameState(){
        boolean gameOver = false;
        if(gameOver ){
            //TODO implement logic. & maybe return Type.
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }









}

