package draws;

import animationwaitingtime.AnimationWaitingTime;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class DrawCandleFire {

    Ellipse ellipse;
    Circle circle;

    public DrawCandleFire(Ellipse ellipse, Circle circle) {
        this.ellipse = ellipse;
        this.circle = circle;
        //drawCandleFire();

    }

    public void drawCandleFire() {

        for (int i = 0; i < 34; i++) {
            ellipse.setRadiusX(i / 5);
            ellipse.setRadiusY(i);
            new DrawBrightness(circle);

            new AnimationWaitingTime().wait(25);
        }

    }

    public void putOutFire() {
        ellipse.setRadiusX(ellipse.getRadiusX() - 2);
        ellipse.setRadiusY(ellipse.getRadiusY() - 11);
        circle.setRadius(circle.getRadius() - 15);
        if (circle.getRadius() < 10) {
            circle.setRadius(0);
        }

    }
}
