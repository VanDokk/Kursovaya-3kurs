package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class MainController {


    @FXML
    private TextField memoryVolumeText;

    @FXML
    private TextField memoryOSText;

    @FXML
    private TextField maxProcessWorktimeText;

    @FXML
    private TextField prioritiesQuantityText;

    @FXML
    private TextField coresQuantityText;

    @FXML
    private TextField cpuSpeedText;

    @FXML
    private TextField startingProcessesText;


    @FXML
    private void click(ActionEvent event) throws IOException {
        if (isValid()) {
            setConfiguration();

            Stage stage = secondWindow();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        else {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Exception.fxml"));
            stage.setTitle("Error");
            stage.setScene(new Scene(root));

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    private void setConfiguration() {
        Configuration.memoryVolume = Integer.parseInt(memoryVolumeText.getText());
        Configuration.OSMemoryVolume = Integer.parseInt(memoryOSText.getText());
        Configuration.maxProcessWorkTime = Integer.parseInt(maxProcessWorktimeText.getText());
        Configuration.prioritiesQuantity = Integer.parseInt(prioritiesQuantityText.getText());
        Configuration.coresQuantity = Integer.parseInt(coresQuantityText.getText());
        Configuration.timerDelay = Integer.parseInt(cpuSpeedText.getText());
        Configuration.startingProcesses = Integer.parseInt(startingProcessesText.getText());
    }

    private Stage secondWindow() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CpuWork.fxml"));
        stage.setTitle("OS emulation");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);

        return stage;
    }

    private boolean isValid() {
       try{
            if (Integer.parseInt(memoryVolumeText.getText()) > 0 && Integer.parseInt(memoryOSText.getText()) > 0 &&
                    Integer.parseInt(maxProcessWorktimeText.getText()) > 0 && Integer.parseInt(prioritiesQuantityText.getText()) > 0 &&
                    Integer.parseInt(coresQuantityText.getText()) > 0 && Integer.parseInt(cpuSpeedText.getText()) > 0 &&
                    Integer.parseInt(startingProcessesText.getText()) > 0) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
        return false;

    }
}