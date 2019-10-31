package com.borntocode;

import java.util.InputMismatchException;
import java.util.Scanner;

class RSAkeyGen {

    private Scanner IN = new Scanner(System.in);


    public static void main(String[] args) {
        RSAkeyGen keyGen = new RSAkeyGen();
        keyGen.prepareToGenerate();

        int keyLength = keyGen.KEYSIZE.get(keyGen.getKeyFromUser());

        keyGen.generator(keyLength);
        keyGen.displayInfoAboutKeys();
        keyGen.mainFlowControl();

    }

    private int getKeyFromUser() {
        out.println();
        out.println("Please type a digit for strength of RSA:");
        out.println();

        for (Integer k : KEYSIZE.keySet()) {
            Integer v = KEYSIZE.get(k);
            out.print(k + ". " + v + " / ");
        }

        out.println();

        int key;
        IN.hasNextInt();
        key = IN.nextInt();
        IN.nextLine();
        return key;
    }

    private void mainFlowControl() {
        String ans = null;

        out.println();
        out.println(
                "Do you want print buffer in this console(buffer are cleared " +
                        "after end of program)? [ Y/N ]\nIf 'N' keys will automatically " +
                        "saved to files without printing in this console.");
        out.println();
        out.println("'Q' terminate process.");

        try {
            while (ans == null) {
                ans = IN.findInLine("[ynqYNQ]");
                IN.nextLine();
                if (ans.equalsIgnoreCase("Y")) {
                    printKeysToConsole();
                } else if (ans.equalsIgnoreCase("N")) {
                    saveKeysToFiles();
                } else if (ans.equalsIgnoreCase("Q")) {
                    IN.close();
                    out.close();
                    System.exit(0);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Bad choice. Try again.. or quit 'Q'");
        } finally {
            mainFlowControl();
        }
    }

    private void displayInfoAboutKeys() {
        out.println();
        out.println(txt.[2].toLowerCase() + ": " + privateKey.getFormat());
        out.println(txt.[3].toLowerCase() + ": " + privateKey.getAlgorithm());
        out.println();
        out.println(txt.[6].toLowerCase() + ": " + publicKey.getFormat());
        out.println(txt.[7].toLowerCase() + ": " + publicKey.getAlgorithm());
    }

    private void printKeysToConsole() {
        out.print(txt.[0]);
        out.print(ENCODER.encodeToString(privateKey.getEncoded()));
        out.print(txt.[4]);

        out.println();
        out.println();

        out.print(txt.[1]);
        out.print(ENCODER.encodeToString(publicKey.getEncoded()));
        out.print(txt.[5]);
        out.println();
    }


}
