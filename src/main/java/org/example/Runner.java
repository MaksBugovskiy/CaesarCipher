package org.example;

public class Runner {

    public void runProgram(String[] arguments) {
        if (arguments.length > 0) {
            FileService fileService = new FileService();
            String filePath = String.valueOf(arguments[1]);
            System.out.println(arguments[1]);
            if (arguments[0].toLowerCase().equals("encrypt")) {
                Encryptor encryptor = new Encryptor();
                String textForEncryption = fileService.readFile(filePath);
                fileService.writeFile(filePath, encryptor.encrypt(textForEncryption, Integer.parseInt(arguments[2])), "[ENCRYPTED]");
            } else if (arguments[0].toLowerCase().equals("decrypt")) {
                Decryptor decryptor = new Decryptor();
                String textForDecryption = fileService.readFile(filePath);
                fileService.writeFile(filePath, decryptor.decrypt(textForDecryption, Integer.parseInt(arguments[2])), "[DECRYPTED]");
            } else if (arguments[0].toLowerCase().equals("brute_force")) {
                BruteForce bruteForce = new BruteForce();
                bruteForce.bruteForce(filePath);
            }else{
                System.out.println("Command error. Please check correctness of the command!!!");
            }

        } else {
            CLI cli = new CLI();
            cli.openProgramMenu();
        }

    }
}
