package com.company;
import java.lang.reflect.Array;
import java.util.*;
class EnigmaMachine {
    private String PlainText;
    private Integer Date;
    private String[] NumbersToCharKey;
    private HashMap<String, Integer> CharToNumbersKey;
    private Integer[] Rotor1;
    private Integer[] Rotor2;
    private Integer[] Rotor3;
    private Integer[] Rotor4;
    private Integer[] Rotor5;
    private Integer[] Rotor6;
    private Integer[] Rotor7;
    private Integer[] Rotor8;
    private Integer[] Rotor9;
    private Integer[] Rotor0;
    private Integer[] Rotor1Inverse;
    private Integer[] Rotor2Inverse;
    private Integer[] Rotor3Inverse;
    private Integer[] Rotor4Inverse;
    private Integer[] Rotor5Inverse;
    private Integer[] Rotor6Inverse;
    private Integer[] Rotor7Inverse;
    private Integer[] Rotor8Inverse;
    private Integer[] Rotor9Inverse;
    private Integer[] Rotor0Inverse;
    EnigmaMachine(Integer D, String PT) {
        Date = D;
        PlainText = PT;
        //Establishing standard conversion from integers to characters (index of character + 1 is the conversion, due to java zero indexing)
        NumbersToCharKey = new String[] {" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~"};
        //Establishing conversion from characters to numbers. Fills from the NumbersToCharKey array.
        CharToNumbersKey = new HashMap<String, Integer>(127, (float) 0.75);
        for (int s = 0; s < 95; s++) {
            String CurrentChar = NumbersToCharKey[s];
            CharToNumbersKey.put(CurrentChar, s+1);
        }
        //add contents of rotor in last set of parentheses (95 characters per rotor)
        //the rotors essentially act as a function, the index is the input value and the integer stored there is the value that it's mapped to. At this point, the
        //encryption process has been abstracted from the wiring in rotors from one letter to another, and been replaced with
        //numbers that map to each other, and letters are only applied when translating the characters to the numbers, or numbers back
        //to characters using the key.
        //the sequences for the rotors were randomly generated via random.org/sequences
        Rotor1 = new Integer [] {60, 66, 16, 28, 10, 57, 58, 40, 55, 45, 92, 44, 6, 52, 48, 85, 7, 83, 22, 34, 37, 73, 24, 31, 94, 65, 71, 36, 25, 20, 79, 9, 75, 49, 41, 30, 21, 23, 67, 42, 29, 27, 74, 53, 18, 68, 8, 11, 82, 33, 63, 0, 72, 38, 77, 89, 70, 17, 64, 4, 35, 62, 43, 46, 78, 69, 1, 87, 51, 12, 56, 13, 3, 14, 32, 26, 47, 54, 2, 39, 93, 88, 19, 91, 59, 81, 80, 84, 76, 15, 50, 61, 86, 90, 5};
        Rotor2 = new Integer [] {84, 77, 83, 21, 27, 44, 61, 0, 74, 10, 22, 50, 91, 54, 13, 56, 66, 51, 71, 73, 58, 1, 72, 37, 47, 34, 94, 48, 38, 31, 68, 80, 45, 3, 53, 69, 87, 60, 14, 78, 41, 85, 75, 82, 11, 70, 28, 29, 40, 46, 81, 25, 42, 64, 7, 36, 76, 39, 17, 16, 23, 9, 89, 35, 15, 59, 19, 67, 33, 4, 24, 79, 86, 57, 43, 92, 93, 8, 6, 52, 30, 62, 5, 26, 65, 49, 2, 90, 63, 32, 18, 12, 55, 20, 88};
        Rotor3 = new Integer [] {5, 36, 17, 50, 45, 51, 15, 19, 84, 35, 18, 43, 14, 93, 71, 34, 52, 67, 78, 26, 0, 39, 65, 4, 55, 31, 58, 76, 89, 42, 82, 46, 85, 92, 8, 11, 87, 88, 2, 1, 86, 40, 27, 20, 12, 90, 48, 9, 59, 94, 44, 81, 29, 75, 83, 68, 13, 28, 53, 60, 24, 41, 63, 21, 74, 73, 49, 7, 62, 56, 33, 61, 57, 3, 69, 77, 70, 47, 37, 6, 91, 79, 32, 54, 30, 66, 72, 64, 22, 23, 16, 10, 80, 25, 38};
        Rotor3 = new Integer [] {28, 69, 91, 9, 49, 1, 33, 36, 20, 66, 63, 58, 65, 80, 50, 24, 79, 82, 32, 17, 46, 86, 68, 59, 14, 34, 35, 60, 27, 51, 75, 3, 62, 73, 16, 43, 11, 64, 90, 71, 88, 67, 87, 48, 29, 41, 39, 10, 47, 26, 92, 22, 74, 30, 42, 6, 85, 81, 83, 61, 93, 5, 31, 0, 52, 44, 45, 84, 2, 12, 4, 15, 57, 18, 94, 55, 38, 23, 89, 40, 25, 54, 53, 72, 70, 76, 78, 21, 56, 19, 7, 77, 8, 37, 13};
        Rotor4 = new Integer [] {35, 32, 42, 77, 24, 34, 46, 4, 11, 31, 47, 30, 6, 56, 13, 62, 8, 17, 36, 61, 86, 38, 87, 81, 78, 53, 59, 33, 37, 19, 89, 94, 58, 79, 41, 5, 44, 2, 1, 29, 82, 12, 10, 66, 9, 27, 65, 84, 16, 85, 14, 45, 91, 18, 69, 52, 43, 63, 3, 72, 60, 71, 51, 73, 22, 74, 64, 15, 76, 55, 7, 70, 92, 68, 39, 90, 21, 40, 93, 26, 57, 80, 54, 75, 67, 20, 25, 48, 50, 23, 0, 83, 49, 28, 88};
        Rotor5 = new Integer [] {33, 46, 82, 45, 35, 86, 42, 54, 49, 53, 26, 89, 64, 74, 76, 92, 63, 9, 3, 18, 56, 41, 48, 11, 59, 15, 17, 88, 91, 37, 47, 79, 27, 72, 94, 25, 6, 29, 39, 38, 58, 52, 55, 85, 60, 8, 16, 12, 24, 2, 44, 70, 28, 34, 67, 13, 21, 93, 4, 77, 40, 10, 84, 65, 71, 30, 69, 87, 75, 90, 22, 1, 57, 31, 23, 5, 20, 78, 80, 66, 14, 50, 83, 32, 68, 0, 61, 51, 36, 7, 43, 73, 81, 62, 19};
        Rotor6 = new Integer [] {24, 62, 26, 74, 54, 21, 48, 22, 32, 59, 91, 44, 87, 16, 0, 63, 52, 28, 15, 49, 76, 64, 17, 20, 38, 65, 39, 5, 10, 30, 13, 84, 68, 25, 53, 89, 80, 36, 11, 83, 47, 93, 82, 50, 27, 69, 9, 60, 77, 18, 71, 55, 12, 4, 41, 43, 81, 19, 31, 3, 35, 6, 23, 88, 85, 75, 92, 40, 8, 7, 45, 14, 37, 2, 70, 1, 67, 51, 42, 72, 33, 73, 57, 86, 66, 90, 79, 56, 94, 61, 58, 34, 46, 29, 78};
        Rotor7 = new Integer [] {13, 74, 63, 14, 23, 86, 89, 49, 33, 27, 51, 11, 91, 83, 6, 82, 60, 72, 39, 35, 42, 44, 58, 32, 12, 71, 16, 18, 70, 9, 40, 61, 31, 41, 80, 8, 0, 75, 77, 25, 43, 79, 50, 7, 69, 19, 34, 15, 48, 10, 38, 55, 22, 28, 93, 5, 26, 92, 76, 73, 85, 20, 88, 56, 29, 54, 45, 3, 66, 1, 21, 52, 62, 81, 94, 47, 17, 87, 57, 64, 78, 53, 4, 90, 36, 46, 84, 59, 68, 67, 37, 65, 30, 24, 2};
        Rotor8 = new Integer [] {40, 35, 3, 59, 72, 41, 13, 28, 92, 4, 39, 66, 32, 45, 87, 12, 11, 91, 89, 67, 10, 33, 37, 56, 81, 76, 63, 84, 15, 36, 62, 73, 16, 19, 42, 0, 53, 50, 47, 58, 75, 51, 54, 69, 80, 70, 64, 55, 52, 7, 86, 68, 23, 90, 57, 71, 27, 77, 88, 6, 31, 34, 43, 22, 78, 26, 48, 44, 94, 82, 18, 1, 83, 49, 74, 2, 17, 46, 20, 8, 14, 85, 38, 25, 93, 61, 60, 29, 24, 65, 30, 21, 5, 9, 79};
        Rotor9 = new Integer [] {52, 2, 23, 94, 31, 66, 65, 12, 69, 18, 85, 28, 17, 50, 26, 13, 11, 75, 46, 40, 93, 68, 57, 3, 83, 21, 43, 41, 8, 73, 84, 24, 25, 20, 92, 67, 14, 79, 90, 72, 78, 80, 37, 71, 58, 64, 19, 82, 27, 70, 36, 34, 15, 59, 39, 42, 10, 5, 47, 22, 33, 38, 29, 7, 74, 88, 77, 51, 6, 60, 89, 9, 0, 32, 49, 16, 87, 91, 30, 56, 35, 76, 45, 1, 48, 63, 44, 55, 62, 4, 54, 86, 61, 53, 81};
        Rotor0 = new Integer [] {59, 60, 69, 87, 86, 82, 29, 77, 2, 49, 51, 93, 91, 24, 79, 5, 4, 52, 64, 80, 19, 23, 28, 7, 18, 56, 39, 3, 61, 89, 32, 73, 27, 40, 75, 66, 53, 20, 85, 38, 65, 15, 83, 10, 76, 72, 84, 6, 47, 68, 26, 35, 45, 70, 44, 46, 34, 13, 62, 54, 81, 90, 33, 48, 88, 1, 41, 17, 43, 78, 0, 42, 74, 31, 30, 11, 12, 21, 22, 67, 50, 92, 14, 94, 16, 57, 37, 25, 36, 71, 55, 63, 9, 8, 58};
        Rotor1Inverse = new Integer[95];
        Rotor2Inverse = new Integer[95];
        Rotor3Inverse = new Integer[95];
        Rotor4Inverse = new Integer[95];
        Rotor5Inverse = new Integer[95];
        Rotor6Inverse = new Integer[95];
        Rotor7Inverse = new Integer[95];
        Rotor8Inverse = new Integer[95];
        Rotor9Inverse = new Integer[95];
        Rotor0Inverse = new Integer[95];
        //each inverse rotor fills from their respective standard rotor, using an intermediate hashmap.
        HashMap<Integer, Integer> RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor1[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor1Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor2[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor2Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor3[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor3Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor4[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor4Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor5[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor5Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor6[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor6Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor7[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor7Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor8[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor8Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor9[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor9Inverse[i] = RotorMapper.get(i);
        }
        RotorMapper = new HashMap<>(127, (float) 0.75);
        for (int q = 0; q < 95; q++) {
            RotorMapper.put(Rotor0[q], q);
        }
        for (int i = 0; i < 95; i++) {
            Rotor0Inverse[i] = RotorMapper.get(i);
        }
    }
    String Encrypt() {
        //creating the storage for the rotors we'll use in this encryption.
        Integer[][] RotorArray = new Integer[8][];
        //for generating the rotors to be used, just use the rotor number that corresponds to the digit in the date.
        //e.g. 09/09/2009 would use Rotor0, Rotor9, Rotor0, Rotor9, Rotor2, Rotor0, Rotor0, Rotor9.
        //if the date is only 7 digits long then the first digit must have been a zero. Thus use an instance of rotor 0 for that spot.
        if (Date.toString().length()==7) {
            RotorArray[0] = Rotor0;
            String StringDate = Date.toString();
            Scanner StringDateReader = new Scanner(StringDate).useDelimiter("");
            for (int q = 0; q < 7; q++) {
                int CurrentDigit = StringDateReader.nextInt();
                Integer[] NextRotor = null;
                switch (CurrentDigit) {
                    case 0: NextRotor = Rotor0;
                            break;
                    case 1: NextRotor = Rotor1;
                            break;
                    case 2: NextRotor = Rotor2;
                            break;
                    case 3: NextRotor = Rotor3;
                            break;
                    case 4: NextRotor = Rotor4;
                            break;
                    case 5: NextRotor = Rotor5;
                            break;
                    case 6: NextRotor = Rotor6;
                            break;
                    case 7: NextRotor = Rotor7;
                            break;
                    case 8: NextRotor = Rotor8;
                            break;
                    case 9: NextRotor = Rotor9;
                            break;
                }
                RotorArray[q+1] = NextRotor;
            }
        } else {
            String StringDate = Date.toString();
            Scanner StringDateReader = new Scanner(StringDate).useDelimiter("");
            for (int q = 0; q < 8; q++) {
                int CurrentDigit = StringDateReader.nextInt();
                Integer[] NextRotor = null;
                switch (CurrentDigit) {
                    case 0: NextRotor = Rotor0;
                        break;
                    case 1: NextRotor = Rotor1;
                        break;
                    case 2: NextRotor = Rotor2;
                        break;
                    case 3: NextRotor = Rotor3;
                        break;
                    case 4: NextRotor = Rotor4;
                        break;
                    case 5: NextRotor = Rotor5;
                        break;
                    case 6: NextRotor = Rotor6;
                        break;
                    case 7: NextRotor = Rotor7;
                        break;
                    case 8: NextRotor = Rotor8;
                        break;
                    case 9: NextRotor = Rotor9;
                        break;
                }
                RotorArray[q] = NextRotor;
            }
        }
        StringBuilder Cyphertext = new StringBuilder();
        Scanner PlaintextReader = new Scanner(PlainText).useDelimiter("");
        int FirstRotorIncrement = 0;
        int SecondRotorIncrement = 0;
        int ThirdRotorIncrement = 0;
        int FourthRotorIncrement = 0;
        int FifthRotorIncrement = 0;
        int SixthRotorIncrement = 0;
        int SeventhRotorIncrement = 0;
        int EighthRotorIncrement = 0;
        while (PlaintextReader.hasNext()) {
            String CurrentChar = PlaintextReader.next();
            int CurrentCharValue = CharToNumbersKey.get(CurrentChar);
            //Here's the actual encryption part: Starting with the integer value of the current character, it
            //puts it through the first rotor mapping, and takes the output and puts it through the second rotor, and
            //so on all the way through the 8th rotor.
            int EncryptingCharValue;
            assert RotorArray[0] != null;
            //Taking into account the rotor increments, and if it should wrap around the rotor the if statement
            //accomplishes that for each rotor.
            int RotorValue = CurrentCharValue + FirstRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[0][RotorValue];
            assert RotorArray[1] != null;
            RotorValue = EncryptingCharValue + SecondRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[1][RotorValue];
            RotorValue = EncryptingCharValue + ThirdRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[2][RotorValue];
            RotorValue = EncryptingCharValue + FourthRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[3][RotorValue];
            RotorValue = EncryptingCharValue + FifthRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[4][RotorValue];
            RotorValue = EncryptingCharValue + SixthRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[5][RotorValue];
            RotorValue = EncryptingCharValue + SeventhRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[6][RotorValue];
            RotorValue = EncryptingCharValue + EighthRotorIncrement;
            if (RotorValue>95) {
                RotorValue = RotorValue-95;
            }
            EncryptingCharValue = RotorArray[7][RotorValue];

            //we now have our final value for our encrypted character, so let's use the key to translate it back to our
            //standard ASCII alphabet, and append it to the cyphertext string. The -1 is for zero indexing
            Cyphertext.append(NumbersToCharKey[EncryptingCharValue-1]);
            //this part handles rotor iteration. If the first one cycles once, it increments the next one, and so on
            FirstRotorIncrement ++;
            if (FirstRotorIncrement > 95) {
                FirstRotorIncrement = 0;
                SecondRotorIncrement++;
            }
            if (SecondRotorIncrement > 95) {
                SecondRotorIncrement = 0;
                ThirdRotorIncrement ++;
            }
            if (ThirdRotorIncrement > 95) {
                ThirdRotorIncrement = 0;
                FourthRotorIncrement++;
            }
            if (FourthRotorIncrement > 95) {
                FourthRotorIncrement = 0;
                FifthRotorIncrement++;
            }
            if (FifthRotorIncrement > 95) {
                FifthRotorIncrement = 0;
                SixthRotorIncrement++;
            }
            if (SixthRotorIncrement > 95) {
                SixthRotorIncrement = 0;
                SeventhRotorIncrement++;
            }
            if (SeventhRotorIncrement > 95) {
                SeventhRotorIncrement = 0;
                EighthRotorIncrement++;
            }
            if (EighthRotorIncrement > 95) {
                EighthRotorIncrement = 0;
            }
        }
        return Cyphertext.toString();
    }
    String Decrypt () {
        //creating the storage for the rotors we'll use in this decryption.
        Integer[][] InverseRotorArray = new Integer[8][];
        //for generating the rotors to be used, just use the rotor number that corresponds to the digit in the date.
        //e.g. 09/09/2009 would use Rotor0, Rotor9, Rotor0, Rotor9, Rotor2, Rotor0, Rotor0, Rotor9.
        //if the date is only 7 digits long then the first digit must have been a zero. Thus use an instance of rotor 0 for that spot.
        if (Date.toString().length()==7) {
            InverseRotorArray[0] = Rotor0Inverse;
            String StringDate = Date.toString();
            Scanner StringDateReader = new Scanner(StringDate).useDelimiter("");
            for (int q = 0; q < 7; q++) {
                int CurrentDigit = StringDateReader.nextInt();
                Integer[] NextInverseRotor = null;
                switch (CurrentDigit) {
                    case 0: NextInverseRotor = Rotor0Inverse;
                        break;
                    case 1: NextInverseRotor = Rotor1Inverse;
                        break;
                    case 2: NextInverseRotor = Rotor2Inverse;
                        break;
                    case 3: NextInverseRotor = Rotor3Inverse;
                        break;
                    case 4: NextInverseRotor = Rotor4Inverse;
                        break;
                    case 5: NextInverseRotor = Rotor5Inverse;
                        break;
                    case 6: NextInverseRotor = Rotor6Inverse;
                        break;
                    case 7: NextInverseRotor = Rotor7Inverse;
                        break;
                    case 8: NextInverseRotor = Rotor8Inverse;
                        break;
                    case 9: NextInverseRotor = Rotor9Inverse;
                        break;
                }
                InverseRotorArray[q+1] = NextInverseRotor;
            }
        } else {
            String StringDate = Date.toString();
            Scanner StringDateReader = new Scanner(StringDate).useDelimiter("");
            for (int q = 0; q < 8; q++) {
                int CurrentDigit = StringDateReader.nextInt();
                Integer[] NextInverseRotor = null;
                switch (CurrentDigit) {
                    case 0: NextInverseRotor = Rotor0Inverse;
                        break;
                    case 1: NextInverseRotor = Rotor1Inverse;
                        break;
                    case 2: NextInverseRotor = Rotor2Inverse;
                        break;
                    case 3: NextInverseRotor = Rotor3Inverse;
                        break;
                    case 4: NextInverseRotor = Rotor4Inverse;
                        break;
                    case 5: NextInverseRotor = Rotor5Inverse;
                        break;
                    case 6: NextInverseRotor = Rotor6Inverse;
                        break;
                    case 7: NextInverseRotor = Rotor7Inverse;
                        break;
                    case 8: NextInverseRotor = Rotor8Inverse;
                        break;
                    case 9: NextInverseRotor = Rotor9Inverse;
                        break;
                }
                InverseRotorArray[q] = NextInverseRotor;
            }
        }
        StringBuilder Cyphertext = new StringBuilder();
        Scanner PlaintextReader = new Scanner(PlainText).useDelimiter("");
        int FirstRotorIncrement = 0;
        int SecondRotorIncrement = 0;
        int ThirdRotorIncrement = 0;
        int FourthRotorIncrement = 0;
        int FifthRotorIncrement = 0;
        int SixthRotorIncrement = 0;
        int SeventhRotorIncrement = 0;
        int EighthRotorIncrement = 0;
        while (PlaintextReader.hasNext()) {
            String CurrentChar = PlaintextReader.next();
            int EncryptingCharValue = CharToNumbersKey.get(CurrentChar);
            //Here's the actual encryption part: Starting with the integer value of the current character, it
            //puts it through the first rotor mapping, and takes the output and puts it through the second rotor, and
            //so on all the way through the 8th rotor.
            EncryptingCharValue = InverseRotorArray[7][EncryptingCharValue] - EighthRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            EncryptingCharValue = InverseRotorArray[6][EncryptingCharValue] - SeventhRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            EncryptingCharValue = InverseRotorArray[5][EncryptingCharValue] - SixthRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            EncryptingCharValue = InverseRotorArray[4][EncryptingCharValue] - FifthRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            EncryptingCharValue = InverseRotorArray[3][EncryptingCharValue] - FourthRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            EncryptingCharValue = InverseRotorArray[2][EncryptingCharValue] - ThirdRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            assert InverseRotorArray[1] != null;
            EncryptingCharValue = InverseRotorArray[1][EncryptingCharValue] - SecondRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }
            assert InverseRotorArray[0] != null;
            EncryptingCharValue = InverseRotorArray[0][EncryptingCharValue] - FirstRotorIncrement;
            if (EncryptingCharValue<0) {
                EncryptingCharValue = EncryptingCharValue + 95;
            }

            //we now have our final value for our encrypted character, so let's use the key to translate it back to our
            //standard ASCII alphabet, and append it to the cyphertext string. The -1 is for zero indexing
            Cyphertext.append(NumbersToCharKey[EncryptingCharValue-1]);
            //this part handles rotor iteration. If the first one cycles once, it increments the next one, and so on
            FirstRotorIncrement ++;
            if (FirstRotorIncrement > 95) {
                FirstRotorIncrement = 0;
                SecondRotorIncrement++;
            }
            if (SecondRotorIncrement > 95) {
                SecondRotorIncrement = 0;
                ThirdRotorIncrement ++;
            }
            if (ThirdRotorIncrement > 95) {
                ThirdRotorIncrement = 0;
                FourthRotorIncrement++;
            }
            if (FourthRotorIncrement > 95) {
                FourthRotorIncrement = 0;
                FifthRotorIncrement++;
            }
            if (FifthRotorIncrement > 95) {
                FifthRotorIncrement = 0;
                SixthRotorIncrement++;
            }
            if (SixthRotorIncrement > 95) {
                SixthRotorIncrement = 0;
                SeventhRotorIncrement++;
            }
            if (SeventhRotorIncrement > 95) {
                SeventhRotorIncrement = 0;
                EighthRotorIncrement++;
            }
            if (EighthRotorIncrement > 95) {
                EighthRotorIncrement = 0;
            }
        }
        return Cyphertext.toString();
    }
}
