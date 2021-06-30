package scene.firework;

import javafx.application.Platform;
import javafx.scene.shape.Ellipse;

public class PieceOfFirework extends Ellipse {

    double angle;

    public PieceOfFirework(Firework firework, double radiusX, double radiusY) {
        setFill(firework.getColor());
        setLayoutX(firework.getCenterX());
        setLayoutY(firework.getCenterY());

        setRadiusX(radiusX);
        setRadiusY(radiusY);
    }

    public void spreadAround(double explosionEnergy) {
        Platform.runLater(() -> {
            setLayoutX(getLayoutX() + Math.cos(Math.toRadians(angle)) * explosionEnergy * 0.1);
            setLayoutY(getLayoutY() + Math.sin(Math.toRadians(angle)) * explosionEnergy * 0.1);

        });

    }

    public void fallDown() {
        Platform.runLater(() -> {
            setLayoutY(getLayoutY() + 1);
        });
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return super.toString() + "PieceOfFirework{" + "angle=" + angle + '}'; //To change body of generated methods, choose Tools | Templates.
    }

}
