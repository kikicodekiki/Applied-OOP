package Week_8.DrawingBoard.gui.src.view;

import java.net.URL;
import java.util.ResourceBundle;

import Week_8.DrawingBoard.model.src.geometry.Line;
import Week_8.DrawingBoard.model.src.geometry.Point;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawLine;

    @FXML
    private Button btnDrawrRectangle;

    @FXML
    private Pane pnlDrawingBoard;

    @FXML
    void btnDrawLineOnAction(ActionEvent event) {
        Line line = new Line();
        line.draw(pnlDrawingBoard);
    }

    @FXML
    void btnDrawrRectangleOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDrawLine != null : "fx:id=\"btnDrawLine\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnDrawrRectangle != null : "fx:id=\"btnDrawrRectangle\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert pnlDrawingBoard != null : "fx:id=\"pnlDrawingBoard\" was not injected: check your FXML file 'MainScene.fxml'.";

    }
}
