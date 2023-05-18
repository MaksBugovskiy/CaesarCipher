package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService {

    public String readFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public void writeFile(String filePath, String fileContent, String operation) {
        Path path = Paths.get(filePath);
        String originalFileName = path.getFileName().toString();
        int extensionIndex = originalFileName.lastIndexOf('.');
        String fileExtension = originalFileName.substring(extensionIndex);
        String fileName = "";

        int bracketIndex = originalFileName.indexOf('[');
        if (extensionIndex > 0) {
            if (bracketIndex > 0) {
                fileName = originalFileName.substring(0, bracketIndex);
            } else {
                fileName = originalFileName.substring(0, extensionIndex);
            }
        }


        String newFileName = fileName + operation + fileExtension;
        Path newFilePath = path.resolveSibling(newFileName);
        try {
            Files.writeString(newFilePath, fileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}