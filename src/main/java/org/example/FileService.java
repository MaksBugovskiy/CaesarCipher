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

    public void writeFile(String filePath, String fileContent, String fileStatus){
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        String fileExtension = "";
        int extensionIndex = fileName.lastIndexOf('.');
        int bracketIndex = fileName.indexOf('[');
        if (extensionIndex > 0) {
            fileExtension = fileName.substring(extensionIndex);
            if (bracketIndex > 0) {
                fileName = fileName.substring(0, bracketIndex);
            }else {
                fileName = fileName.substring(0, extensionIndex);
            }
        }

        String newFileName = fileName + fileStatus + fileExtension;
        Path newFilePath = path.resolveSibling(newFileName);
        try{
            Files.writeString(newFilePath, fileContent);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}