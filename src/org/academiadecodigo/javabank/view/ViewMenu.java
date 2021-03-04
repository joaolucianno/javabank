package org.academiadecodigo.javabank.view;

import static org.academiadecodigo.javabank.application.Messages.*;

public class ViewMenu {
    //Fields

    public int showMenu(String[] opt){
        PromptMenu.setOpt(opt);
        PromptMenu.prepareMenu(MENU, ERROR_INVALID_OPTION);
        return PromptMenu.getUserInputMenu();
    }
}
