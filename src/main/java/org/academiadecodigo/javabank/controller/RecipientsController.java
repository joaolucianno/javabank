package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.RecipientsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The {@link RecipientsView} controller
 */
@Controller
@RequestMapping("/recipients")
public class RecipientsController extends AbstractController {

    private CustomerService customerService;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Gets a list of the customer recipients
     *
     * @return the recipient list
     * @see CustomerService#listRecipients(Integer)
     */
    public List<Recipient> getRecipients() {
        Customer customer = authService.getAccessingCustomer();
        return customerService.listRecipients(customer.getId());
    }
}
