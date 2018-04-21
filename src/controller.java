import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.util.*;


public class controller {

    @FXML private Label progressLabel;

    @FXML private ProgressBar progressBar;
    @FXML private ProgressBar timeProgressBar;

    @FXML private Label marksLabel;

    @FXML private Button resetButton;

    @FXML private Label timerLabel;

    @FXML private Button setTimeButton;

    @FXML private Label endTimeLabel;

    @FXML private Label currentTimeLabel;

    @FXML private Button pauseButton;

    private int hours = 0;
    private int mins = 0;
    private int secs = 0;

    private int startHours;
    private int startMins;
    private int startSecs;

    private int timeInSeconds;
    private int startTimeInSeconds;

    private boolean paused = true;

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

        timerLabel.setText("00 : 00 : 00");
        timeProgressBar.setProgress(0);
        currentTimeLabel.setText("00:00:00");

        hours = startHours;
        mins = startMins;
        secs = startSecs;


    }

    @FXML
    void setTime(ActionEvent event){
        /*
        Scanner input = new Scanner(System.in);

        System.out.println("Enter hours");
        startHours=input.nextInt();
        hours = startHours;

        System.out.println("Enter mins");
        startMins = input.nextInt();
        mins = startMins;

        System.out.println("Enter secs");
        startSecs = input.nextInt();
        secs = startSecs;
        */

        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Time");
        textInputDialog.setHeaderText("Enter the time in the form HH:MM:SS");
        Optional<String> result = textInputDialog.showAndWait();
        String results = result.get();

        List<String> timeList = Arrays.asList(results.split(":"));
        startHours = Integer.parseInt(timeList.get(0));
        startMins = Integer.parseInt(timeList.get(1));
        startSecs = Integer.parseInt(timeList.get(2));

        hours = startHours;
        mins = startMins;
        secs = startSecs;

        timerLabel.setText(formatTime(hours,mins,secs));
        endTimeLabel.setText(formatTime(hours,mins,secs));

        timeInSeconds=(hours*3600)+(mins*60)+secs;
        startTimeInSeconds=timeInSeconds;

        advanceTime();

    }

    @FXML void pauseButtonPressed(ActionEvent event){
        paused = !paused;
        if(paused){
            System.out.println("Paused");
        }else{
            System.out.println("Started");
        }
    }

    private void advanceTime(){
            Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                countdown();
            }));
            t.setCycleCount(Animation.INDEFINITE);
            t.play();
    }

    private void countdown(){
        if(!paused) {
            if(secs>0){
              secs--;
             }else{
                if(mins>0){
                    mins--;
                    secs=60;
                }else if(hours>0){
                 hours--;
                 mins=60;
                }
            }

            updateTimeLabels();

            if(hours == 0 && mins == 0 && secs == 0){
                timerLabel.setText("Time's Up!");
            }

            calculateTimeInSeconds();
            double timeProgress = (((double)(startTimeInSeconds-timeInSeconds)/(double)(startTimeInSeconds)));
            timeProgressBar.setProgress(timeProgress);

        }
    }

    private void calculateTimeInSeconds(){
        timeInSeconds = (hours*3600) +(mins*60) +secs;
    }

    private void updateTimeLabels(){

        currentTimeLabel.setText(formatTime(startHours-hours,startMins-mins,startSecs-secs));

        timerLabel.setText(formatTime(hours,mins,secs));


    }

    private String formatTime(int hours, int mins, int secs){

        String result;

        if(hours<10){
            result = "0"+hours+":";
        } else {
            result = hours+":";
        }

        if(mins<10){
            result += "0"+mins+":";
        } else {
            result += mins+":";
        }

        if(secs < 10) {
            result += "0" + secs;
        }
        else{
            result += secs;
        }

        return result;
    }
}
