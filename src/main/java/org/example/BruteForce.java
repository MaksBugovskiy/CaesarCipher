package org.example;

import java.lang.reflect.Array;

public class BruteForce {

    public void bruteForce(String cipherText) {
        cipherText = cipherText.toUpperCase();
        Constance constance = new Constance();
        String b = constance.EN_ALPHABET_UP;
        for (int k = 0; k < 26; k++) {
            String decryptedText = "";
            int key = k;
            for (int i = 0; i < cipherText.length(); i++) {
                int index = b.indexOf(cipherText.charAt(i));

                if (index == -1) {
                    decryptedText += cipherText.charAt(i);
                    continue;
                }
                if ((index - key) >= 0) {
                    decryptedText += b.charAt(index - key);
                } else {
                    decryptedText += b.charAt((index - key) + 26);
                }
            }

            System.out.println("Decrypted Text Using key" + key + ":");
        }

    }
}

