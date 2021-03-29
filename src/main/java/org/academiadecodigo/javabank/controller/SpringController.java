package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SpringController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        CustomerDao customerDao = new JpaCustomerDao();

        customerList(customerDao.findAll());

        return "index";

    }

    @ModelAttribute("customer")
    public List<Customer> customerList(List<Customer> list){
        return list;

    }
}
