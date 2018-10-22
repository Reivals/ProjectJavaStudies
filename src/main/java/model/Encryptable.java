package model;

/**
 * @author Michal on 22.10.2018
 */
public interface Encryptable {

    String encrypt(String text,String key) throws CharacterNotFoundException;
}
