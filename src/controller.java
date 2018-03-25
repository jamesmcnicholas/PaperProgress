import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class controller {

    @FXML private Label progressLabel;

    @FXML private ProgressBar progressBar;

    @FXML private Button setMarksButton;

    @FXML private Button incrementMarksButton;

    private int marks;

    @FXML
    void incrementMarks(ActionEvent event) {

    }

    @FXML
    void setMarks(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Choose the number of marks");
        alert.setHeaderText("Choose the number of marks");
        alert.show();
    }

}
