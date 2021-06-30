package scene.snowanimation;

import javafx.scene.shape.Circle;

public class Snow extends Circle {

    public Snow(double x, double y, double radian) {
        setCenterX(x);
        setCenterY(y);
        setRadius(radian);
        setFill(javafx.scene.paint.Color.WHITE);
    }

}
