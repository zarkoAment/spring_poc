package hr.asseco.see.poc.springtesting.service.impl;

import hr.asseco.see.poc.springtesting.persistence.model.CustomerPersistence;
import hr.asseco.see.poc.springtesting.persistence.repository.CustomerRepository;
import hr.asseco.see.poc.springtesting.rest.model.CustomerRest;
import hr.asseco.see.poc.springtesting.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerRest> getAllCustomers() {
		List<CustomerPersistence> customerPersistenceList = this.customerRepository.findAll();
		
		List<CustomerRest> customerRestList = new ArrayList<>();
		customerPersistenceList.forEach(customerPersistence -> {
			CustomerRest customerRest = new CustomerRest(customerPersistence);
			customerRestList.add(customerRest);
		});
		
		return customerRestList;
	}
	
	@Override
	public List<CustomerRest> getCustomerByName(@NotBlank String name) {
		List<CustomerPersistence> customerPersistenceList = this.customerRepository.findByName(name);
		
		List<CustomerRest> customerRestList = new ArrayList<>();
		customerPersistenceList.forEach(customerPersistence -> {
			CustomerRest customerRest = new CustomerRest(customerPersistence);
			customerRestList.add(customerRest);
		});
		
		return customerRestList;
	}
	
	@Override
	public CustomerRest createNewCustomer(@NotNull CustomerRest customerRest) {
		CustomerPersistence customerPersistence = new CustomerPersistence(customerRest);
		CustomerPersistence createdCustomerPersistence = this.customerRepository.save(customerPersistence);
		
		CustomerRest createdCustomerRest = new CustomerRest(createdCustomerPersistence);
		return createdCustomerRest;
	}
	
	@Override
	public CustomerRest getCustomerById(@NotNull Long id) {
		Optional<CustomerPersistence> customerPersistenceOptional = this.customerRepository.findById(id);
		
		CustomerRest customerRest = new CustomerRest(customerPersistenceOptional.orElseGet(CustomerPersistence::new));
		
		return customerRest;
	}
	
	@Override
	public void deleteCustomer(@NotNull Long id) {
		this.customerRepository.deleteById(id);
	}
	
	@Override
	public CustomerRest updateCustomer(@NotNull Long id, @NotNull CustomerRest customerRest) {
		Optional<CustomerPersistence> customerPersistenceOptional = this.customerRepository.findById(id);
		
		if (customerPersistenceOptional.isPresent()) {
			CustomerPersistence customerPersistence = customerPersistenceOptional.get();
			customerPersistence.setName(customerRest.getName());
			customerPersistence.setEmail(customerRest.getEmail());
			
			CustomerPersistence updatedCustomerPersistence = this.customerRepository.save(customerPersistence);
			return new CustomerRest(updatedCustomerPersistence);
		} else {
			return new CustomerRest();
		}
	}
}
