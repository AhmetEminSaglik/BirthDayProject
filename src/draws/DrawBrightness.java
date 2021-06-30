package draws;

import javafx.scene.shape.Circle;

public class DrawBrightness {

    Circle circle;

    public DrawBrightness(Circle circle) {
        this.circle = circle;
        drawCircle();
    }

    void drawCircle() {

        circle.setRadius(circle.getRadius() + 1.4);
    }

}
