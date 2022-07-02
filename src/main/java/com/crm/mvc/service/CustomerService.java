package com.crm.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.mvc.dao.CustomerDAO;
import com.crm.mvc.model.Customer;

 
@Service
@Transactional
public class CustomerService{
 
    @Autowired
    private CustomerDAO customerDAO;
 
    
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }
 
    
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomer();
    }
 
    @Transactional
    public void deleteCustomer(Integer customerId) {
        customerDAO.deleteCustomer(customerId);
    }
 
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }
 
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }
 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
}
