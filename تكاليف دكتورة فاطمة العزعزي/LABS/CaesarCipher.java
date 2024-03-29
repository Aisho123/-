public class CaesarCipher {
    protected char[] encoder = new char[26]; // Encryption array
    protected char[] decoder = new char[26]; // Decryption array
    public CaesarCipher(int rotation) {
        for (int k=0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }
     private String transform(String original, char[] code) {
        char[] msg = original.toCharArray( );
         for (int k=0; k < msg.length; k++)
             if (Character.isUpperCase(msg[k])) { // we have a letter to change
                 int j = msg[k] - 'A'; // will be value from 0 to 25
                 msg[k] = code[j]; // replace the character
             }
         return new String(msg);
    }
    public String encrypt(String message) {
        return transform(message, encoder); // use encoder array
    }
    public String decrypt(String secret) {
        return transform(secret, decoder); // use decoder array
    }

    public static void main(String[ ] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        //System.out.println("Encryption code = " + new String(cipher.encoder));
        //System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "HELLO ";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }

}
