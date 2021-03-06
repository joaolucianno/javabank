package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;

public class PromptDoubleIO extends AbsPrompt{
    //Fields
    private static final DoubleInputScanner scannerDouble = new DoubleInputScanner();


    //Integer
    public static void prepareIO(String message, String error){
        scannerDouble.setMessage(message);
        scannerDouble.setError(error);
    }

    public static void error(){
        scannerDouble.error(System.out);
    }

    public static double getUserInput(){
        return PROMPT.getUserInput(scannerDouble);
    }
}
