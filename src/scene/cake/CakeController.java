package scene.cake;

import animationwaitingtime.AnimationWaitingTime;
import draws.DrawCandleFire;
import draws.DrawLine;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import scene.SceneDesingedButtons;
import screenchangebutton.ChangeButton;

public class CakeController implements Initializable {

    @FXML
    private Line line1;

    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Ellipse fire1;
    @FXML
    private Ellipse fire2;
    @FXML
    private Ellipse fire3;
    @FXML
    private Circle brightness2;
    @FXML
    private Circle brightness3;
    @FXML
    private Circle brightness1;

    private boolean isPutOutFire1 = false;
    private boolean isPutOutFire2 = false;
    private boolean isPutOutFire3 = false;
    @FXML
    private Pane paneBackground;

    public Thread threadProgress = new Thread(new progress());
    @FXML
    private AnchorPane nextPage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i = 0;

        threadProgress.start();
        new Thread(() -> {
            while (true) {
                System.out.println("Button is not show up  without adding this sentence");
                if (buttonsCanAdd && allCandlesAreOutOfFire()) {

                    Platform.runLater(() -> {
                        addButtons();
                    });
                    break;
                }
            }
        }).start();

    }

    static boolean buttonsCanAdd = false;

    public class progress implements Runnable {

        @Override
        public void run() {
            drawLine(line1);
            drawLine(line2);
            drawLine(line3);
            paintBackground();
            drawCandleFire(fire1, brightness1);
            drawCandleFire(fire2, brightness2);
            drawCandleFire(fire3, brightness3);
            activatePutOutFires();
            buttonsCanAdd = true;

        }
    }

    void drawLine(Line line) {
        new DrawLine(line).drawLine(430, 10);
    }

    void drawCandleFire(Ellipse fire, Circle circle) {
        new DrawCandleFire(fire, circle).drawCandleFire();

    }

    @FXML
    private void mouseEntered(MouseEvent event) {

        if (isPutOutFire1 == true && event.getSource() == fire1) {
            System.out.println("fire1 " + fire1.toString());
            new DrawCandleFire(fire1, brightness1).putOutFire();

            isPutOutFire1 = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new AnimationWaitingTime().wait(750);
                    isPutOutFire1 = true;

                }
            }).start();

        } else if (isPutOutFire2 == true && event.getSource() == fire2) {
            new DrawCandleFire(fire2, brightness2).putOutFire();
            isPutOutFire2 = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new AnimationWaitingTime().wait(500);
                    isPutOutFire2 = true;

                }
            }).start();
        } else if (isPutOutFire3 == true && event.getSource() == fire3) {
            new DrawCandleFire(fire3, brightness3).putOutFire();
            isPutOutFire3 = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new AnimationWaitingTime().wait(500);
                    isPutOutFire3 = true;

                }
            }).start();
        }

    }

    int red = 255;
    int green = 255;
    int blue = 215;

    void paintBackground() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isEnoughColor(red) || !isEnoughColor(green) || !isEnoughColor(blue)) {
                    if (!isEnoughColor(red)) {
                        red = changeColor(red);
                    }
                    if (!isEnoughColor(green)) {
                        green = changeColor(green);
                    }
                    if (!isEnoughColor(blue)) {
                        blue = changeColor(blue);
                    }
                    paneBackground.styleProperty().set("-fx-background-color: rgb(" + red + "," + green + "," + blue + ")");
                    new AnimationWaitingTime().wait(100);
                }
            }
        }).start();

    }

    boolean isEnoughColor(int value) {
        if (value <= 35) {
            return true;
        }

        return false;
    }

    int changeColor(int value) {
        return value -= 10;
    }

    void activatePutOutFires() {
        isPutOutFire1 = true;
        isPutOutFire2 = true;
        isPutOutFire3 = true;

    }

    boolean allCandlesAreOutOfFire() {

        if (isFireOut(fire1) && isFireOut(fire2) && isFireOut(fire3)) {
            return true;
        }
        return false;
    }

    boolean isFireOut(Ellipse ellipse) {
        if (ellipse.radiusYProperty().get() == 0.0) {
            return true;
        }
        return false;
    }

    void addButtons() {
        ChangeButton snowSceneSwitchButton = new SceneDesingedButtons().getSnowDesing();
        nextPage.getChildren().add(snowSceneSwitchButton);

    }

    boolean isWholeCandlesPutOutOfFire() {
        if (fire1.getRadiusX() == 0 && fire2.getRadiusX() == 0 && fire3.getRadiusX() == 0) {
            return true;
        }

        return false;
    }
}
