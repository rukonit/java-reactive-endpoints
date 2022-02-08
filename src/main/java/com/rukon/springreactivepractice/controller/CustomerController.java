package com.rukon.springreactivepractice.controller;

import com.rukon.springreactivepractice.dto.Customer;
import com.rukon.springreactivepractice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping()
    private List<Customer> getAllCustomers() {
        return service.loadAllCustomer();    }


    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomerSteam();    }
}
