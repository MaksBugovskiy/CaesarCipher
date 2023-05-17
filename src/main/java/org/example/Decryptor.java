package org.example;

public class Decryptor {

    public String decrypt(String text, int key) {
        //Constants with alphabets
        Constance constance = new Constance();
        String alphabet = constance.EN_ALPHABET_UP + constance.EN_ALPHABET_LOW + constance.SYMBOLS;
        int alphabetLength = alphabet.length();
        int decryptKey = (alphabetLength - key) % alphabetLength;
        //Use encryptor for decrypt with decrypt key
        Encryptor encryptor = new Encryptor();
        return encryptor.encrypt(text,decryptKey);
    }
}
