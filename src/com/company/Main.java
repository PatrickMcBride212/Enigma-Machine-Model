package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //two variables: the message and the date (used for calculating the encryption settings)
        String Message = new String("");
        String Output = null;
        Integer Date = null;
        String ReadType = null;
        //first let's introduce the program and get the input for the settings
        System.out.println("Hello! Welcome to the Digital Enigma Machine!");
        System.out.println("This program can serve both encryption and decryption functions.");
        System.out.println("This cypher supports all printable (standard) ASCII characters.");
        System.out.println("First, please enter the date of the message in the form MMDDYYYY (with no spaces or delimiters)");
        Scanner Reader = new Scanner(System.in);
        boolean ValidInt = false;
        //checking that the user put in a number that will work as a representation of the date, by the number of digits it has.
        //since dates are just parameters for encryption, they don't have to correspond to the actual date the message was written,
        //it can even be a date in the future.
        while (!ValidInt) {
            try {
                Date = Integer.parseInt(Reader.next());
                if (Date.toString().length() == 8 || Date.toString().length() == 7) {
                    ValidInt = true;
                } else {
                    System.out.println("Please try again and enter the date in MMDDYYYY format.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please try again and enter the date in MMDDYYYY format.");
                System.out.println(e.getLocalizedMessage());
            }
        }
        System.out.println("You entered: " + Date);
        System.out.println("Would you like to read from typing or read from a file?");
        System.out.println("Type f or t for file or type");
        boolean ReadTypeValid = false;
        while (!ReadTypeValid) {
            String current = Reader.next();
            if (List.of("f", "F", "t", "T").contains(current)) {
                ReadTypeValid = true;
                if (current.equals("f")||current.equals("F")) {
                    Output = FileEncrypt.Run(Date);
                } else {
                    Output = TypeEncrypt.Run(Date);
                }
            } else {
                System.out.println("Please enter either f for file, or t for type.");
                System.out.println("You typed: " + current);
            }
        }
        System.out.println("Encryption Completed. Your Output:");
        System.out.println(Output);
        System.out.println("Press any key and then enter to exit.");
        while (Reader.hasNext()) {
            System.exit(0);
        }
    }
}
