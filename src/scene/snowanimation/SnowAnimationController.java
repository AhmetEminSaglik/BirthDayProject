package scene.snowanimation;

import animationwaitingtime.AnimationWaitingTime;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import music.MusicPlayer;
import scene.SceneDesingedButtons;
import screenchangebutton.ChangeButton;

public class SnowAnimationController implements Initializable {

    Random random = new Random();
    List<Snow> snowList = new ArrayList<Snow>();
    public Thread SnowThread;

    List<Boolean> threadWhileLoopVariableList = new ArrayList<>();
    @FXML
    private AnchorPane myAnchorPane;
    @FXML
    private Button btnStartSnow;

    boolean firstEnter = true;
    @FXML
    private AnchorPane nextPage;
    @FXML
    private TextField txtSnowPiece;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    static boolean startedMoving = false;

    void createLotsOfCircle(int ms) {
        if (firstEnter) {
            addButtons();
            firstEnter = false;
        }

        Platform.runLater(() -> {

            createSnow();

            if (startedMoving == false) {
                startMoving();
            }
        });

        new AnimationWaitingTime().wait(ms);

    }

    void startMoving() {
        startedMoving = true;

        Thread movingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    moveSnow();
                }
            }
        });

        movingThread.start();

    }

    void createSnow() {

        double x = random.nextDouble() * myAnchorPane.getPrefWidth();
        double y = 0;
        Snow snow = new Snow(x, y, random.nextDouble() * 1.5 + 3.5);
        myAnchorPane.getChildren().add(snow);

        snowList.add(snow);

    }

    void moveSnow() {
        Platform.runLater(() -> {
            for (int circleIndex = 0; circleIndex < snowList.size(); circleIndex++) {
                double circleLocationY = snowList.get(circleIndex).getCenterY();
                if (circleLocationY < myAnchorPane.getPrefHeight()) {
                    snowList.get(circleIndex).setCenterY(circleLocationY + 0.05);

                } else {
                    snowList.remove(circleIndex);
                    System.out.println("silinen index : " + circleIndex);

                }
            }
        });
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
//            ErrorMessage.appearFatalError(getClass(), ex.getMessage());
        }
        Platform.runLater(() -> {
            txtSnowPiece.setText("Snow Pieces : " + snowList.size());
        });
    }
    boolean musicStarted = false;

    void addButtons() {
        Platform.runLater(() -> {
            ChangeButton btnRight = new SceneDesingedButtons().getFireworkDesing();
            nextPage.getChildren().add(btnRight);
        });
    }

    boolean snowFallLoop = true;
    static int snowCreateMs = 250;

    boolean clickFirstTime = true;

    @FXML
    private void snowFallBtnClick(MouseEvent event) {
        if (musicStarted == false) {
            MusicPlayer.playMusic(MusicPlayer.getSnowMusicPath());
            musicStarted = true;
        }
        btnStartSnow.setText("Add more Snow");

        if (clickFirstTime) {
            clickFirstTime = false;

            SnowThread = new Thread(() -> {
                while (snowFallLoop) {
                    createLotsOfCircle(snowCreateMs);
                }

            });
            SnowThread.start();
        } else {
            if (snowCreateMs > 50) {
                snowCreateMs -= 10;

            } else {
                btnStartSnow.setText("Already Maximum");
                btnStartSnow.setBackground(Background.EMPTY);
            }

        }
    }

}
