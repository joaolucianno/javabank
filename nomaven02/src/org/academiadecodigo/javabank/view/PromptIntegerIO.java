package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;

public class PromptIntegerIO extends AbsPrompt{
    //Fields
    private static final IntegerInputScanner scannerInt = new IntegerInputScanner();


    //Integer
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
