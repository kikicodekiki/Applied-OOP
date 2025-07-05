package Homeworks.Homework_3.cipher_fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import cipher.RouteCipher;

public class CipherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblCipherKey;

    @FXML
    private TextArea txaInput;

    @FXML
    private TextArea txaOutput;

    @FXML
    private TextField txfCipherKey;

    @FXML
    private Text txtCipher;

    @FXML
    void btnDecryptOnClick(ActionEvent event) {
        int key = Integer.parseInt(txfCipherKey.getText());
        RouteCipher rc = new RouteCipher(key);
        txaInput.setText(rc.decrypt(txaInput.getText()));
        txaOutput.setText("");
        txfCipherKey.clear();
    }

    @FXML
    void btnEncryptOOnCLick(ActionEvent event) {
        int key = Integer.parseInt(txfCipherKey.getText());
        RouteCipher rc = new RouteCipher(key);
        txaOutput.setText(rc.encrypt(txaInput.getText()));
        txaInput.setText("");
        txfCipherKey.clear();
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnDecrypt != null : "fx:id=\"btnDecrypt\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert btnEncrypt != null : "fx:id=\"btnEncrypt\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert lblCipherKey != null : "fx:id=\"lblCipherKey\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert txaInput != null : "fx:id=\"txaInput\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert txaOutput != null : "fx:id=\"txaOutput\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert txfCipherKey != null : "fx:id=\"txfCipherKey\" was not injected: check your FXML file 'route-cipher.fxml'.";
        assert txtCipher != null : "fx:id=\"txtCipher\" was not injected: check your FXML file 'route-cipher.fxml'.";

    }

}

