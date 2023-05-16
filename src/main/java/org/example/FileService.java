package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService {

    public static String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }


    public static void writeEncryptedFile(String filePath, String fileContent) throws IOException {
        writeFile(filePath, fileContent, "[ENCRYPTED]");
    }


    public static void writeDecryptedFile(String filePath, String fileContent) throws IOException {
        writeFile(filePath, fileContent, "[DECRYPTED]");
    }


  /*  public static void writeDecryptedFileBruteForce(String filePath, String fileContent) throws IOException {
        writeFile(filePath, fileContent, "[B key-" + CaesarCipher.bestKey + "]");
    }*/


    private static void writeFile(String filePath, String fileContent, String status) throws IOException {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        String fileExtension = "";
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex > 0) {
            fileExtension = fileName.substring(extensionIndex);
            fileName = fileName.substring(0, extensionIndex);
        }

        String newFileName = fileName + status + fileExtension;
        Path newFilePath = path.resolveSibling(newFileName);
        Files.writeString(newFilePath, fileContent);
    }
}