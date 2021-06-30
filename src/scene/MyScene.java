package scene;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyScene {

    Scene scene;

    public Scene getBirthdayCake() {
        scene = new Scene(getRoot("/scene/cake/Cake.fxml"));
        return scene;

    }

    public Scene getSnow() {
        scene = new Scene(getRoot("/scene/snowanimation/SnowAnimation.fxml"));
        return scene;
    }

    public Scene getFirework() {
        scene = new Scene(getRoot("/scene/firework/FireworkAnimation.fxml"));
        return scene;
    }

    Parent getRoot(String scenePath) {

        try {
            FXMLLoader fxmlLoader = fxmlLoader = new FXMLLoader();

            Parent root = fxmlLoader.load(getClass().getResource(scenePath));
            return root;
        } catch (IOException ex) {
            System.out.println("ERROR : " + ex.getMessage());
//            new ErrorMessage().appearFatalError(getClass(), " HATA >> " + ex.getMessage());

        }
        return null;
    }

    public static void chageScreen(Stage stage, Scene scene) {
        stage.setScene(scene);
    }
}
