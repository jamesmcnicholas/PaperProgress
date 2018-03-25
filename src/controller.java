import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.Optional;

public class controller {

    @FXML private Label progressLabel;

    @FXML private ProgressBar progressBar;

    @FXML private Button setMarksButton;

    @FXML private Button incrementMarksButton;

    @FXML private Label marksLabel;

    @FXML private Button resetButton;

    private int maxMarks;
    private int currentMarks;

    @FXML
    void incrementMarks(ActionEvent event) {
        currentMarks++;
        double completion = (double)currentMarks/maxMarks;
        if(completion<=1){
            progressLabel.setText(Math.round(completion*100)+"%");
            progressBar.setProgress(completion);
            marksLabel.setText("Progress: "+currentMarks+"/"+maxMarks);
        }
        if(completion==1){
            marksLabel.setText("Progress: Completed!");
        }
    }

    @FXML
    void setMarks(ActionEvent event) {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Marks");
        textInputDialog.setHeaderText("Enter the number of marks");
        Optional<String> result = textInputDialog.showAndWait();
        maxMarks = Integer.parseInt(result.get());
        currentMarks=0;
        marksLabel.setText("Progress: "+currentMarks+"/"+maxMarks);
    }

    @FXML
    void reset(ActionEvent event){
        currentMarks=0;
        marksLabel.setText("Progress: "+currentMarks+"/"+maxMarks);
        progressBar.setProgress(0);
        progressLabel.setText("0%");
    }

}
