package model;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


/**
 * @author Michal on 08.11.2018
 */
@RunWith(SpringRunner.class)
@TesterInfo(createdBy = "Michal Karkowski",
        lastModified = "09/11/2018")
public class HistoryOfEncryptionsTest {

    private HistoryOfEncryptions historyOfEncryptions;

    @Before
    public void beforeClass() {
        historyOfEncryptions = new HistoryOfEncryptions();
    }

    @Test
    public void addToHistory_WITH_PROPER_VALUES() throws InvalidArgumentException {
        historyOfEncryptions.addToHistory("abc","abc");
        assertEquals(historyOfEncryptions.getHistory().get("abc"),"abc");
    }


    @Test(expected = InvalidArgumentException.class)
    public void addToHistory_WITH_EMPTY_STRING_VALUES() throws InvalidArgumentException {
        historyOfEncryptions.addToHistory("","");
    }

    @Test(expected = InvalidArgumentException.class)
    public void addToHistory_WITH_NULL_TEXT_VALUE() throws InvalidArgumentException {
        historyOfEncryptions.addToHistory(null, "abc");
    }

    @Test(expected = InvalidArgumentException.class)
    public void addToHistory_WITH_NULL_KEY_VALUE() throws InvalidArgumentException {
        historyOfEncryptions.addToHistory("abc", null);
    }



}