package model;

/**
 * Interface which provide method for encoding text
 * @author Michal on 22.10.2018
 * @version 1.0
 */
public interface Encryptable {

    /**
     * Template of method which will take care about encoding text
     * @param text Text which will be encoded by function
     * @param key Key which will be used to encode
     * @return Returns encoded text
     */
    String encrypt(String text,String key) throws CharacterNotFoundException;
}
