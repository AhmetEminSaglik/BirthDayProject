package screenchangebutton;

import javafx.scene.Scene;
import scene.MyScene;

public class CakeChangeButton extends ChangeButton {

    @Override
    public void setScene(Scene scene) {
        setScene(new MyScene().getBirthdayCake());
    }

    public CakeChangeButton(String butonText) {
        super(butonText);
    }

}
