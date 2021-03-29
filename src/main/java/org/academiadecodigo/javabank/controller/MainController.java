package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.view.MainView;
import org.academiadecodigo.javabank.view.Messages;
import org.academiadecodigo.javabank.view.UserOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.Map;

/**
 * The {@link MainView} controller
 */
@org.springframework.stereotype.Controller
@Profile("prod")
public class MainController extends AbstractController {

    private Map<Integer, Controller> controllerMap;

    /**
     * Sets the controller map, responsible for the mapping between the menu options and the respective controller
     *
     * @param controllerMap the controller map to set
     */
    @Autowired
    public void setControllerMap(Map<Integer, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    /**
     * Gets the customer name
     *
     * @return the customer name
     */
    public String getCustomerName() {
        Customer customer = authService.getAccessingCustomer();
        return customer.getFirstName() + " " + customer.getLastName();
    }

    /**
     * Invokes the next controller based on menu selection
     *
     * @param option the option chosen
     */
    public void onMenuSelection(int option) {

        if (option == UserOptions.QUIT.getOption()) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        controllerMap.get(option).init();
        init();
    }
}
