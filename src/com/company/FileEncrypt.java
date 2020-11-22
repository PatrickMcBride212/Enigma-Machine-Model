package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileEncrypt {
    static String Run(Integer D) {
        System.out.println("Please enter the name of your file (make sure it's in the working directory).");
        Scanner FileReader = new Scanner(System.in);
        Scanner Reader = null;
        boolean ValidFile = false;
        while (!ValidFile) {
            try {
                Reader = new Scanner(new File(FileReader.next()));
                ValidFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("Please enter a valid file name. Make sure it's in the working directory.");
                System.out.println(e.getLocalizedMessage());
            }
        }
        String Text = PreEncrypt(Reader);
        EnigmaMachine Turing = new EnigmaMachine(D, Text);
        return Turing.Encrypt();
    }
    //takes the scanner, reads the file and puts it into a string, and then feeds the string to the enigma machine
    private static String PreEncrypt(Scanner ReadFile) {
        StringBuilder PlainText = new StringBuilder();
        while (ReadFile.hasNext()) {
            PlainText.append(" ").append(ReadFile.next());
        }
        return PlainText.toString();
    }
}
