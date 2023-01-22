package scene.firework;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class FireworkAnimationController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Line fireworkBegginingLine;

    List<Firework> fireworkList = new ArrayList<Firework>();
    @FXML
    private Button startBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    Random random = new Random();

    void createFirework() {
        double locationX = fireworkBegginingLine.getLayoutX()
                + random.nextDouble() * (fireworkBegginingLine.getEndX());
        double locationY = fireworkBegginingLine.getLayoutY();
        Firework firework = new Firework(locationX, locationY);
        fireworkList.add(firework);

        anchorPane.getChildren().add(firework);

    }

    void fireAllFireWorks() {
        Random random = new Random();
        int waitingMS;
        for (int i = 0; i < fireworkList.size(); i++) {

            Firework firework = fireworkList.get(i);
            new Thread(() -> {
                fireTheFirework(firework);
            }).start();
            try {
                waitingMS = random.nextInt(500) + 300;
                Thread.sleep(waitingMS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void fireTheFirework(Firework firework) { //240 - 500
        Random random = new Random();
        int heighBorder = random.nextInt(6) * 35 + 240;
        while (firework.getCenterY() > heighBorder) {
            double locationY = firework.getCenterY();
            new AnimationWaitingTime().wait(10);
            Platform.runLater(() -> {
                firework.setCenterY(locationY - 5);
            });

        }
        FireworksExplosion fireworksExplosion = new FireworksExplosion(firework);
        Platform.runLater(() -> {
            for (int i = 0; i < firework.getNumberOfPieces(); i++) {
                anchorPane.getChildren().add(fireworksExplosion.getPieceList().get(i));
            }

        });
        Platform.runLater(() -> {
            firework.setOpacity(0);
        });
        startMusic();
        new AnimationWaitingTime().wait(50);
        fireworksExplosion.explode();
    }

    boolean started = false;
    boolean musicBackSounStarted = false;

    @FXML
    private void mouseClick(MouseEvent event) {
        if (started == false) {
            for (int i = 0; i < 50; i++) {
                createFirework();

            }

            new Thread(() -> {
                fireAllFireWorks();
            }).start();

            anchorPane.getChildren().remove(startBtn);
        }
    }

    private void startMusic() {
        if (musicBackSounStarted == false) {
            FireworkBackSound.playMusic();
            musicBackSounStarted = true;
        }
    }
}
