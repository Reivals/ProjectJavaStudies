package controller;

import javafx.fxml.FXML;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 */
public interface IController {

    /**
     * Method is being invoked each time when controller is instantiated by FXMLloader
     */
    @FXML
    void initialize();
}
