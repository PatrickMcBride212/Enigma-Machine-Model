package com.company;

import java.util.Scanner;

class TypeEncrypt {
    static String Run(Integer D) {
        int EncryptOrDecrypt = -1;
        String Output = "";
        //if EncryptOrDecrypt becomes 0, then decrypt. if it becomes 1 then encrypt.
        System.out.println("Would you like to encrypt a message or decrypt a message? Type E or D for each respective response.");
        boolean ValidResponse = false;
        Scanner Response = new Scanner(System.in).useDelimiter("");
        while (!ValidResponse) {
            String ResponseString = Response.next();
            if (ResponseString.equals("D")||ResponseString.equals("d")) {
                EncryptOrDecrypt = 0;
                ValidResponse = true;
            }
            else if (ResponseString.equals("E")||ResponseString.equals("e")) {
                EncryptOrDecrypt = 1;
                ValidResponse = true;
            }
            else {
                System.out.println("Please enter a valid input of either E or D.");
            }
        }
        System.out.println("Type your message, and press enter when you're done.");
        Scanner Reader = new Scanner(System.in).useDelimiter("\n");
        String Plaintext = "";
        boolean Message = false;
        while (!Message) {
            Plaintext = Reader.next();
            Message = true;
        }
        System.out.println("Your message is:");
        System.out.println(Plaintext);
        switch (EncryptOrDecrypt) {
            case 0: System.out.println("Starting Decryption Process");
                    EnigmaMachine Turing = new EnigmaMachine(D, Plaintext.toString());
                    Output = Turing.Decrypt();
                    break;
            case 1: System.out.println("Starting Encryption Process.");
                    EnigmaMachine Turing1 = new EnigmaMachine(D, Plaintext.toString());
                    Output = Turing1.Encrypt();
                    break;
        }
        return Output;
    }
}
