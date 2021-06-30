package scene.firework;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Firework extends Ellipse {

    private double heightPower;
    private double widthPower;
    private int numberOfPieces;
    private double burstPower = 5;
    private Color color;

    public Firework(double centerX, double centerY) {
        setCenterX(centerX);
        setCenterY(centerY);
        setRadiusX(2);
        setRadiusY(10);
        createColor();
        setFill(color);
        createPowers();
        createNumberOfPieces();

    }

    void createColor() {
        float value;
        value = getFloat(3); // index 3
        float red = new Random().nextFloat() * (1 - value) + value;
        value = getFloat(2);// index 2
        float green = new Random().nextFloat() * (1 - value) + value;
        value = getFloat(1); // index 1
        float blue = new Random().nextFloat() * (1 - value) + value;

        color = new Color(red, green, blue, 1);

    }
    int minRandom = 15;

    Float getFloat(int index) {
        String valueText = "0." + getValue(index) + "f";
        return Float.parseFloat(valueText);

    }

    int getValue(int index) {
        int diffRange = minRandom - maxRandomValueForMinRandomValue;
        int value = new Random().nextInt(maxRandomValueForMinRandomValue - diffRange) + (3 - index) * (diffRange);
        maxRandomValueForMinRandomValue -= value;
        minuesProcess();

        return Math.abs(value);

    }

    void minuesProcess() {
        int diff = 10 - maxRandomValueForMinRandomValue;
        minRandom -= diff;
        maxRandomValueForMinRandomValue += diff;
    }
    int maxRandomValueForMinRandomValue = 10;

    void createPowers() {
        heightPower = new Random().nextDouble() * 3 + 950;
        widthPower = new Random().nextDouble() * 3 + 950;

    }

    void createNumberOfPieces() {
        numberOfPieces = new Random().nextInt(40) + 10;
//        numberOfPieces = 60;
    }

    public double getHeightPower() {
        return heightPower;
    }

    public void setHeightPower(double heightPower) {
        this.heightPower = heightPower;
    }

    public double getWidthPower() {
        return widthPower;
    }

    public void setWidthPower(double widthPower) {
        this.widthPower = widthPower;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public double getBurstPower() {
        return burstPower;
    }

    public void setBurstPower(double burstPower) {
        this.burstPower = burstPower;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
