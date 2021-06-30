package config;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class Config {

    public static void AnchorPaneConst(Region region, double top, double left, double right, double bottom) {
        AnchorPane.setBottomAnchor(region, bottom);
        AnchorPane.setLeftAnchor(region, left);
        AnchorPane.setRightAnchor(region, right);
        AnchorPane.setTopAnchor(region, top);

    }

}
