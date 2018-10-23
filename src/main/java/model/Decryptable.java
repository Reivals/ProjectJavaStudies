package model;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 */
public interface Decryptable {

    /**
     * Template of method which will take care about decrypting text
     */
    String decrypt(String text, String key) throws CharacterNotFoundException;
}
