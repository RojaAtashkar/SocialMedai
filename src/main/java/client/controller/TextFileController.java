package client.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class TextFileController {
    private static TextFileController instance;
    private static void setInstance(TextFileController textFileController){
        instance = textFileController;
    }
    public static TextFileController getInstance(){
        if (instance == null)
            setInstance(new TextFileController());
        return instance;
    }
    public String writeFile(String text, String fileName, String dirAddress) {
        String fileAddress = dirAddress + fileName + ".txt";
        File myObj = new File(fileAddress);
        try {
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(fileAddress);
                myWriter.write(text);
                myWriter.close();
            }
        }
        catch (Exception e){
            System.out.println("Error while creating or writing in to file in controller.Controller :" + fileAddress);
            e.printStackTrace();
        }
        return fileAddress;
    }
    public String readFile(String fileAddress){
        String text = "";
        try {
            File myObj = new File(fileAddress);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                text += data + "\n";
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error while reading from file :" + fileAddress);
            e.printStackTrace();
        }
        return text;
    }
}
