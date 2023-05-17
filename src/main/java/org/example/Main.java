package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Constance().PROGRAM_MAIN_MENU);
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        int action = 0;
        //  boolean actionChosen = false;
        // while (!actionChosen) {
        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            //    actionChosen = true;
        } else {
            System.out.println("Please select action or exit program");
            // if (scanner.nextInt()
        }
        // }
        if (action == 1) {
            System.out.println("Enter file path:");
            String filePath = "/Users/feed/IdeaProjects/CaesarCipher/src/main/java/org/example/Hamlet.txt";//scanner.nextLine();

            String textForEncryption = fileService.readFile(filePath);
            System.out.println("Enter key:");
            int key = scanner.nextInt();
            Encryptor encryptor = new Encryptor();
            fileService.writeFile(filePath, encryptor.encrypt(textForEncryption, key), "[ENCRYPTED]");
        } else if (action == 2) {
            System.out.println("Enter file path:");
            String filePath = "/Users/feed/IdeaProjects/CaesarCipher/src/main/java/org/example/Hamlet[ENCRYPTED].txt";//scanner.nextLine();

            String textForEncryption = fileService.readFile(filePath);
            System.out.println("Enter key:");
            int key = scanner.nextInt();
            //Encryptor encryptor = new Encryptor();
            Decryptor decryptor = new Decryptor();
            fileService.writeFile(filePath, decryptor.decrypt(textForEncryption, key), "[DECRYPTED]");

        } else if (action == 3) {
            BruteForce bruteForce = new BruteForce();
            String filePath = "/Users/feed/IdeaProjects/CaesarCipher/src/main/java/org/example/Hamlet[ENCRYPTED].txt";
            String encryptedText = fileService.readFile(filePath);
            bruteForce.bruteForce(encryptedText);

        }
    }
}