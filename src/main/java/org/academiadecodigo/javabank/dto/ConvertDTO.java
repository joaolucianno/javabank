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

    public static Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customer;
    }
}
