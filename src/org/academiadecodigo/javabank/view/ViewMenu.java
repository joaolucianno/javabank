package org.academiadecodigo.javabank.view;

import static org.academiadecodigo.javabank.application.Messages.*;

public class ViewMenu {
    //Fields

    public int showMenu(String[] opt){
        PromptMenu.setOpt(opt);
        PromptMenu.prepareMenu(MENU, ERROR_INVALID_OPTION);
        return PromptMenu.getUserInputMenu();
    }

    public void quit(){
        try{
            System.out.print(EXIT);
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
        } catch (InterruptedException ignore){}
        finally {
            System.exit(0);
        }
    }
}
