package model;

/**
 * @author Michal on 22.10.2018
 * Own created exception (on demand)
 */
public class CharacterNotFoundException extends Exception{

    /**
     * Exception thrown when character isnt present in alphabet table
     * @param message error message
     */
    public CharacterNotFoundException(String message) {
        super(message);
    }
}
