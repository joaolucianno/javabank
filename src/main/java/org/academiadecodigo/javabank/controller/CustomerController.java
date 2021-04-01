package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.dto.ConvertDTO;
import org.academiadecodigo.javabank.dto.CustomerDTO;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller responsible for rendering {@link Customer} related views
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

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
     * Renders a view with a list of customers
     *
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public String listCustomers(Model model) {
        List<CustomerDTO> customerDTOList = ConvertDTO.convertCustomerList(customerService.list());
        model.addAttribute("customers", customerDTOList);
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String detail(Model model, @PathVariable Integer id){
        CustomerDTO customerDTO = ConvertDTO.convertCustomerWithAccounts(customerService.get(id));

        model.addAttribute("customer", customerDTO);
        model.addAttribute("accounts", customerDTO.getAccountDTOList());
        model.addAttribute("balance", customerService.getBalance(id));
        return "customer/details";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/newCustomer"})
    public String add(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("customerDTO", customerDTO);
        return "customer/addEdit";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/edit/{id}"})
    public String Edit(Model model, @PathVariable Integer id){
        CustomerDTO customerDTO = ConvertDTO.convertCustomerWithOutAccounts(customerService.get(id));
        model.addAttribute("customerDTO", customerDTO);
        return "customer/addEdit";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/delete/{id}"})
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/submitCustomer"})
    public String submitCustomer(@ModelAttribute Customer customerSubmit,@PathVariable(required = false) Integer id){
        customerService.add(customerSubmit);

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/submitCustomer/{id}", "/submitCustomer/"})
    public String submitCustomerEdit(@Valid @ModelAttribute("customerDTO") CustomerDTO customerSubmit,
                                     BindingResult bindingResult,
                                     @PathVariable(required = false) Integer id,
                                     RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "customer/newCustomer";


        }

        if(id == null){
            customerService.add(ConvertDTO.convertCustomerDTOToCustomer(customerSubmit));
        } else{
            Customer customer = customerService.get(id);
            customer.setFirstName(customerSubmit.getFirstName());
            customer.setLastName(customerSubmit.getLastName());
            customer.setEmail(customerSubmit.getEmail());
            customer.setPhone(customerSubmit.getPhone());
            customerService.add(customer);
        }

        return "redirect:/";
    }



}
