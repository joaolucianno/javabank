package org.academiadecodigo.javabank.controller.webapplication;

import org.academiadecodigo.javabank.dto.ConvertDTO;
import org.academiadecodigo.javabank.dto.CustomerDTO;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.academiadecodigo.javabank.persistence.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.academiadecodigo.javabank.dto.ConvertDTO.*;

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

    //List
    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public String listCustomers(Model model) {
        List<CustomerDTO> customerDTOList = convertCustomerList(customerService.list());
        model.addAttribute("customers", customerDTOList);
        return "customer/list";
    }

    //Details
    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String detail(Model model, @PathVariable Integer id){
        CustomerDTO customerDTO = convertCustomerWithAccounts(customerService.get(id));

        model.addAttribute("customer", customerDTO);
        model.addAttribute("accounts", customerDTO.getAccountDTOList());
        model.addAttribute("getBalance", customerService.getBalance(id));
        //model.addAttribute("accountDTO", new AccountDTO());
        return "customer/details";
    }

    //Add
    @RequestMapping(method = RequestMethod.GET, path = {"/newCustomer"})
    public String add(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("customerDTO", customerDTO);
        return "customer/addEdit";
    }

    //Edit
    @RequestMapping(method = RequestMethod.GET, path = {"/edit/{id}"})
    public String Edit(Model model, @PathVariable Integer id){
        CustomerDTO customerDTO = convertCustomerWithOutAccounts(customerService.get(id));
        model.addAttribute("customerDTO", customerDTO);
        return "customer/addEdit";
    }

    //Delete
    @RequestMapping(method = RequestMethod.GET, path = {"/delete/{id}"})
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/";
    }

    //Submit Add or Edit
    @RequestMapping(method = RequestMethod.POST, path = {"/submitCustomer"})
    public String submitCustomerAddEdit(@Valid @ModelAttribute("customerDTO") CustomerDTO customerSubmit,
                                        BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "customer/addEdit";
        }

        if(customerSubmit.getId() == null){
            customerService.add(convertCustomerDTOToNewCustomer(customerSubmit));
        } else{
            Customer customer = convertCustomerDTOToCustomerEdit(customerSubmit, customerService.get(customerSubmit.getId()));
            customerService.add(customer);
        }

        return "redirect:/";
    }

    //Add Account
    @RequestMapping(method = RequestMethod.POST, path = {"/add/{id}"})
    public String addAccount(@PathVariable Integer id,
                             @RequestParam("balance") Double balance,
                             @RequestParam("accountType")AccountType accountType){
        System.out.println("ADD Account");
        Customer customer = customerService.get(id);

        AccountFactory accountFactory = new AccountFactory();
        Account acc = accountFactory.createAccount(accountType);
        acc.setCustomer(customer);
        acc.credit(balance);
        customer.addAccount(acc);
        customerService.add(customer);
        return "redirect:/customer/" + id;
    }

    //Delete Account
    @RequestMapping(method = RequestMethod.GET, path = {"/{idCustomer}/deleteAccount/{idAccount}"})
    public String deleteAccount(@PathVariable(name = "idCustomer") Integer idC, @PathVariable(name = "idAccount") Integer idA){
        System.out.println("DELETE ACCOUNT");
        Customer customer = customerService.get(idC);

        customer.removeAccount(searchAccount(customer, idA));

        customerService.add(customer);

        return "redirect:/customer/" + idC;
    }

    public Account searchAccount(Customer customer, Integer idA){

        return customer.getAccounts()
                .stream()
                .filter(account -> account.getId() == idA)
                .findFirst()
                .orElseThrow();
    }

}
