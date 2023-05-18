package org.example;

import java.util.Scanner;

public class CLI {
    public void openProgramMenu() {
        System.out.println(new Constance().PROGRAM_MAIN_MENU);
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        int action = scanner.nextInt();
        scanner.nextLine();
        if (action == 1) {
            System.out.println("Enter file path:");
            String filePath = scanner.nextLine();
            String textForEncryption = fileService.readFile(filePath);
            if (textForEncryption.length() == 0) {
                return;
            }
            System.out.println("Enter key:");
            int key = scanner.nextInt();
            Encryptor encryptor = new Encryptor();
            fileService.writeFile(filePath, encryptor.encrypt(textForEncryption, key), "[ENCRYPTED]");
        } else if (action == 2) {
            System.out.println("Enter file path:");
            String filePath = scanner.nextLine();
            String textForDecryption = fileService.readFile(filePath);
            if (textForDecryption.length() == 0) {
                return;
            }
            System.out.println("Enter key:");
            int key = scanner.nextInt();
            Decryptor decryptor = new Decryptor();
            fileService.writeFile(filePath, decryptor.decrypt(textForDecryption, key), "[DECRYPTED]");

        } else if (action == 3) {
            BruteForce bruteForce = new BruteForce();
            System.out.println("Enter file path:");
            String filePath = scanner.nextLine();
            bruteForce.bruteForce(filePath);

        } else if (action == 4) {
            System.out.println("Enter file path:");
            String filePath = scanner.nextLine();
            System.out.println(fileService.readFile(filePath));
            ;

        }
    }
}

