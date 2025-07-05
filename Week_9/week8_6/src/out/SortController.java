package Week_9.week8_6.src.out;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SortController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSort;

    @FXML
    private Label lblAscending;

    @FXML
    private Label lblSorted;

    @FXML
    private Label lblUnsorted;

    @FXML
    private TextArea txaSorted;

    @FXML
    private TextArea txaUnsorted;

    @FXML
    private TextField txtOrder;

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSortOnClick(ActionEvent event) {
        // get the text from the user in the text field
        // array of strings -> array of numbers that we sort
        String text = txaUnsorted.getText();
        String[] words = text.split("\\s+"); // "\\s" -> empty cells
        int[] numbers = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            numbers[i] = Integer.parseInt(words[i]);
        }
        Arrays.sort(numbers);
        if(txtOrder.getText().matches("[yY]{1}")) {
            txaSorted.setText(Arrays.toString(numbers));
            // arrays.tostring() automatically sets them with an interval in between
        } else {
            StringBuilder result = new StringBuilder();
            result.append(Arrays.toString(numbers));
            for(int i = numbers.length - 1; i > 0; i--) {
                result.append(numbers[i]).append(", ");
            }
            result.append(numbers[0]);
            txaSorted.setText(result.toString());

        }
    }

    @FXML
    void initialize() {
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert btnSort != null : "fx:id=\"btnSort\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert lblAscending != null : "fx:id=\"lblAscending\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert lblSorted != null : "fx:id=\"lblSorted\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert lblUnsorted != null : "fx:id=\"lblUnsorted\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert txaSorted != null : "fx:id=\"txaSorted\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert txaUnsorted != null : "fx:id=\"txaUnsorted\" was not injected: check your FXML file 'sort-view.fxml'.";
        assert txtOrder != null : "fx:id=\"txtOrder\" was not injected: check your FXML file 'sort-view.fxml'.";

    }

}
