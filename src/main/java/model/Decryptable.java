package model;

/**
 * @author Michal on 22.10.2018
 */
public interface Decryptable {

    /*
     * template of method which will take care about decrypting text
     */
    String decrypt(String text, String key) throws CharacterNotFoundException;
}
