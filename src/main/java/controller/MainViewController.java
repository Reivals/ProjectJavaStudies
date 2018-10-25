package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.CharacterNotFoundException;
import model.HistoryOfEncryptions;
import model.VigenereAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    @Autowired
    private VigenereAlgorithm vigenereAlgorithm;

    @Autowired
    private HistoryOfEncryptions historyOfEncryptions;

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

    @FXML
    private TableView<Map.Entry<String, String>> historyTableView;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> textColumn;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> keyColumn;

    ObservableList<Map.Entry<String, String>> items;

    /**
     * Method invoked when execute button is clicked
     */
    @FXML
    void executeButtonClicked() {
        if(taskChoiceBox.getSelectionModel().getSelectedItem().equals("Encrypt")){
            if(inputTextArea.getText()!= null && keyTextField!=null && !inputTextArea.getText().equals("") && !keyTextField.getText().equals("")){
                try {
                    outputTextArea.setText(vigenereAlgorithm.encrypt(inputTextArea.getText(),keyTextField.getText()));
                    updateHistory();
                } catch (CharacterNotFoundException e) {
                    displayAlert("ERROR","Invalid characters", Alert.AlertType.ERROR);
                }
            }
        } else{
            if(inputTextArea.getText()!= null && keyTextField!=null && !inputTextArea.getText().equals("") && !keyTextField.getText().equals("")){
                try {
                    outputTextArea.setText(vigenereAlgorithm.decrypt(inputTextArea.getText(),keyTextField.getText()));
                    updateHistory();
                } catch (CharacterNotFoundException e) {
                    displayAlert("ERROR","Invalid characters", Alert.AlertType.ERROR);
                }
            }
        }

    }

    public void initialize() {
        taskChoiceBox.setItems(choiceBoxList);
        taskChoiceBox.getSelectionModel().selectFirst();
        textColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getKey()));
        keyColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getValue()));
        items = FXCollections.observableArrayList(historyOfEncryptions.getHistory().entrySet());
        historyTableView.setItems(items);
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

    /**
     * Update tableView with newly added history
     */
    private void updateHistory(){
        items.clear();
        historyOfEncryptions.addToHistory(outputTextArea.getText(), keyTextField.getText());
        items = FXCollections.observableArrayList(historyOfEncryptions.getHistory().entrySet());
        historyTableView.setItems(items);
    }

}
