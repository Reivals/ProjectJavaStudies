package model;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 * Exception which is invoked when character entered by user is not in vigenere alphabet
 */
public class CharacterNotFoundException extends Exception{

    /**
     * Constructor
     * @param message Error message
     */
    public CharacterNotFoundException(String message) {
        super(message);
    }
}
