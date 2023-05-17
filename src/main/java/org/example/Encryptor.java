package org.example;

public class Encryptor {

//    public String encrypt(String text, int key) {
//        //Constants with alphabets
//        Constance constance = new Constance();
//        String alphabetUpCase = constance.EN_ALPHABET_UP;
//        String alphabetLowCase = constance.EN_ALPHABET_LOW;
//        String symbols = constance.SYMBOLS;
//        //The keyValue is calculated using the En(x) = (x + n) % 26 formula
//        // and character at that position replaceChar is then added to the string encryptedText.
//        StringBuilder encryptedText = new StringBuilder();
//        for (int i = 0; i < text.length(); i++) {
//            if (Character.isUpperCase(text.charAt(i))) {
//                int charIndex = alphabetUpCase.indexOf(text.charAt(i));
//                int keyValue = (key + charIndex) % alphabetUpCase.length();
//                //char replaceChar = alphabetUpCase.charAt(keyValue);
//                encryptedText.append(alphabetUpCase.charAt(keyValue));
//            } else if (Character.isLowerCase(text.charAt(i))) {
//                int charIndex = alphabetLowCase.indexOf(text.charAt(i));
//                int keyValue = (key + charIndex) % alphabetLowCase.length();
//               // char replaceChar = alphabetLowCase.charAt(keyValue);
//                encryptedText.append(alphabetLowCase.charAt(keyValue));
//            } else if (symbols.indexOf(text.charAt(i))>0) {
//                int charIndex = symbols.indexOf(text.charAt(i));
//                int keyValue = (key + charIndex) % symbols.length();
//                //char replaceChar = symbols.charAt(keyValue);
//                encryptedText.append(symbols.charAt(keyValue));
//            } else {
//                encryptedText.append(text.charAt(i));
//            }
//        }
//
//        return encryptedText.toString();
//    }

    public String encrypt(String text, int key) {
        //Constants with alphabets
        Constance constance = new Constance();
        String alphabet = constance.EN_ALPHABET_UP+constance.EN_ALPHABET_LOW+constance.SYMBOLS;
        String alphabetLowCase = constance.EN_ALPHABET_LOW;
        String symbols = constance.SYMBOLS;
        //The keyValue is calculated using the En(x) = (x + n) % 26 formula
        // and character at that position replaceChar is then added to the string encryptedText.
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int charIndex = alphabet.indexOf(text.charAt(i));
            int keyValue = (key + charIndex) % alphabet.length();
            if (Character.isUpperCase(text.charAt(i))) {


                //char replaceChar = alphabetUpCase.charAt(keyValue);
                encryptedText.append(Character.toUpperCase(alphabet.charAt(keyValue)));
            } else if (Character.isLowerCase(text.charAt(i))) {
               // int charIndex = alphabet.indexOf(text.charAt(i));
               // int keyValue = (key + charIndex) % alphabetLowCase.length();
                // char replaceChar = alphabetLowCase.charAt(keyValue);
                encryptedText.append(Character.toLowerCase(alphabet.charAt(keyValue)));
            }
//            else if (Character.valueOf(text.charAt(i))>0) {
//               // int charIndex = symbols.indexOf(text.charAt(i));
//               // int keyValue = (key + charIndex) % symbols.length();
//                //char replaceChar = symbols.charAt(keyValue);
//                encryptedText.append(symbols.charAt(keyValue));
//            }
            else {
                encryptedText.append(text.charAt(i));
            }
        }

        return encryptedText.toString();
    }
}
