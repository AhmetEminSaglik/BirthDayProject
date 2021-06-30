package screenchangebutton;

import javafx.scene.Scene;
import scene.MyScene;

public class SnowChangeButton extends ChangeButton {

    @Override
    public void setScene(Scene scene) {
        setScene(new MyScene().getSnow());
    }

    public SnowChangeButton(String butonText) {
        super(butonText);
    }

}
