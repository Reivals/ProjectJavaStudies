package model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Michal on 29.10.2018
 */
@RunWith(SpringRunner.class)
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

}