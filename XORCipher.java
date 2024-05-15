package info2;
//Ulrike Hunfeld, Peter Brederlow
import java.util.Arrays;

public class XORCipher {
    
    //
    // This table contains 64 possible chars that are
    // used as alphabet for this encryption exercise.
    // We can use 6 bits (e.g. the most right 6 bits of an
    // int value) to uniquely encode a character.
    //
    public static char[] CHAR_TABLE = {
        ' ', '\n', ',', '.', '\'', '-', ':', ';', '?', '(', ')', '!',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    };
    
    // ----------------------------------------------------------------
    // Exercise 2 (a)
    // ----------------------------------------------------------------

    // TODO: implement valueToChar
    public static char valueToChar(int code){
        if(code < 0 || code > 63 ) {return ' ';}
        return CHAR_TABLE[code];
    }
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (b) 
    // ----------------------------------------------------------------
    
    // TODO: implement charToValue
    public static int charToValue(char chr){
        for (int i = 0; i < CHAR_TABLE.length; i++){
            if (chr == CHAR_TABLE[i]){
                return i;
            }
        }
        return 0;
    }
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (c)
    // ----------------------------------------------------------------
    
    // TODO: implement stringToValue
    public static int[] stringToValues(String str){
        //return array of length 0 when str is null
        if (str == null){
            int[] empty = new int[0];
            return empty;
        }
        //fill int[] with values received from charToValue
        int[] toValue = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            toValue[i] = charToValue(str.charAt(i));
        }
        return toValue;
    }
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (d)
    // ----------------------------------------------------------------
    
    // TODO: implement valuesToString
    public static String valuesToString(int[] codes){
        //return empty String when codes is null
        if (codes == null){ return "";}
        //build String with chars received from valueToChar
        String toString = "";
        for (int i = 0; i < codes.length; i++){
            toString += valueToChar(codes[i]);
        }
        return toString;
    }
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (e)
    // ----------------------------------------------------------------

    // TODO: implement encryptDecrypt for type int[]
    public static int[] encryptDecrypt(int[] msg, int[] key){
        //return msg if msg or key is null
        if (msg == null || msg.length == 0 || key == null || key.length == 0){ return msg;}

        //decrypt msg
        int[] encrypted = new int[msg.length];

        for(int i = 0; i < msg.length; i++){
            int j = i % key.length;
            encrypted[i] = msg[i] ^ key[j];
        }

        return encrypted;
    }

    
    // ----------------------------------------------------------------
    // Exercise 2 (f)
    // ----------------------------------------------------------------
    
    // TODO: implement encryptDecryot for type String
        public static String encryptDecrypt(String msg, String key){
        int[] m = stringToValues(msg);
        int[] k = stringToValues(key);
        int[] encryptedValues = encryptDecrypt(m,k);
        return valuesToString(encryptedValues);
        }

    
    
    // ----------------------------------------------------------------
    
    public static void main(String[] args) {
        final String msg = "Dieser Text ist sehr geheim...";
        final String key = "keyword";
        
         final String cipher = encryptDecrypt(msg, key);
         final String decrypted = encryptDecrypt(cipher, key);
        
        //
        // Wenn alles richtig implementiert wurde, sollte
        // der String decrypted wieder genau dem String 
        // msg entsprechen, waehrend der String cipher fuer
        // uns nicht lesbar ist.
        //
        
         System.out.println(msg);
         System.out.println(cipher);
         System.out.println(decrypted);
        
        System.out.println();


    }
}