package model;

/**
 * @author Michal on 22.10.2018
 * Own created exception (on demand)
 */
public class CharacterNotFoundException extends Exception{

    public CharacterNotFoundException(String message) {
        super(message);
    }
}
