package model;

/**
 * @author Michal on 22.10.2018
 */
public interface Encryptable {

    /*
     * template of method which will take care about encrypting text
     */
    String encrypt(String text,String key) throws CharacterNotFoundException;
}
