package org.academiadecodigo.javabank.util;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {
    //Fields
    private final Prompt PROMPT = new Prompt(System.in, System.out);
    private MenuInputScanner scanner;
    private String[] OPTIONS;




    //Setters


    public void setOPTIONS(String[] OPTIONS) {
        this.OPTIONS = OPTIONS;
        scanner = new MenuInputScanner(OPTIONS);
    }

    //Custom Methods
    public void prepareMenu(String message, String error){
        scanner.setMessage(message);
        scanner.setError(error);
    }

    public int getUserInput(){
        return PROMPT.getUserInput(scanner);
    }





}
