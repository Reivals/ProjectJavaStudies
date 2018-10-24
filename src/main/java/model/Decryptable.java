package model;

/**
 * Interface which provide method for decoding text
 * @author Michal on 22.10.2018
 * @version 1.0
 */
public interface Decryptable {

    /**
     * Template of method which will take care about decrypting text
     * @param text Text which will be decoded by function
     * @param key Key which will be used to decode
     * @return Returns decoded text
     */
    String decrypt(String text, String key) throws CharacterNotFoundException;
}
