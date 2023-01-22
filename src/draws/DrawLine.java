package draws;

import animationwaitingtime.AnimationWaitingTime;
import javafx.scene.shape.Line;

public class DrawLine {

    Line line;

    public DrawLine(Line line) {
        this.line = line;
        //  drawLine(x, y);
    }

    public void drawLine(int x, int y) {

        for (int i = 0; i < x; i+=3) {
            line.setEndX(i);
            new AnimationWaitingTime().wait(25);
        }

    }

}
