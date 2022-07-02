package com.crm.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crm.mvc.model.Customer;
import com.crm.mvc.service.CustomerService;
 
@Controller
@RequestMapping("/")
public class CustomerController {
 
    private static final Logger logger = Logger
            .getLogger(CustomerController.class);
 
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value = "/listCustomer")
    public ModelAndView listCustomer(ModelAndView model) throws IOException {
        List<Customer> listCutomers = customerService.getAllCustomers();
        model.addObject("customers", listCutomers);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public ModelAndView newCustomer(ModelAndView model) {
        Customer customer = new Customer();
        model.addObject("customer", customer);
        model.setViewName("CustomerForm");
        return model;
    }
 
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        if (customer.getId() == 0) {
            customerService.addCustomer(customer);
        } else {
            customerService.updateCustomer(customer);
        }
        return new ModelAndView("redirect:/listCustomer");
    }
 
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(HttpServletRequest request) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(customerId);
        return new ModelAndView("redirect:/listCustomer");
    }
 
    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
    public ModelAndView editCustomer(HttpServletRequest request) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomer(customerId);
        ModelAndView model = new ModelAndView("CustomerForm");
        model.addObject("customer", customer);
 
        return model;
    }
 
}