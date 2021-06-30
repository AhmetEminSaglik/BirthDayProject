package scene;

import screenchangebutton.ChangeButton;

public class SceneDesingedButtons {

    ChangeButton changeButton;

    public ChangeButton getBirthdayCakeDesing() {
        changeButton = new ChangeButton("Birthday Cake");
        changeButton.setScene(new MyScene().getBirthdayCake());
        return changeButton;
    }

    public ChangeButton getSnowDesing() {
        changeButton = new ChangeButton("Snow");
        changeButton.setScene(new MyScene().getSnow());
        return changeButton;
    }

    public ChangeButton getFireworkDesing() {
        changeButton = new ChangeButton("Firework");
        changeButton.setScene(new MyScene().getFirework());

        return changeButton;
    }

}
