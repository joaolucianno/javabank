package org.academiadecodigo.javabank.util;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {
    //Fields
    private final Prompt PROMPT = new Prompt(System.in, System.out);
    private final MenuInputScanner scanner;
    private final String[] OPTIONS;


    //Constructor
    public Menu(String[] options){
        OPTIONS = options;
        scanner = new MenuInputScanner(OPTIONS);
    }

    //Custom Methods
    public void showMenu(String message, String error){
        scanner.setMessage(message);
        scanner.setError(error);
    }

    public int getUserInput(){
        return PROMPT.getUserInput(scanner);
    }





}
