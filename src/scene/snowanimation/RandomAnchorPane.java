package scene.snowanimation;

import config.Config;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class RandomAnchorPane {

    AnchorPane anchorPane;

    public RandomAnchorPane() {
        Label label = new Label("Demo");
        anchorPane = new AnchorPane(label);
        createAnchorPane();

    }

    void createAnchorPane() {

        Config.AnchorPaneConst(anchorPane, 10.0, 10.0, 10.0, 10.0);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

}
