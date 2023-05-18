package org.example;

import java.lang.reflect.Array;

public class BruteForce {

    public void bruteForce(String filePath) {
        Constance constance = new Constance();
        FileService fileService = new FileService();
        String encryptedText = fileService.readFile(filePath);
        String alphabet = constance.EN_ALPHABET_UP + constance.EN_ALPHABET_LOW + constance.SYMBOLS;
        for (int k = 0; k < 26; k++) {
            String decryptedText = "";
            int key = k;
            for (int i = 0; i < encryptedText.length(); i++) {
                int index = alphabet.indexOf(encryptedText.charAt(i));

                if (index == -1) {
                    decryptedText += encryptedText.charAt(i);
                    continue;
                }
                if ((index - key) >= 0) {
                    decryptedText += alphabet.charAt(index - key);
                } else {
                    decryptedText += alphabet.charAt((index - key) + alphabet.length());
                }
            }

            if (keyFound(decryptedText)) {
                System.out.println("Decrypted Text Using key " + key);
                fileService.writeFile(filePath,decryptedText,"[B key-" + key + "]");
                return;
            }

            //System.out.println("Decrypted Text Using key" + key + ":");
        }

    }

    private Boolean keyFound(String decryptedText) {
        int charIndex = decryptedText.indexOf(",");
        if (charIndex >= 0) {
            String nextChar = decryptedText.substring(charIndex + 1, charIndex + 2);
            if (nextChar.equals(" ")) {
                String lastCheckedSymbol = decryptedText.substring(charIndex + 2, charIndex + 3);
                if (Character.isUpperCase(lastCheckedSymbol.charAt(0))) {
                    return true;
                }
            }

        }
        return false;
    }
}

