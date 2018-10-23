package model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Michal on 22.10.2018
 * @version 1.0
 */
@Component
@PropertySource("classpath:properties/spring.properties")
public class VigenereAlgorithm implements Encryptable,Decryptable{


    //Value of alphabet injected from spring.properties (allow dynamically change alphabet)
    @Value("${encryption.alphabet}")
    private String table;

    public String encrypt(String text,String key) throws CharacterNotFoundException {
        String formattedText = formatTextToProperForm(text);
        StringBuilder encryptedMessage = new StringBuilder();
        for(int t = 0,k= 0; t < formattedText.length(); t++,k= (k+1) % key.length())
        {
            int position = (table.indexOf(formattedText.charAt(t)) + table.indexOf(key.charAt(k))) % table.length();
            encryptedMessage.append(table.charAt(position));
        }
        return encryptedMessage.toString();
    }

    public String decrypt(String text,String key) throws CharacterNotFoundException {
        String formattedText = formatTextToProperForm(text);
        StringBuilder decrypted = new StringBuilder();
        for(int t = 0, k = 0; t < formattedText.length(); t++,k= (k+1) % key .length())
        {
            int position = (table.indexOf(formattedText.charAt(t)) - table.indexOf(key.charAt(k)));
            position = (position < 0)?(position + table.length()): position;
            decrypted.append(table.charAt(position));
        }
        return decrypted.toString();
    }

    private String formatTextToProperForm(String text) throws CharacterNotFoundException {
        text = text.replaceAll("\n", "");
        for(int x = 0; x < text.length(); x++)
        {
            int position = table.indexOf(text.charAt(x));
            if (position == -1)
            {
                throw new CharacterNotFoundException("Invalid character. Please make sure if it is present in alphabet.");
            }
        }
        return text;
    }

}
