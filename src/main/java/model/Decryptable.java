package model;

/**
 * @author Michal on 22.10.2018
 */
public interface Decryptable {

    String decrypt(String text, String key) throws CharacterNotFoundException;
}
