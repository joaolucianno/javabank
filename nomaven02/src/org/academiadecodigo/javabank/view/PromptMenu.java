package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class PromptMenu {
    //Fields
    private static final Prompt PROMPT = new Prompt(System.in, System.out);
    private static MenuInputScanner scanner;

    //Setters
    public static void setOpt(String[] opt){
        scanner = new MenuInputScanner(opt);
    }


    public static void prepareMenu(String message, String error){

        scanner.setMessage(message);
        scanner.setError(error);
    }

    public static int getUserInputMenu(){
        return PROMPT.getUserInput(scanner);
    }
}
