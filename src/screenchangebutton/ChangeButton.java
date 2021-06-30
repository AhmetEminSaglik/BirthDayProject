package screenchangebutton;

import config.Config;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import music.MusicPlayer;

public class ChangeButton extends AnchorPane {

    @FXML
    private javafx.scene.control.Button button;
    String butonText;
    private Scene scene;
    String musicPath;

    public ChangeButton(String butonText) {
        this();
        this.butonText = butonText;
        button.setText(butonText);

    }
//    private ThreadsToBeStopped threads = new ThreadsToBeStopped();

    public ChangeButton() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangeButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println("exception :" + exception.getMessage());
//            new ErrorMessage().appearFatalError(getClass(), exception.getMessage());
        }
    }

    private void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);

    }

    @FXML
    void mouseClick(MouseEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
//        if (musicPath != null) {
//            MusicPlayer.playMusic(musicPath);
//        } else {
            MusicPlayer.stopMusic();
//        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "ChangeButton{" + "button=" + button + ", butonText=" + butonText + ", scene=" + scene + '}';
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

}
