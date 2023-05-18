package org.example;

public class BruteForce {

    public void bruteForce(String filePath) {
        Constance constance = new Constance();
        FileService fileService = new FileService();
        String encryptedText = fileService.readFile(filePath);
        String alphabet = constance.EN_ALPHABET_UP + constance.EN_ALPHABET_LOW + constance.SYMBOLS;
        for (int i = 1; i < alphabet.length(); i++) {
            String decryptedText = "";
            int key = i;
            for (int j = 0; j < encryptedText.length(); j++) {
                int index = alphabet.indexOf(encryptedText.charAt(j));

                if (index == -1) {
                    decryptedText += encryptedText.charAt(j);
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
                fileService.writeFile(filePath, decryptedText, "[B key-" + key + "]");
                return;
            }
        }

    }

    private Boolean keyFound(String decryptedText) {
        int charIndex = decryptedText.indexOf(".");
        if (charIndex >= 0) {
            String nextChar = decryptedText.substring(charIndex + 1, charIndex + 2);
            if (nextChar.equals(" ")) {
                String lastCheckedSymbol = decryptedText.substring(charIndex + 2, charIndex + 3);
                if (Character.isUpperCase(lastCheckedSymbol.charAt(0))) {
                    return true;
                }

            } else if (nextChar.equals("\n")) {
                String searchSubstring = decryptedText.substring(charIndex + 1);
                for (int i = 0; i < searchSubstring.length(); i++) {
                    char searchingUpperCaseLetter = searchSubstring.charAt(i);
                    if (Character.isLetter(searchingUpperCaseLetter) || Character.isUpperCase(searchingUpperCaseLetter)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

