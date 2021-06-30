package main;

import confirmbox.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import music.MusicPlayer;
import scene.MyScene;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        MusicPlayer.playMusic(MusicPlayer.getCakeMusicPath());
        Scene scene = new MyScene().getBirthdayCake();
        primaryStage.setTitle("HAPPY BIRTH DAY");
        primaryStage.setScene(scene);

        primaryStage.show();

        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            if (confirmCloseRequest()) {
                System.exit(0);
            }

        });

    }

    public boolean confirmCloseRequest() {
        boolean answer = new ConfirmBox().ExitRequestResult();
        return answer;

    }

    public static void main(String[] args) {
        launch(args);

    }

}
