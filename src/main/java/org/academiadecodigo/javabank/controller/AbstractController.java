package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A generic controller to be used as a base for concrete controller implementations
 *
 * @see Controller
 */
public abstract class AbstractController implements Controller {

    protected AuthService authService;
    protected View view;

    /**
     * Sets the authentication service
     *
     * @param authService the authentication service to set
     */
    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Sets the controller view
     *
     * @param view the view to be set
     */
    @Autowired
    public void setView(View view) {
        this.view = view;
    }

    /**
     * @see Controller#init()
     */
    @Override
    public void init() {
        view.show();
    }
}
