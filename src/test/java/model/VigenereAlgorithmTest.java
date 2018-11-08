package model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Michal on 29.10.2018
 */
@RunWith(SpringRunner.class)
@TesterInfo(createdBy = "Michal Karkowski",
            lastModified = "09/11/2018")
public class VigenereAlgorithmTest {

    private static VigenereAlgorithm vigenereAlgorithm;

    @BeforeClass
    public static void beforeClass() {
        vigenereAlgorithm = new VigenereAlgorithm("abcdefghijklmn? opqrstuvwxyzáéíóúABCDEFGHIJKLMN?OPQRSTUVWXYZÁÉÍÓÚ1234567890.,;_:+-*/ @$€#??!?=()[]{}\\\"");
    }

    @Test
    public void encrypt_WITH_CORRECT_DATA() throws CharacterNotFoundException {
        assertEquals(vigenereAlgorithm.encrypt("abc","abc"),"ace");
    }


    @Test(expected =  CharacterNotFoundException.class)
    public void encrypt_WITH_INCORRECT_DATA() throws CharacterNotFoundException {
        vigenereAlgorithm.encrypt("漢字","abc");
    }


    @Test
    public void decrypt_WITH_CORRECT_DATA() throws CharacterNotFoundException {
        assertEquals(vigenereAlgorithm.decrypt("ace","abc"),"abc");
    }

    @Test(expected = CharacterNotFoundException.class)
    public void decrypt_WITH_INCORRECT_DATA() throws CharacterNotFoundException {
        assertEquals(vigenereAlgorithm.decrypt("漢字","abc"),"abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_WITH_EMPTY_TEXT_STRING_PASSED() throws CharacterNotFoundException, IllegalArgumentException {
        assertEquals(vigenereAlgorithm.decrypt("","abc"),"");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_WITH_EMPTY_KEY_STRING_PASSED() throws CharacterNotFoundException, IllegalArgumentException {
        assertEquals(vigenereAlgorithm.decrypt("abc",""),"");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_WITH_NULL_KEY_STRING_PASSED() throws CharacterNotFoundException, IllegalArgumentException {
        assertEquals(vigenereAlgorithm.decrypt(null,""),"");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_WITH_NULL_TEXT_STRING_PASSED() throws CharacterNotFoundException, IllegalArgumentException {
        assertEquals(vigenereAlgorithm.decrypt("abc",null),"");
    }

}