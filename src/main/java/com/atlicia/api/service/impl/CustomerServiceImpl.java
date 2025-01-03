package com.atlicia.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlicia.api.accessors.CustomerRepository;
import com.atlicia.api.accessors.models.Customer;
import com.atlicia.api.model.CustomerCreate;
import com.atlicia.api.model.CustomerDTO;
import com.atlicia.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<CustomerDTO> getCustomer(UUID id) {
        return customerRepository.findById(id)
        .map(customer -> modelMapper.map(customer, CustomerDTO.class));

    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createCustomer(CustomerCreate customerCreate) {
        Customer customer = modelMapper.map(customerCreate, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDTO.class);
    }
    
}
