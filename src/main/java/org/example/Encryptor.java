package org.example;

public class Encryptor {
    public String encrypt(String text, int key) {
        //Constants with alphabets
        Constance constance = new Constance();
        String alphabet = constance.EN_ALPHABET_UP + constance.EN_ALPHABET_LOW + constance.SYMBOLS;

        //The keyValue is calculated using the En(x) = (x + n) % 26 formula
        // and character at that position replaceChar is then added to the string encryptedText.
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int charIndex = alphabet.indexOf(text.charAt(i));
            if (charIndex >= 0) {
                int keyValue = (key + charIndex) % alphabet.length();
                encryptedText.append(alphabet.charAt(keyValue));
            } else {
                encryptedText.append(text.charAt(i));
            }
        }

        return encryptedText.toString();
    }

}
