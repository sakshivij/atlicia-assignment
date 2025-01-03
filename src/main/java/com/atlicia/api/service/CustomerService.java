package com.atlicia.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.atlicia.api.model.CustomerCreate;
import com.atlicia.api.model.CustomerDTO;

public interface CustomerService {
    Optional<CustomerDTO> getCustomer(UUID id);
    List<CustomerDTO> getCustomers();
    CustomerDTO createCustomer(CustomerCreate customerCreate);
}