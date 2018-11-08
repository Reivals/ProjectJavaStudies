package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import org.springframework.stereotype.Component;

/**
 * Class representing history of messages encrypted
 * @author Michal on 24.10.2018
 * @version 1.0
 */
@Component
public class HistoryOfEncryptions {

    /**
     * Container for history - contains key which was used for encryption and a text which was encrypted
     * Contains only one key per message.
     * If user will try to encode another massage with the same key, last value will be replaced
     */
    private final ObservableMap<String,String> history = FXCollections.observableHashMap();

    /**
     * @param text text which was encrypted
     * @param key key which was used for encryption
     */
    public void addToHistory(String text, String key){
        history.put(key,text);
    }

    public ObservableMap<String, String> getHistory() {
        return history;
    }
}
