package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import model.CharacterNotFoundException;
import model.VigenereAlgorithm;
import org.springframework.stereotype.Component;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 * Main application controller (load as first)
 */
@Component
public class MainViewController implements IController {
    // initialize list of options which will be injected into view (choiceBox)
    private static ObservableList<String> choiceBoxList;

    static{
        choiceBoxList = FXCollections.observableArrayList("Encrypt", "Decrypt");
    }

    private VigenereAlgorithm vigenereAlgorithm;

    /**
     * Input text area where user enter his message
     */
    @FXML
    private JFXTextArea inputTextArea;

    /**
     * Output text area where output is displayed
     */
    @FXML
    private JFXTextArea outputTextArea;

    /**
     * Choice box where you can select which action to perform
     */
    @FXML
    private ChoiceBox<String> taskChoiceBox;

    /**
     * Choice box where you can select which action to perform
     */
    @FXML
    private JFXTextField keyTextField;

    /**
     * Button, when pressed it encrypt/decode message
     */
    @FXML
    private JFXButton executeButton;

    public MainViewController(VigenereAlgorithm vigenereAlgorithm) {
        this.vigenereAlgorithm = vigenereAlgorithm;
    }

    /**
     * Method invoked when execute button is clicked
     */
    @FXML
    void executeButtonClicked() {
        if(taskChoiceBox.getSelectionModel().getSelectedItem().equals("Encrypt")){
            if(inputTextArea.getText()!= null && keyTextField!=null && !inputTextArea.getText().equals("") && !keyTextField.getText().equals("")){
                try {
                    outputTextArea.setText(vigenereAlgorithm.encrypt(inputTextArea.getText(),keyTextField.getText()));
                } catch (CharacterNotFoundException e) {
                    displayAlert("ERROR","Invalid characters", Alert.AlertType.ERROR);
                }
            }
        } else{
            if(inputTextArea.getText()!= null && keyTextField!=null && !inputTextArea.getText().equals("") && !keyTextField.getText().equals("")){
                try {
                    outputTextArea.setText(vigenereAlgorithm.decrypt(inputTextArea.getText(),keyTextField.getText()));
                } catch (CharacterNotFoundException e) {
                    displayAlert("ERROR","Invalid characters", Alert.AlertType.ERROR);
                }
            }
        }

    }

    public void initialize() {
        taskChoiceBox.setItems(choiceBoxList);
        taskChoiceBox.getSelectionModel().selectFirst();
    }

    /**
     * Exception handler - method which take care about exceptions
     * @param header Header for alert
     * @param message Message inside alert
     * @param alertType Type of alert which should be displayed eg. ERROR
     */
    private void displayAlert(String header, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }
}
