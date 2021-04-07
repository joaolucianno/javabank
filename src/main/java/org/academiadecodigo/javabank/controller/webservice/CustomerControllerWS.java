package org.academiadecodigo.javabank.controller.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.javabank.dto.AccountDTO;
import org.academiadecodigo.javabank.dto.CustomerDTO;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.DataInput;
import java.io.IOException;
import java.util.List;

import static org.academiadecodigo.javabank.dto.ConvertDTO.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@RestController
public class CustomerControllerWS {
    //Fields
    private CustomerService customerService;

    //Custom Methods
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/customers"})
    public ResponseEntity<List<CustomerDTO>> getListCustomers(){
        return new ResponseEntity<>(convertCustomerList(customerService.list()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/customer/{id}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id){
        return new ResponseEntity<>(convertCustomerWithOutAccounts(customerService.get(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/customerAccountList/{id}"})
    public ResponseEntity<List<AccountDTO>> getAccounts(@PathVariable Integer id){

        return new ResponseEntity<>(
                convertCustomerWithAccounts(customerService.get(id)).getAccountDTOList(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/customer/{idC}/account/{idA}"})
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Integer idC, @PathVariable Integer idA){

        return new ResponseEntity<>(
                convertAccountTODTO(customerService
                        .get(idC).getAccounts()
                        .stream()
                        .filter(account -> account.getId() == idA)
                        .findFirst()
                        .orElseThrow(), convertCustomerWithOutAccounts(customerService.get(idC)) ),
                HttpStatus.OK);
    }


//    @RequestMapping(method = RequestMethod.POST, path = {"/addCustomer"})
//    public ResponseEntity<String> addCustomer(
//            @RequestParam(name = "firstname") String firstName,
//            @RequestParam(name = "lastname") String lastName,
//            @RequestParam(name = "email") String email,
//            @RequestParam(name = "phone") String phone){
//
//        Customer customer = new Customer();
//        customer.setFirstName(firstName);
//        customer.setLastName(lastName);
//        customer.setEmail(email);
//        customer.setPhone(phone);
//        customerService.add(customer);
//
//        return new ResponseEntity<>("User " + customer.getFirstName() + " has added successfully", HttpStatus.OK);
//
//    }

    //Add User Json
    @RequestMapping(method = RequestMethod.POST, path = {"/addCustomer"})
    public ResponseEntity<String> addCustomerJSON(@Valid @RequestBody CustomerDTO customer, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            System.out.println("ERROR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.add(convertCustomerDTOToNewCustomer(customer));

        return new ResponseEntity<>("User " + customer.getFirstName() + " has added successfully", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/customer/{id}/edit"})
    public ResponseEntity<CustomerDTO> edit(@Valid @RequestBody CustomerDTO customerEdit,
                                            @PathVariable Integer id,
                                            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("ERROR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = convertCustomerDTOToCustomerEdit(customerEdit, customerService.get(id));
        customerService.add(customer);

        return new ResponseEntity<>(convertCustomerWithOutAccounts(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/customer/edit"})
    public ResponseEntity<CustomerDTO> editIdOnBody(@Valid @RequestBody CustomerDTO customerEdit,
                                            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("ERROR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = convertCustomerDTOToCustomerEdit(customerEdit, customerService.get(customerEdit.getId()));
        customerService.add(customer);

        return new ResponseEntity<>(convertCustomerWithOutAccounts(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/customer/{id}/delete"})
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Customer customer = customerService.get(id);
        customerService.delete(id);

        return new ResponseEntity<>("User " + customer.getFirstName() + " has been delete.", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/customer/{idC}/deleteAcc/{idA}"})
    public ResponseEntity<String> deleteAccount(@PathVariable Integer idC, @PathVariable Integer idA){
        Customer customer = customerService.get(idC);
        customer.removeAccount(
                customer.getAccounts()
                .stream()
                .filter(account -> account.getId() == idA)
                .findFirst()
                .orElseThrow());

        customerService.add(customer);


        return new ResponseEntity<>(
                "Account id " + idA + " from Client id " + idC + "has been erase.", HttpStatus.OK);
    }

}
