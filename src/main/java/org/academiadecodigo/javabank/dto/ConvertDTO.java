package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.account.Account;

import java.util.LinkedList;
import java.util.List;

public class ConvertDTO {

    public static CustomerDTO convertCustomerWithAccounts(Customer customerModel){
        Customer customer = customerModel;
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());

        for (Account account : customer.getAccounts()) {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(account.getId());
            accountDTO.setBalance(account.getBalance());
            accountDTO.setAccountType(account.getAccountType());
            accountDTO.setCustomerId(customerDTO);
            customerDTO.getAccountDTOList().add(accountDTO);
        }

        return customerDTO;
    }

    public static CustomerDTO convertCustomerWithOutAccounts(Customer customerModel){
        Customer customer = customerModel;
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());

        return customerDTO;
    }

    public static List<CustomerDTO> convertCustomerList(List<Customer> customerList){
        List<CustomerDTO> customerDTOList = new LinkedList<>();

        for (Customer customer : customerList) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setPhone(customer.getPhone());
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    public static Customer convertCustomerDTOToNewCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customer;
    }

    public static Customer convertCustomerDTOToCustomerEdit(CustomerDTO customerSubmit, Customer customerEdit){

        if((customerSubmit.getFirstName() != null) && !(customerSubmit.getFirstName().equals(customerEdit.getFirstName()))){
            customerEdit.setFirstName(customerSubmit.getFirstName());
        }
        if((customerSubmit.getLastName() != null) && !(customerSubmit.getLastName().equals(customerEdit.getLastName()))){
            customerEdit.setLastName(customerSubmit.getLastName());
        }
        if((customerSubmit.getEmail() != null) && !(customerSubmit.getEmail().equals(customerEdit.getEmail()))){
            customerEdit.setEmail(customerSubmit.getEmail());
        }
        if((customerSubmit.getPhone() != null) && !(customerSubmit.getPhone().equals(customerEdit.getPhone()))){
            customerEdit.setPhone(customerSubmit.getPhone());
        }

        return customerEdit;
    }

    public static AccountDTO convertAccountTODTO(Account account, CustomerDTO customerDTO){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setCustomerId(customerDTO);

        return accountDTO;
    }

}
