package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;

import java.util.Set;

public class PromptIntegerSetIO extends AbsPrompt{
    //Fields
    private static IntegerSetInputScanner scannerInt;


    //IntegerSet
    public static void setScannerInt(Set<Integer> customers){
        scannerInt = new IntegerSetInputScanner(customers);
    }

    public static void prepareIO(String message, String error){
        scannerInt.setMessage(message);
        scannerInt.setError(error);
    }

    public static void error(){
        scannerInt.error(System.out);
    }

    public static int getUserInput(){
        return PROMPT.getUserInput(scannerInt);
    }
}
