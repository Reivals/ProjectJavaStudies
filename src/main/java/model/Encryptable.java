package model;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 */
public interface Encryptable {

    /**
     * Template of method which will take care about encrypting text
     */
    String encrypt(String text,String key) throws CharacterNotFoundException;
}
