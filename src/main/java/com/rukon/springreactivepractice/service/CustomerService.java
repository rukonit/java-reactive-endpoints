package com.rukon.springreactivepractice.service;

import com.rukon.springreactivepractice.dao.CustomerDao;
import com.rukon.springreactivepractice.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Total exec time: " + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomerSteam() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Total exec time: " + (end - start));
        return customers;
    }

}
