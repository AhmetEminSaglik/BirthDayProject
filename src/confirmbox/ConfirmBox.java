/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmbox;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Ahmet Emin
 */
public class ConfirmBox extends VBox {

    @FXML
    private Button btnYes;

    @FXML
    private Button btnNo;

    static boolean answer = false;
    Stage stage = new Stage();

    public ConfirmBox() {
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader fXMLLoader = createFxmlLoader();

        Scene scene = new Scene(fXMLLoader.getRoot());
        fillButton(btnYes, true);
        fillButton(btnNo, false);
        stage.setScene(scene);
        stage.setTitle("Exit Request Validation");

        stage.showAndWait();
    }

    @FXML
    private void initialize() {

    }

    public boolean ExitRequestResult() {

        return answer;
    }

    FXMLLoader createFxmlLoader() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
//            new errormessage.ErrorMessage().appearFatalError(getClass(), exception.getMessage());
        }
        return fxmlLoader;
    }

    void fillButton(Button btn, boolean value) {
        btn.setOnAction(e -> {
            answer = value;
            stage.close();
        });

    }
}
